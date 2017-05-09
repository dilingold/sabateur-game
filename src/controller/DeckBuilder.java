package controller;

import java.util.Stack;

import model.Deck;
import model.cards.Card;

public class DeckBuilder {
	
	public void addLPathCards(int totalCards) {
		
		Deck.getInstance().addLPathCards(totalCards);
		
	}
	
	public void addXPathCards(int totalCards) {
		
		Deck.getInstance().addXPathCards(totalCards);
		
	}
	
	public void addStraighPathCards(int totalCards) {
		
		Deck.getInstance().addStraightPathCards(totalCards);
		
	}
	
	public void addTPathCards(int totalCards) {
		
		Deck.getInstance().addTPathCards(totalCards);
		
	}
	
	public void addEndPathCards(int totalCards) {
		
		Deck.getInstance().addEndPathCard(totalCards);
		
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
