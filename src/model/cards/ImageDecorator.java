package model.cards;

public class ImageDecorator extends AbstractCardDecorator {
	
	public ImageDecorator(Card cardInterface) {
		
		super(cardInterface);
		
	}
	
	@Override
	public String getName() {
		
		return super.getName() + ".png";
		
	}

}
