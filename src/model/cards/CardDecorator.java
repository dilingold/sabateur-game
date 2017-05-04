package model.cards;

public class CardDecorator extends AbstractCardDecorator {
	
	private Card card;
	
	public CardDecorator(Card card) {
		
		super(card);
		this.card = card;
		
	}
	
	@Override
	public String getName() {
		
		return super.getUrl() + super.getName();
		
	}

}
