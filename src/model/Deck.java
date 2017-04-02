package model;
import java.util.Collections;
import java.util.Stack;

import model.cards.*;

public class Deck {

	private Card [] cards; 
	private Stack<Card> cards2;
	LPathCard lPCard1;
	
	public Deck(){
		this.cards = new Card [16];
		lPCard1 = new LPathCard(1);
		LPathCard lPCard2 = new LPathCard(0);
		LPathCard lPCard3 = new LPathCard(0);
		LPathCard lPCard4 = new LPathCard(0);
		BlockPathCard bPCard = new BlockPathCard(0);
		StraightPathCard sPCard = new StraightPathCard(0);
		TPathCard tPCard = new TPathCard(0);
		XPathCard xPCard = new XPathCard(0);
		cards2.push(lPCard1);
		/*cards2.push(lPCard2);
		cards2.push(lPCard3);
		cards2.push(lPCard4);
		cards2.push(bPCard);
		cards2.push(sPCard);
		cards2.push(tPCard);
		cards2.push(xPCard);
		*/
		
		
		//cards[0] = lPCard1;
		cards[1] = xPCard;
		cards[1] = bPCard;
		cards[1] = sPCard;
		cards[1] = tPCard;
		
	
	}
	public void shuffle(){
		//shuffle all cards in deck
		Collections.shuffle(cards2);
	}
	
	public Card draw(){
		//drawn next card from deck
		//return null if no cards in deck
		//if(this.cards.length > 0){
		if(cards2.isEmpty() == true){
			return cards2.pop();
		}
		return null;
	}
	//print card name to console, for debugging:
	public void printCards(){
		for( int i = 0; i <= cards.length - 1; i++)
		{
			if(cards[i] != null)
				System.out.println(cards[i].getClass().getName());
		}
		
	}
	
}
