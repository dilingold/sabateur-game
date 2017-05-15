package model.cards;

public interface Card {

	public String getType();
	public String getName();
	public Card doAction();
	public Card doAction(int row, int col);
	public boolean[] getExits();

}
