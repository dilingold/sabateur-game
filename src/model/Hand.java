package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnny on 4/1/17.
 */
import model.Deal;
public class Hand {

    //private List<Integer> hand;

    public Hand(){

    }

    List<Integer> hand  = new ArrayList<>();


    public List<Integer> getHand() {
        return hand;
    }

    public void setHand(List<Integer> hand) {
        this.hand = hand;
    }

    public boolean discardCard(int discardedCard){

        hand.remove(discardedCard);

        return true;

    }

    public int cardCount(){

        return hand.size();
    }

    public void addCard(int cardType){
        hand.add(cardType);
    }

    public void print(){
        for(int x : hand){
            System.out.println(x);
        }
    }



}