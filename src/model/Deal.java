package model;

import controller.GameEngineT;
import model.cards.Card;

/**
 * Created by johnny on 4/1/17.
 */
public class Deal {

    private int maxCards = 6;


//    public void drawCard(Card card) {
//
//        hand.add(card);
//    }

    public void deal(Player player){

        for(int i = 0; i<maxCards; i++){
//        	player.getHand().addCard(GameEngineT.deck.draw());
            player.getHand().addCard(Deck.getInstance().draw());

        }

    }
}