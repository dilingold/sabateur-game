package model.cards;

import model.Board;

public abstract class AbstractCardDecorator implements Card {
	
	protected Card card;
	
	public AbstractCardDecorator(Card card) {
		
		this.card = card;
		
	}
	
	@Override
	public boolean[] getExits() {
		return null;
	}
	
	@Override
	public Card doAction(int row, int col) {
		
		Card card = doAction();
		Board.getInstance().playCard(row, col, card);
		return card;
		
	}

}
