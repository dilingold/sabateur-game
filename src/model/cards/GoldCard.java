package model.cards;

public class GoldCard extends BoardCard {
	
	private int points = 3;

	public GoldCard() {
		
		this.type = "gold";
		this.name = "goal";
		
	}

	public GoldCard(int points) {
		
		this.type = "gold";
		this.name = "goal";
		this.points = points;
		
	}

	@Override
	public String getName() {
		
		return name;
	}
	
}
