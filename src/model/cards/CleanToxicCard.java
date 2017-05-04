package model.cards;

public class CleanToxicCard extends ActionCard {
	
	public CleanToxicCard() {
		
		this.name = "Clean Toxic Card";
		this.effect = "removeDisable";
		this.type = "cleantoxic";
		
	}

	@Override
	public String getName() {
		
		return name;
	}

}
