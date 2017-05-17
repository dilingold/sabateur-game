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
	
	public Card doAction(int row, int col) {
		
		Card card = doAction();
		ActionCardValidator validator = new ActionCardValidator();
		 if (validator.checkSuperPowerMove(card, row, col+1))
			 card.doAction(row, col+1);
		if (validator.checkSuperPowerMove(card, row, col-1))
			card.doAction(row, col-1);
		if (validator.checkSuperPowerMove(card, row+1, col))
			card.doAction(row+1, col);
		if (validator.checkSuperPowerMove(card, row-1, col))
			card.doAction(row-1, col); 
		
		return card;
		
	}

	@Override
	public Card doAction() {
		
		return card.doAction();
	}
    
    @Override
    public Card getCopy(){
        try {
            return (Card) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
