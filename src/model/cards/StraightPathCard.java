package model.cards;

public class StraightPathCard extends PathCard {
	
	/*
	 * For exits:
	 * exit 0 = left
	 * exit 1 = up
	 * exit 2 = right
	 * exit 3 = down
	 */
	
	
	public StraightPathCard(int rotation) {
		
		this.name = "Straight Path";
		this.rotation = rotation;
		
		this.exits[0] = false;
		this.exits[1] = true;
		this.exits[2] = false;
		this.exits[3] = true;
		
	}

	@Override
	public Card doAction() {
		return this;
	}

}
