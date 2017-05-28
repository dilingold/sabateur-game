package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import model.Board;
import model.Player;
import model.cards.Card;

public class GameStateCaretaker {

    // Map of saved states, with the key generated from Originator.
    static Map<String, Stack<Card>> deckStates = new HashMap<String, Stack<Card>>();
    static Map<String, Board> boardStates = new HashMap<String, Board>();
    static Map<String, ArrayList<Player>> playerStates = new HashMap<String, ArrayList<Player>>();
    static Map<String, ArrayList<ArrayList<Card>>> handStates = new HashMap<String, ArrayList<ArrayList<Card>>>();

    public GameStateCaretaker() {
    }

    // Save and get state methods for Deck, Board, Players and Player's Hands
    public static void saveDeckState(String stateID, Stack<Card> deckState) {
        deckStates.put(stateID, deckState);
    }

    public static Stack<Card> getDeckState(String oldStateID) {
        return deckStates.get(oldStateID);
    }

    public static void savePlayerState(String stateID, ArrayList<Player> playerState) {
        playerStates.put(stateID, playerState);
    }

    public static ArrayList<Player> getPlayerState(String oldStateID) {
        return playerStates.get(oldStateID);
    }

    public static void saveBoardState(String stateID, Board boardState) {
        boardStates.put(stateID, boardState);
    }

    public static Board getBoardState(String oldStateID) {
        return boardStates.get(oldStateID);
    }

    public static void saveHandListState(String stateID, ArrayList<ArrayList<Card>> handState) {
        handStates.put(stateID, handState);
    }

    public static ArrayList<ArrayList<Card>> getHandListState(String oldStateID) {
        return handStates.get(oldStateID);
    }

}
