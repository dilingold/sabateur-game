package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import model.Board;
import model.Player;
import model.cards.Card;

public class GameStateCaretaker {

    static Map<Integer, Stack<Card>> deckStates = new HashMap<Integer, Stack<Card>>();
    static Map<Integer, Board> boardStates = new HashMap<Integer, Board>();
    static Map<Integer, ArrayList<Player>> playerStates = new HashMap<Integer, ArrayList<Player>>();
    static Map<Integer, ArrayList<ArrayList<Card>>> handStates = new HashMap<Integer, ArrayList<ArrayList<Card>>>();



    public GameStateCaretaker() {
    }
    public static void saveDeckState(int stateID, Stack<Card> deckState){
        deckStates.put(stateID, deckState);
    }
    public static Stack<Card> getDeckState(int oldStateID){
        return deckStates.get(oldStateID);
    }
    public static void savePlayerState(int stateID, ArrayList<Player> playerState){
        playerStates.put(stateID, playerState);
    }
    public static ArrayList<Player> getPlayerState(int oldStateID){
        return playerStates.get(oldStateID);
    }
    public static void saveBoardState(int stateID, Board boardState){
        boardStates.put(stateID, boardState);
    }
    public static Board getBoardState(int oldStateID){
        return boardStates.get(oldStateID);
    }
    public static void saveHandListState(int stateID, ArrayList<ArrayList<Card>> handState){
        handStates.put(stateID, handState);
    }
    public static ArrayList<ArrayList<Card>> getHandListState(int oldStateID){
        return handStates.get(oldStateID);
    }
    
    
   

}
