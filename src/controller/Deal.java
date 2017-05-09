package controller;

import model.Deck;
import model.Player;
import model.cards.Card;

/**
 * Created by johnny on 4/1/17.
 */
public class Deal {

    private int maxCards = 6;

    public void drawCard(Player player) {
    	
    	Card card = Deck.getInstance().draw();
    	if (card != null) {
    		
    		player.getHand().addCard(card);
    		
    	}

    }

    public void deal(Player player) {

        for(int i = 0; i<maxCards; i++) {
        	
        	player.getHand().addCard(Deck.getInstance().draw());

        }

    }
    
}