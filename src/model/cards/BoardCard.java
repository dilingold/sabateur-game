package model.cards;

public abstract class BoardCard implements Card {
	
	protected String type;
	protected String name;
	
	public BoardCard() {
		this.type = "board";
		this.name = "board card";
	}
	
	@Override
	public String getType() {
		
		return type;
		
	}
	
	@Override
	public String getUrl() {
		
		return "/resources/images/board/";
		
	}
}
