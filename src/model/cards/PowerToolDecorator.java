package model.cards;

import controller.ActionCardValidator;
import model.Board;

public class PowerToolDecorator extends AbstractCardDecorator {
		
	public PowerToolDecorator(Card card) {
		
		super(card);
		
	}

	@Override
	public String getType() {
		
		return super.card.getType();
		
	}

	@Override
	public String getName() {
		
		return super.card.getName();
		
	}
	
	@Override
	public Card doAction() {
		
		return new XPathCard(0);
		
	}
	
	public Card doAction(int row, int col) {
		
		Card card = doAction();
		Board.getInstance().playCard(row, col, card);
		return card;
		
	}

}
