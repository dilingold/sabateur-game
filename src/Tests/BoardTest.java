package Tests;

import model.Deck;
import model.Hand;
import model.Miner;
import model.Player;
import model.cards.Card;

public class BoardTest {

	public static void main(String[] args){
	Deck deck = Deck.getInstance();
	deck.shuffle();
	
		
	Hand myHand = new Hand();
	String name = "name";
	Player myPlayer = new Miner(name, 0);
	//Deal.deal(myPlayer);
	
	//System.out.println(myPlayer.getHand().getCards().get(3).type());
	}
}
