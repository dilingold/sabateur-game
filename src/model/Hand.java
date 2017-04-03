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

    ArrayList<Card> cards  = new ArrayList<>();


    public ArrayList<Card> getCards() {
        return cards;
    }
    //removed - does not appear necessary for project
    //left in in case we need in future.
    /*
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    */

    public boolean discardCard(int discardedCard){

        cards.remove(discardedCard);

        return true;

    }

    public int cardCount(){
        return cards.size();
    }

    public void addCard(Card card){
        cards.add(card);
    }
   

    public void print(){
        for(Card x : cards){
            System.out.println(x);
        }
    }



}