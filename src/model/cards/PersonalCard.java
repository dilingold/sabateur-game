package model.cards;

import model.PlayerD;

public abstract class PersonalCard implements Card, Cloneable{
		
	protected String name;
	private String type = "personal";
	protected String effect;
		
	public String getEffect() {
			
		return effect;
			
	}
	
	public boolean[] getExits() {
		
		return null;
	}
	
	@Override
	public String getType() {
			
		return type;
			
	}
	
	@Override
	public String getName() {
		
		return name;
		
	}
	
	@Override
	public Card doAction() {
		
		return this;
		
	}
	
	@Override
	public Card doAction(int row, int col) {
		return this;
	}
    
    @Override
    public Card getCopy(){
        try {
            return (Card) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public abstract void doAction(PlayerD currentPlayer, PlayerD targetPlayer);
		
}
