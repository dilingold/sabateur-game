package Tests;

import controller.Deal;
import model.Deck;
import model.Hand;
import model.Player;

public class BoardTest {

	public static void main(String[] args){
	Deck deck = Deck.getInstance();
	deck.shuffle();
	
		
	Hand myHand = new Hand();
	String name = "name";
	Player myPlayer = new Player(name, myHand);
	//Deal.deal(myPlayer);
	
	//System.out.println(myPlayer.getHand().getCards().get(3).type());
	}
}
