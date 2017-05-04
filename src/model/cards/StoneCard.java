package model.cards;

public class StoneCard extends BoardCard {

	public StoneCard() {
		
		this.type = "coal";
		this.name = "goal";
		
	}

	@Override
	public String getName() {
		
		return name;
	}
	
}
