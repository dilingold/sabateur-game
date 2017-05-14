package model.cards;

import model.Board;

public abstract class AbstractCardDecorator implements Card {
	
	protected Card card;
	
	public AbstractCardDecorator(Card card) {
		
		this.card = card;
		
	}
	
	@Override
	public Card doAction() {
		
		card.doAction();
		return card;
		
	}

}
