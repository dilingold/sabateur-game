package model;

public class BlockPathCard extends PathCard {
	
	/*
	 * For exits:
	 * exit 0 = left
	 * exit 1 = up
	 * exit 2 = right
	 * exit 3 = down
	 */
	
	
	public BlockPathCard(int rotation){
		this.rotation = rotation;
		
		this.exits[0] = false;
		this.exits[1] = false;
		this.exits[2] = false;
		this.exits[3] = false;
	}


}
