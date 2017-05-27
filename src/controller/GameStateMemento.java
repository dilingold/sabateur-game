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
    
public GameStateMemento(){    
    
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

public static ArrayList<Player> getPlayerState(){
    return PlayerController.copyPlayerList();
}
public static ArrayList<ArrayList<Card>> getPlayerHands(){
    return PlayerController.getHands();
}
public static Board getBoardState(){
    return Board.getBoardCopy();
}
public static void setTurn(int oldTurn){
    GameEngine.setTurn(oldTurn); 
}







public static void setDeck(Stack<Card> oldDeck) {
    Deck.setDeck(oldDeck);
}
public static void setPlayers(ArrayList<Player> oldPlayers) {
    PlayerController.setPlayers(oldPlayers);
}
public static void setHand(ArrayList<ArrayList<Card>> oldHandList) {
    PlayerController.setHand(oldHandList);
}
public static void setBoard(Board oldBoard) {
    Board.setBoard(oldBoard);
}
public static void refreshView() {
    PlayGameListener.changeScene(AddPlayerView.getStage());
    RefreshBoard refreshBoard = new RefreshBoard();
    refreshBoard.refreshView();
}


    

}
