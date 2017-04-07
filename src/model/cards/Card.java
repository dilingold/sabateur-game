package model.cards;

public abstract class Card {

	private int quantity;
	protected String type;
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

	public String type() {

		return type;

	}

	public String getName() {

		return name;

	}

}
