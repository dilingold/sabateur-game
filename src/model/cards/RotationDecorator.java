package model.cards;

public class RotationDecorator extends AbstractCardDecorator {
	
	private PathCard pathCard;
	
	public RotationDecorator(PathCard pathCard) {
		
		super(pathCard);
		this.pathCard = pathCard;
		
	}
	
	@Override
	public String getName() {
		
		return super.getName() + "-rotate" + pathCard.getRotation();
		
	}

}
