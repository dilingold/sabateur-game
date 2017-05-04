package model;

import java.util.ArrayList;

import model.cards.Card;
import model.cards.CardInterface;

public class Hand {
	
	ArrayList<CardInterface> cards;
	
    public Hand(){
    	
    	cards = new ArrayList<>();

    }

    public ArrayList<CardInterface> getCards() {
    	
        return cards;
        
    }

    public boolean discardCard(int discardedCard) {

        cards.remove(discardedCard);

        return true;

    }

    public int cardCount() {
    	
        return cards.size();
        
    }

    public void addCard(CardInterface card) {
    	
        cards.add(card);
        
    }
   
    public void print() {
    	
        for(CardInterface x : cards) {
        	
            System.out.println(x);
            
        }
        
    }

}