package model.cards;

public abstract class Card {

	private int quantity;
	protected String type;
	protected String name;
	private boolean[] exits = {false, false, false, false};

	public Card() {

		name = "card";

	}

	public void changeQuantity(int amount) {

		quantity = quantity + amount;

	}

	public int getQuantity() {

		return quantity;

	}

	public String getType() {

		return type;

	}

	public String getName() {

		return name;

	}
	public boolean[] getExits(){
		return exits;
	}

}
