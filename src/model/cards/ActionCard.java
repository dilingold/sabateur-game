package model.cards;

public abstract class ActionCard extends Card {
	
	public String type = "action";
	protected String effect;
	
	public ActionCard(){
		this.type = "action";
	}
	
	public String getEffect() {
		
		return effect;
		
	}
	
}
