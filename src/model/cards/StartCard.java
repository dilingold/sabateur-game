package model.cards;

public class StartCard extends PathCard {
	
	/*
	 * For exits:
	 * exit 0 = left
	 * exit 1 = up
	 * exit 2 = right
	 * exit 3 = down
	 */
	
	public StartCard() {
		
		this.name = "start";
		this.exits[0] = true;
		this.exits[1] = true;
		this.exits[2] = true;
		this.exits[3] = true;
		
	}

	@Override
	public Card doAction() {
		return this;
	}

}
