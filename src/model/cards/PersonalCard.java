package model.cards;

import model.PlayerD;

public abstract class PersonalCard implements Card {
		
	protected String name;
	private String type = "personal";
	protected String effect;
		
	public String getEffect() {
			
		return effect;
			
	}
	
	public boolean[] getExits() {
		
		return null;
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
	
	@Override
	public Card doAction(int row, int col) {
		return this;
	}
	
	public abstract void doAction(PlayerD currentPlayer, PlayerD targetPlayer);
		
}
