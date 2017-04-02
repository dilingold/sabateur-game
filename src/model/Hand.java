package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by johnny on 4/1/17.
 */
import model.Deal;
import model.cards.Card;

public class Hand {
	
    public Hand(){

    }

    ArrayList<Card> hand  = new ArrayList<>();


    public ArrayList<Card> getHand() {
        return hand;
    }
    //removed - does not appear necessary for project
    //left in in case we need in future.
    /*
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    */

    public boolean discardCard(int discardedCard){

        hand.remove(discardedCard);

        return true;

    }

    public int cardCount(){
        return hand.size();
    }

    public void addCard(Card card){
        hand.add(card);
    }
   

    public void print(){
        for(Card x : hand){
            System.out.println(x);
        }
    }



}