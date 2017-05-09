package controller;

import model.Deck;
import model.Player;

/**
 * Created by johnny on 4/1/17.
 */
public class Deal {

    private int maxCards = 6;

    public void drawCard(Player player) {

        player.getHand().addCard(Deck.getInstance().draw());

    }

    public void deal(Player player) {

        for(int i = 0; i<maxCards; i++) {
        	
        	player.getHand().addCard(Deck.getInstance().draw());

        }

    }
    
}