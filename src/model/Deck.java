package model;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

import model.cards.*;

public class Deck {
	
	private static Deck ourInstance = new Deck();

	public static Deck getInstance() {
		return ourInstance;
	}

	private static Stack<Card> deck = new Stack<Card>();
	
	public void shuffle(){
		
		//shuffle all cards in deck
		Collections.shuffle(deck);
		
	}

	public Card draw(){
		//drawn next card from deck
		//return null if no cards in deck
		if(deck.isEmpty() == false) {
			return deck.pop();
		}
		return null;
	}

	public static Stack<Card> getDeck() {
		
		return deck;
		
	}
	
	public void clearDeck() {
		
		deck.clear();
		
	}
	
	public static void setDeck(Stack<Card> oldDeck){
	    deck = oldDeck;
	    
	}

}
