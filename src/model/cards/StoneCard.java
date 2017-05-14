package model.cards;

public class StoneCard extends BoardCard {

	public StoneCard() {
		
		this.name = "stone";
		
		this.exits[0] = true;
		this.exits[1] = true;
		this.exits[2] = true;
		this.exits[3] = true;
		
	}
	
}
