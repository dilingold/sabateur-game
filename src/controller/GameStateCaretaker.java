package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import model.Board;
import model.Deck;
import model.Player;
import model.cards.Card;
import model.cards.PathCard;
import view.AddPlayerView;
import view.GameView;
import view.RefreshBoard;

public class GameStateCaretaker {

    static Map<Integer, Stack<Card>> deckStates = new HashMap<Integer, Stack<Card>>();
    static Map<Integer, Board> boardStates = new HashMap<Integer, Board>();
    static Map<Integer, ArrayList<Player>> playerStates = new HashMap<Integer, ArrayList<Player>>();
    static int turn = 0;
    static int currentPlayerIndex = 0;
    static Map<Integer, ArrayList<ArrayList<Card>>> handStates = new HashMap<Integer, ArrayList<ArrayList<Card>>>();
    private static int numberOfRegressions = 0;
    // arraylist of ints of stateIDs used
    // when load state, delete ones after one loaded
    // when load state, look for..
    // maybe map<int, int> of stateID, regression?
    static Stack<Integer> priorStates = new Stack<Integer>();

    public GameStateCaretaker() {
    }

    public static void saveState() {
        currentPlayerIndex = GameEngine.getCurrentPlayerIndex();
        int stateID = generateStateID();
        priorStates.push(stateID);
        boardStates.put(stateID, GameStateMemento.getBoardState());
        playerStates.put(stateID, GameStateMemento.getPlayerState());
        Stack<Card> deckState = GameStateMemento.saveDeck();
        handStates.put(stateID, GameStateMemento.getPlayerHands());
        deckStates.put(stateID, deckState);
        // For debugging: printout of saved board state
        System.out.println("State " + stateID + " saved. BoardState: ");
        for (int r = 0; r < boardStates.get(stateID).getRows(); r++) {
            for (int c = 0; c < boardStates.get(stateID).getCols(); c++) {
                System.out.println("Cardname: " + boardStates.get(stateID).getCard(r, c).getName());                
                if (boardStates.get(stateID).getCard(r, c).getType() == "path") {
                    if (((PathCard) boardStates.get(stateID).getCard(r, c)).getIsToxic() == true) {
                        System.out.println("This card is toxic");
                    }

                }
            }
        }

    }

    public void loadState(int turnsReverted) {

        System.out.println("Rewinding turn: going to turn " + (GameEngine.getTurn() - turnsReverted));
        int oldTurn = (GameEngine.getTurn() - turnsReverted);
        System.out.println("turnID: " + oldTurn);
        GameEngine.setTurn(oldTurn);
        int oldStateID = generateStateID(turnsReverted);
        Deck.setDeck(deckStates.get(oldStateID));
        PlayerController.setPlayers(playerStates.get(oldStateID));
        PlayerController.setHand(handStates.get(oldStateID));
        Board.setBoard(boardStates.get(oldStateID));

        PlayGameListener.changeScene(AddPlayerView.getStage());

        RefreshBoard refreshBoard = new RefreshBoard();
        refreshBoard.refreshView();
        numberOfRegressions++;
        System.out.println("State " + oldStateID + " loaded. BoardState: ");
        for (int r = 0; r < boardStates.get(oldStateID).getRows(); r++) {
            for (int c = 0; c < boardStates.get(oldStateID).getCols(); c++) {
                System.out.println("Cardname: " + boardStates.get(oldStateID).getCard(r, c).getName());
                if (boardStates.get(oldStateID).getCard(r, c).getType() == "path") {
                    if (((PathCard) boardStates.get(oldStateID).getCard(r, c)).getIsToxic() == true) {
                        System.out.println("This card is toxic");
                    }

                }
            }
        }
    }

    private static int generateStateID() {
        System.out.println(
                "turn: " + GameEngine.getTurn() + " Player: " + currentPlayerIndex + " numReg: " + numberOfRegressions);
        String stateID = Integer.toString(GameEngine.getTurn()) + Integer.toString(currentPlayerIndex)
                + Integer.toString(numberOfRegressions);
        System.out.println("State generated: " + stateID);
        return Integer.parseInt(stateID);
    }

    private static int generateStateID(int turnsReverted) {
        // String stateID =
        // Integer.toString(turn-turnsReverted)+Integer.toString(currentPlayerIndex)+Integer.toString(numberOfRegressions);
        int numberPlayers = GameEngine.getPlayerSize();
        for (int i = 0; i < ((turnsReverted * numberPlayers) - 1); i++) {
            int statediscarded = priorStates.pop();
            System.out.println("State discarded: " + statediscarded);
        }
        String stateID = Integer.toString(priorStates.pop());
        System.out.println("State to load generated: " + stateID);
        return Integer.parseInt(stateID);
    }

}
