package model.cards;

public abstract class ActionCard implements CardInterface {

	public String type = "action";
	protected String name;
	protected String effect;

	public String getEffect() {

		return effect;

	}

	@Override
	public String getType() {

		return type;

	}
	
	@Override
	public String getUrl() {
		
		return "/resources/images/cards/";
		
	}

}
