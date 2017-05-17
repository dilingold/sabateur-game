package model.cards;

import model.Board;

public class NoDecorator extends AbstractCardDecorator {
		
	private Card card;
	
	public NoDecorator(Card card) {
		
		super(card);
		this.card = card;
		
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
		
		return card;
		
	}
	
	public Card doAction(int row, int col) {
		
		Board.getInstance().playCard(row, col, card);
		return card;
		
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
