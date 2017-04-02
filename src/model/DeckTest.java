
package model;

public class DeckTest {

	public static void main(String[] args){
	
		System.out.println("creating deck... ");
		Deck myDeck = new Deck();
		myDeck.printCards();
		//myDeck.shuffle();
		System.out.println("shuffling... ");
		System.out.println(myDeck);
		
	}
	
}
