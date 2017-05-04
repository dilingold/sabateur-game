package model.cards;

public class ImageDecorator extends AbstractCardDecorator {
	
	public ImageDecorator(CardInterface cardInterface) {
		
		super(cardInterface);
		
	}
	
	@Override
	public String getName() {
		
		return super.getName() + ".png";
		
	}

}
