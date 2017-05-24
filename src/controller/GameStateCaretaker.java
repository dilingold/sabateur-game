package controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import model.Board;
import model.Deck;
import model.PlayerD;
import model.cards.Card;
import view.AddPlayerView;
import view.GameView;
import view.RefreshBoard;

public class GameStateCaretaker {
    
    
    
    static Map<Integer,Stack<Card>> deckStates=new HashMap<Integer,Stack<Card>>();  
    static Map<Integer,Board> boardStates=new HashMap<Integer,Board>();
    static Map<Integer,ArrayList<PlayerD>> playerStates=new HashMap<Integer,ArrayList<PlayerD>>(); 
    static int turn = 0;
    static int currentPlayerIndex = 0;
    static Map<Integer, ArrayList<ArrayList<Card>>> handStates=new HashMap<Integer,ArrayList<ArrayList<Card>>>();
    private static int numberOfRegressions = 0;
    //arraylist of ints of stateIDs used
    //when load state, delete ones after one loaded
    //when load state, look for..
    //maybe map<int, int> of stateID, regression?
    
    public GameStateCaretaker() {
    }
    
    public static void saveState(){
        int stateID = generateStateID();
        turn = GameEngine.getTurn();
        currentPlayerIndex = GameEngine.getCurrentPlayerIndex();
        boardStates.put(stateID, GameStateMemento.getBoardState());
        playerStates.put(stateID, GameStateMemento.getPlayerState()); 
        Stack<Card> deckState = GameStateMemento.saveDeck();
        handStates.put(stateID, GameStateMemento.getPlayerHands());
        deckStates.put(stateID, deckState);
        System.out.println("State "+stateID+" saved");
        
    }

    public void loadState(int turnsReverted){
       
        System.out.println("Rewinding turn: going to turn "+(GameEngine.getTurn() - turnsReverted));
        int oldTurn = (GameEngine.getTurn() - turnsReverted);
        GameEngine.setTurn(oldTurn);
        int oldStateID = generateStateID(turnsReverted);
        Deck.setDeck(deckStates.get(oldStateID));
        PlayerController.setPlayers(playerStates.get(oldStateID));
        PlayerController.setHand(handStates.get(oldStateID));
        Board.setBoard(boardStates.get(oldStateID));
        for(int i = 0; i < GameEngine.getTurn(); i ++){
            oldStateID = generateStateID(i);
        }
        PlayGameListener.changeScene(AddPlayerView.getStage());;
        RefreshBoard refreshBoard = new RefreshBoard();
        refreshBoard.refreshView();
        numberOfRegressions ++;
    }
    
    
    private static int generateStateID() {
        String stateID = Integer.toString(turn)+Integer.toString(currentPlayerIndex)+Integer.toString(numberOfRegressions);
        System.out.println("State generated: "+ stateID);
        return Integer.parseInt(stateID);  
    }
    private static int generateStateID(int turnsReverted) {
        String stateID = Integer.toString(turn-turnsReverted)+Integer.toString(currentPlayerIndex)+Integer.toString(numberOfRegressions);
        System.out.println("State to load generated: "+ stateID);
        return Integer.parseInt(stateID);  
    }

    

}
