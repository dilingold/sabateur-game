package model.cards;

public abstract class ActionCard extends Card {
	
	private String type = "action";
	protected String effect;
	
	public String getEffect() {
		
		return effect;
		
	}
	
	public String getType() {
		
		return type;
		
	}
	
}
