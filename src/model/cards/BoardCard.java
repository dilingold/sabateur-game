package model.cards;

public abstract class BoardCard implements Card {
	
	protected String name;
	protected String type;
	
	public BoardCard() {
		this.type = "board";
		this.name = "board card";
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
}
