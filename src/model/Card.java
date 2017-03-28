package model;

public abstract class Card {
	private int quantity;
	
	
	public void changeQuantity(int amount){
		quantity = quantity + amount;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
}
