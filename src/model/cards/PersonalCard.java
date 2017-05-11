package model.cards;

import model.PlayerD;

public abstract class PersonalCard extends Card {
		
	protected String name;
	private String type = "personal";
	protected String effect;
		
	public String getEffect() {
			
		return effect;
			
	}
		
	public String getType() {
			
		return type;
			
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public abstract void doAction(PlayerD currentPlayer, PlayerD targetPlayer);
		
}
