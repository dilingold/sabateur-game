package model.cards;

public abstract class ActionCard extends Card {

	public String type = "action";
	protected String effect;

	public String getEffect() {

		return effect;

	}

	public String getType() {

		return type;

	}

}
