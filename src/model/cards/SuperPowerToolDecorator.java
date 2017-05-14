package model.cards;

import controller.ActionCardValidator;
import model.Board;

public class SuperPowerToolDecorator extends AbstractCardDecorator {
	
	public SuperPowerToolDecorator(Card card) {
		
		super(card);
		
	}

	@Override
	public String getType() {

		return this.getType();
	}

	@Override
	public String getName() {
		return this.getName();
	}
	
	@Override
	public Card doAction() {
		
		return new XPathCard(0);
		
	}
	
	public Card doAction(int row, int col) {
		
		Card card = doAction();
		ActionCardValidator validator = new ActionCardValidator();
		if (validator.checkMove(card, row, col+1))
			Board.getInstance().playCard(row, col+1, card);
		if (validator.checkMove(card, row, col-1))
			Board.getInstance().playCard(row, col-1, card);
		if (validator.checkMove(card, row+1, col))
			Board.getInstance().playCard(row+1, col, card);
		if (validator.checkMove(card, row-1, col))
			Board.getInstance().playCard(row-1, col, card);
		
		return card;
		
	}

}
