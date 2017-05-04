package model.cards;

public class ToxicCard extends ActionCard {
	
	
	public ToxicCard() {
		
		this.name = "Toxic Card";
		this.effect = "disable";
		this.type = "toxic";
	}

	@Override
	public String getName() {
		
		return name;
	}

}
