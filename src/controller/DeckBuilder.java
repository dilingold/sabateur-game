package controller;

import java.util.Stack;

import model.Deck;
import model.cards.Card;
import model.cards.ExposeCard;
import model.cards.HeistCard;
import model.cards.LPathCard;

public class DeckBuilder {
	
	private int numPathCards = 5;
	private int numPersonalCards = 10;
	
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
	
	public void addHeistCards() {
		
		for(int i = 0; i<numPersonalCards; i++) {
			
			HeistCard heistCard = new HeistCard();
			Deck.getInstance().getDeck().push(heistCard);
			
		}
		
	}
	
	public void addExposeCard() {
		
		for(int i = 0; i<numPersonalCards; i++) {
			
			ExposeCard exposeCard = new ExposeCard();
			Deck.getInstance().getDeck().push(exposeCard);
			
		}
		
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
