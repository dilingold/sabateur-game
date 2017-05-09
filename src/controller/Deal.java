package controller;

import model.Deck;
import model.Hand;
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

    	Hand hand = new Hand();
        for(int i = 0; i<maxCards; i++) {
        	
        	hand.addCard(Deck.getInstance().draw());

        }
        
        player.setHand(hand);

    }
    
}