package controller;

import java.util.Stack;

import model.Deck;
import model.cards.Card;
import model.cards.ExposeCard;
import model.cards.HeistCard;
import model.cards.LPathCard;
import model.cards.PowerToolCard;
import model.cards.RemoveToxicCard;
import model.cards.ToxicCard;

public class DeckBuilder {
	
	private int numPathCards = 10;
	private int numPersonalCards = 5;
	private int numActionCards = 10;
	
	public void addAllCards() {
		
		addEndPathCards();
		addLPathCards();
		addStraighPathCards();
		addTPathCards();
		addXPathCards();
		addHeistCards();
		addExposeCard();
		addToxicCard();
		addSuperToolCard();
		addRemoveToxicCard();
		
	}
	
	public void addToxicCard() {
		
		for(int i = 0; i<numActionCards; i++) {
			ToxicCard toxicCard = new ToxicCard();
			Deck.getInstance().getDeck().push(toxicCard);
			
		}
	}
	
	public void addRemoveToxicCard() {
		
		for(int i = 0; i<numActionCards; i++) {
			RemoveToxicCard removeToxicCard = new RemoveToxicCard();
			Deck.getInstance().getDeck().push(removeToxicCard);
			
		}
	}
	
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
	
	public void addSuperToolCard() {
		
		for(int i = 0; i<numPersonalCards; i++) {
			
			PowerToolCard superToolCard = new PowerToolCard();
			Deck.getInstance().getDeck().push(superToolCard);
			
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
