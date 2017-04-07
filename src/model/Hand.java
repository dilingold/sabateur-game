package model;

import java.util.ArrayList;

import model.cards.Card;

public class Hand {
	
	ArrayList<Card> cards;
	
    public Hand(){
    	
    	cards = new ArrayList<>();

    }

    public ArrayList<Card> getCards() {
    	
        return cards;
        
    }

    public boolean discardCard(int discardedCard) {

        cards.remove(discardedCard);

        return true;

    }

    public int cardCount() {
    	
        return cards.size();
        
    }

    public void addCard(Card card) {
    	
        cards.add(card);
        
    }
   
    public void print() {
    	
        for(Card x : cards) {
        	
            System.out.println(x);
            
        }
        
    }

}