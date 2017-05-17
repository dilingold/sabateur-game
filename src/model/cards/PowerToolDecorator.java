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
