package model.cards;

public abstract class AbstractCardDecorator implements Card {
	
	private Card cardInterface;
	
	public AbstractCardDecorator(Card cardInterface) {
		
		this.cardInterface = cardInterface;
		
	}

	@Override
	public String getType() {
		
		if (cardInterface != null) {
			
			return cardInterface.getType();
			
		}
		
		else return null;
	}

	@Override
	public String getName() {
		
		if (cardInterface != null) {
			
			return cardInterface.getName();
			
		}
		
		else return null;
		
	}
	
	@Override
	public String getUrl() {
		
		if (cardInterface != null) {
			
			return cardInterface.getUrl();
			
		}
		
		else return null;
		
	}

}
