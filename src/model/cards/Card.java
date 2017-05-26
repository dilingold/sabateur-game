package model.cards;

public interface Card {

	public String getType();
	public String getName();
	public boolean[] getExits();
	public Card getCopy();

}
