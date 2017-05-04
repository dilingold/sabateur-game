package model.cards;

public abstract class PersonalCard implements Card {
		
	protected String name;
	protected String type;
	protected String url;
	protected String effect;
	
	public PersonalCard() {
		
		type = "personal";
		url = "/resources/images/cards/";
		
	}
		
	public String getEffect() {
			
		return effect;
			
	}
		
	public String getType() {
			
		return type;
			
	}

	@Override
	public String getUrl() {
		
		return url;
	}
		
}
