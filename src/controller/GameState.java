package controller;
import java.util.ArrayList;
import java.util.Stack;

import model.Board;
import model.Deck;
import model.PlayerD;
import model.cards.Card;

public class GameState {
    
    private Deck deck = new Deck();
    
    
    static ArrayList<Stack<Card>> deckStates = new ArrayList<Stack<Card>>();
    static ArrayList<Board> boardStates = new ArrayList<Board>();
    static ArrayList<ArrayList<PlayerD>> playerStates = new ArrayList<ArrayList<PlayerD>>();
    static int turn = 0;
    static int currentPlayerIndex = 0;

    public GameState() {
    }
    

    
    public static void saveState(){
        turn = GameEngine.getTurn();
        currentPlayerIndex = GameEngine.getCurrentPlayerIndex();
        int stateID = generateStateID();
        Stack<Card> deckState = Deck.getDeck();
        deckStates.set(stateID, deckState);
        boardStates.set(stateID, Board.getInstance());
        playerStates.set(stateID, PlayerController.getInstance().getPlayerList()); 
    }
    public void loadState(int turnsReverted){
        int oldTurn = GameEngine.getTurn() - turnsReverted;
        GameEngine.setTurn(oldTurn);
        int oldStateID = generateStateID(turnsReverted);
        //GameEngine.setPlayerIndex ? Think can avoid
        Deck.setDeck(deckStates.get(oldStateID));
        PlayerController.setPlayers(playerStates.get(oldStateID));
        Board.setBoard(boardStates.get(oldStateID));

    }
    
    
    private static int generateStateID() {
        String stateID = Integer.toString(turn)+Integer.toString(currentPlayerIndex);
        return Integer.parseInt(stateID);  
    }
    private static int generateStateID(int turnsReverted) {
        String stateID = Integer.toString(turn-turnsReverted)+Integer.toString(currentPlayerIndex);
        return Integer.parseInt(stateID);  
    }

    public Deck getDeck(){
        return deck;
    }

}
