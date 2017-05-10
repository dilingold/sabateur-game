package controller;

import java.util.Stack;

import model.Deck;
import model.cards.Card;

public class DeckBuilder {
	
	private int numPathCards = 3;
	
	public void addLPathCards() {
		
		Deck.getInstance().addLPathCards(numPathCards);
		
	}
	
	public void addXPathCards() {
		
		Deck.getInstance().addXPathCards(numPathCards);
		
	}
	
	public void addStraighPathCards() {
		
		Deck.getInstance().addStraightPathCards(numPathCards);
		
	}
	
	public void addTPathCards() {
		
		Deck.getInstance().addTPathCards(numPathCards);
		
	}
	
	public void addEndPathCards() {
		
		Deck.getInstance().addEndPathCard(numPathCards);
		
	}
	
	public void Shuffle() {
		
		Deck.getInstance().shuffle();
		
	}
	
	public Stack<Card> getDeck() {
		
		return Deck.getInstance().getDeck();
		
	}
	
	public void clearDeck() {
		
		Deck.getInstance().clearDeck();
		
	}

}
