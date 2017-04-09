package model.cards;

public class GoldCard extends BoardCard {
	
	private int points = 3;

	public GoldCard() {
		
		this.type = "gold";
		this.name = "gold";
		
	}

	public GoldCard(int points) {
		
		this.type = "gold";
		this.name = "gold";
		this.points = points;
		
	}
	
}
