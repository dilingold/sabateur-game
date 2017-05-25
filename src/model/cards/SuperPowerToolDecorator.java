package model.cards;

import controller.ActionCardValidator;
import model.Board;

public class SuperPowerToolDecorator extends AbstractCardDecorator {
	
	public SuperPowerToolDecorator(Card card) {
		
		super(card);
		
	}

	@Override
	public String getType() {

		return card.getType();
	}

	@Override
	public String getName() {
		return card.getName();
	}

}
