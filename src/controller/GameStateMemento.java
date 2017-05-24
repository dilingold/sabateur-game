package controller;

import java.util.ArrayList;
import java.util.Stack;

import model.Board;
import model.Deck;
import model.PlayerD;
import model.cards.Card;

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

public static ArrayList<PlayerD> getPlayerState(){
    return PlayerController.copyPlayerList();
}
public static ArrayList<ArrayList<Card>> getPlayerHands(){
    return PlayerController.getHands();
}


public static Board getBoardState(){
    return Board.getBoardCopy();
}
    
    

}
