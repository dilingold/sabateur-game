package model.cards;

public class GoldCard extends BoardCard {
	
	private int points = 3;

	public GoldCard() {
		
		this.name = "gold";
		
		this.exits[0] = true;
		this.exits[1] = true;
		this.exits[2] = true;
		this.exits[3] = true;
		
	}

	public GoldCard(int points) {
		
		this.type = "gold";
		this.name = "gold";
		this.points = points;
		
	}
	
}
