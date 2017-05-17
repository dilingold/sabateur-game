package model.cards;

import model.PlayerD;

public class PowerToolCard extends PersonalCard implements Cloneable{
	
	public PowerToolCard() {
		
		this.name = "power tool";
		
	}

	@Override
	public void doAction(PlayerD currentPlayer, PlayerD targetPlayer) {
		
		if (targetPlayer.hasPowerTool()) {
			targetPlayer.removePowerTool();
			targetPlayer.giveSuperPowerTool();
			
		}
		
		else {
			
			if (!targetPlayer.hasSuperPowerTool()) {
		
				targetPlayer.givePowerTool();
				
			}
			
		}
		
	}

}
