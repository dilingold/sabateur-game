package model.cards;

import model.PlayerD;

public abstract class PersonalCard implements Card {
		
	protected String name;
	private String type = "personal";
	protected String effect;
		
	public String getEffect() {
			
		return effect;
			
	}
	
	@Override
	public String getType() {
			
		return type;
			
	}
	
	@Override
	public String getName() {
		
		return name;
		
	}
	
	@Override
	public Card doAction() {
		
		return this;
		
	}
	
	public abstract void doAction(PlayerD currentPlayer, PlayerD targetPlayer);
		
}
