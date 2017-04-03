package model.cards;

public abstract class Card {
	private int quantity;
	protected String type;
	

	public Card(){
		
	}
	
	public void changeQuantity(int amount){
		quantity = quantity + amount;
	}
	
	public int getQuantity(){
		return quantity;
	}

	public String type() {
		return type;
	}
	
}
