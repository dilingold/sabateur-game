package controller;

import java.util.ArrayList;
import java.util.Stack;

import model.Board;
import model.Deck;
import model.Player;
import model.cards.Card;
import view.AddPlayerView;
import view.RefreshBoard;

public class GameStateMemento {

    public GameStateMemento() {

    }

    // gets deck state from deck class
    // copies all cards to ensure new copies aren't influenced by
    // changes to old copies.
    public static Stack<Card> getDeckMemento() {
        Deck.getInstance();
        Stack<Card> deckInstance = Deck.getDeck();
        Stack<Card> savedDeck = new Stack<Card>();
        for (int i = 0; i < deckInstance.size(); i++) {
            savedDeck.push(deckInstance.get(i).getCopy());
        }
        return savedDeck;
    }

    // gets player states form player controller class
    public static ArrayList<Player> getPlayersMemento() {
        return PlayerController.copyPlayerList();
    }

    // get all player's hands from the playercontroller class
    public static ArrayList<ArrayList<Card>> getHandlistMemento() {
        return PlayerController.getHands();
    }

    // gets current board state from board class
    public static Board getBoardMemento() {
        return Board.getBoardCopy();
    }

    // sets the turn counter to the correct value
    public static void setTurn(int oldTurn) {
        GameEngine.setTurn(oldTurn);
    }

    public static void setDeckMemento(Stack<Card> oldDeck) {
        Deck.setDeck(oldDeck);
    }

    public static void setPlayersMemento(ArrayList<Player> oldPlayers) {
        PlayerController.setPlayers(oldPlayers);
    }

    public static void setHandMemento(ArrayList<ArrayList<Card>> oldHandList) {
        PlayerController.setHand(oldHandList);
    }

    public static void setBoardMemento(Board oldBoard) {
        Board.setBoard(oldBoard);
    }

    public static void refreshView() {
        PlayGameListener.changeScene(AddPlayerView.getStage());
        RefreshBoard refreshBoard = new RefreshBoard();
        refreshBoard.refreshView();
    }

}
