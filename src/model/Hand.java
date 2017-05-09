package model;

import java.util.ArrayList;

import model.cards.Card;

public class Hand {
	
	ArrayList<Card> cards;
	private int cardCount;
	
    public Hand(){
    	
    	cards = new ArrayList<>();
    	cardCount = 0;

    }

    public ArrayList<Card> getCards() {
    	
        return cards;
        
    }

    public boolean discardCard(int discardedCard) {

        cards.remove(discardedCard);
        cardCount--;

        return true;

    }

    public int cardCount() {
    	
        return cardCount;
        
    }

    public void addCard(Card card) {
    	
        cards.add(card);
        cardCount++;
        
    }
   
    public void print() {
    	
        for(Card x : cards) {
        	
            System.out.println(x);
            
        }
        
    }

}