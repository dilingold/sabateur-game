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

	private Stack<Card> deck = new Stack<Card>();

	private Deck() {
		//add the following cards to the deck
		//where the passed int is the number of cards
		addLPathCards(3);
		addXPathCards(3);
		addStraightPathCards(3);
		addTPathCards(6);
		addToxicCard(3);
		shuffle();
		
	}
	
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
	
	//print card name to console, for debugging:
	public void printCards() {
		System.out.println("cards2 stack printout: ");
		Iterator<Card> deckIteration = deck.iterator();
		while (deckIteration.hasNext()) {
			System.out.println(deckIteration.next());
		}
	}

	private void addLPathCards(int totalCards) {
		
		for(int i = 0; i<totalCards; i++) {
			
			LPathCard lPCard = new LPathCard(0);
			deck.push(lPCard);
			
		}
		
	}
	
	private void addXPathCards(int totalCards) {
		
		for(int i = 0; i<totalCards; i++) {
			
			XPathCard xCard = new XPathCard(0);
			deck.push(xCard);
			
		}
		
	}
	
	/*
	 * For Assignment 2
	private void addBlockPathCards(int totalCards) {
		
		for(int i = 0; i<totalCards; i++){
			BlockPathCard blockCard = new BlockPathCard(0);
			deck.push(blockCard);
			
		}
		
	}
	*/
	
	private void addStraightPathCards(int totalCards) {
		for(int i = 0; i<totalCards; i++) {
			StraightPathCard straightCard = new StraightPathCard(0);
			deck.push(straightCard);
		}
	}
	
	private void addTPathCards(int totalCards) {
		for(int i = 0; i<totalCards; i++) {
			TPathCard tPathCard = new TPathCard(0);
			deck.push(tPathCard);
		}
	}

	private void addToxicCard(int totalCards) {
		for(int i = 0; i<totalCards; i++) {
			ToxicCard toxicCard = new ToxicCard();
			deck.push(toxicCard);
		}
	}

}
