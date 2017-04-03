package model.cards;

public class LPathCard extends PathCard {
	/*
	 * For exits:
	 * exit 0 = left
	 * exit 1 = up
	 * exit 2 = right
	 * exit 3 = down
	 */
	
	
	public LPathCard(int rotation){
		this.name = "L Path";
		this.rotation = rotation;
		
		this.exits[0] = true;
		this.exits[1] = true;
		this.exits[2] = false;
		this.exits[3] = false;
	}

}
