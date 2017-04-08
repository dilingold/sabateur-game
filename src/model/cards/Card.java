package model.cards;

public abstract class Card {

	private int quantity;
	public String type;
	protected String name;

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

}
