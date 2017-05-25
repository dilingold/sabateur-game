package model.cards;

public abstract class BoardCard implements Card {
	
	protected String name;
	protected String type;
	protected boolean[] exits = new boolean[4];
	
	public BoardCard() {
		this.type = "board";
		this.name = "board card";
	}
	
	@Override 
	public boolean[] getExits() {
		return exits;
	}
	
	@Override
	public String getType() {
		
		return type;
		
	}
	
	@Override
	public String getName() {
		
		return name;
		
	}
	
}
