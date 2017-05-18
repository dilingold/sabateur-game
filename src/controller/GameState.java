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

public class GameState {
    
    
    //TODO
    //Only deckStates appears working, others keeps static variables contatined within.
    //update to fix.
    static Map<Integer,Stack<Card>> deckStates=new HashMap<Integer,Stack<Card>>();  
    //static ArrayList<Stack<Card>> deckStates = new ArrayList<Stack<Card>>();
    static Map<Integer,Board> boardStates=new HashMap<Integer,Board>();  
    //static ArrayList<Board> boardStates = new ArrayList<Board>();
    static Map<Integer,ArrayList<PlayerD>> playerStates=new HashMap<Integer,ArrayList<PlayerD>>();  
    //static ArrayList<ArrayList<PlayerD>> playerStates = new ArrayList<ArrayList<PlayerD>>();
    static int turn = 0;
    static int currentPlayerIndex = 0;

    public GameState() {
    }
    
    public static void saveState(){
        turn = GameEngine.getTurn();
        currentPlayerIndex = GameEngine.getCurrentPlayerIndex();
        int stateID = generateStateID();
        System.out.println("stateID = "+stateID);
        boardStates.put(stateID, getBoardState());
        playerStates.put(stateID, getPlayerState()); 
        Stack<Card> deckState = saveDeck();
        System.out.println("deckstatesize = "+deckState.size());
        deckStates.put(stateID, deckState);
        System.out.println("State "+stateID+" saved");
        if(deckStates.get(10) != null)
            System.out.println("deckstatesize at 10 = "+deckStates.get(10).size());
    }
    public void loadState(int turnsReverted){
        System.out.println("Rewinding turn: going to turn "+(GameEngine.getTurn() - turnsReverted));
        int oldTurn = (GameEngine.getTurn() - turnsReverted);
        GameEngine.setTurn(oldTurn);
        int oldStateID = generateStateID(turnsReverted);
        //GameEngine.setPlayerIndex ? Think can avoid
        Deck.setDeck(deckStates.get(oldStateID));
        PlayerController.setPlayers(playerStates.get(oldStateID));
        Board.setBoard(boardStates.get(oldStateID));
        for(int i = 0; i < GameEngine.getTurn(); i ++){
            oldStateID = generateStateID(i);
            System.out.println("deck size at turn "+i+" = "+deckStates.get(oldStateID).size());
        }
        PlayGameListener.changeScene(AddPlayerView.getStage());;

    }
    
    
    private static int generateStateID() {
        String stateID = Integer.toString(turn)+Integer.toString(currentPlayerIndex);
        return Integer.parseInt(stateID);  
    }
    private static int generateStateID(int turnsReverted) {
        String stateID = Integer.toString(turn-turnsReverted)+Integer.toString(currentPlayerIndex);
        return Integer.parseInt(stateID);  
    }


    public static Stack<Card> saveDeck(){
        Deck.getInstance();
        Stack<Card> deckInstance = Deck.getDeck();
        Stack<Card> savedDeck = new Stack<Card>();
        for(int i = 0; i < deckInstance.size(); i++){
            savedDeck.push(deckInstance.get(i).getCopy());
        }
        return savedDeck;
    }
    //TODO
    //incomplete
    public static ArrayList<PlayerD> getPlayerState(){
        return PlayerController.copyPlayerList();
    }
    public static Board getBoardState(){
        return Board.getBoardCopy();
    }
    
    //saveBoard
    //savePlayers
    //saveHands
    

}
