package model.cards;

public class XPathCard extends PathCard {
	
	/*
	 * For exits:
	 * exit 0 = left
	 * exit 1 = up
	 * exit 2 = right
	 * exit 3 = down
	 */
	
	
	public XPathCard(int rotation) {
		
		this.name = "X Path";
		this.rotation = rotation;
		
		this.exits[0] = true;
		this.exits[1] = true;
		this.exits[2] = true;
		this.exits[3] = true;
		
	}

	@Override
	public String getName() {
		
		return name;
	}

}
