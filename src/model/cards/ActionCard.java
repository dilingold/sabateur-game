package model.cards;

import model.Board;

public abstract class ActionCard implements Card {
	
	protected String name;
	public String type = "action";
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
	public boolean[] getExits() {
		
		return null;
	}

}
