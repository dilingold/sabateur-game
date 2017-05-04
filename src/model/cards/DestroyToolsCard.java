package model.cards;

public abstract class DestroyToolsCard extends PersonalCard{

	public DestroyToolsCard() {
		
		this.name = "Destroy Tools";
		this.effect = "destroyTools";
		
	}
	
	@Override
	public String getName() {
		
		return name;
		
	}

}
