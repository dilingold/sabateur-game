package model.cards;

public class CardDecorator extends AbstractCardDecorator {
	
	private CardInterface card;
	
	public CardDecorator(CardInterface card) {
		
		super(card);
		this.card = card;
		
	}
	
	@Override
	public String getName() {
		
		return super.getUrl() + super.getName();
		
	}

}
