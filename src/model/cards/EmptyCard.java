package model.cards;

public class EmptyCard extends BoardCard {

	public EmptyCard() {
		
		this.name = "blank card";
		
	}
	
    public Card getCopy() {
        try {
            return (Card) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
