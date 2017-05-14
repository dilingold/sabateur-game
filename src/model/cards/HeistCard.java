package model.cards;

import java.util.Iterator;

import model.PlayerD;

public class HeistCard extends PersonalCard {
	
	public HeistCard() {
		
		this.name = "heist";
		
	}
	
	public void doAction(PlayerD currentPlayer, PlayerD targetPlayer) {
		
		if (targetPlayer.getHeistedBy() != null) {
			
			targetPlayer.getHeistedBy().removeHeist(targetPlayer);
			removeHeistRecursive(targetPlayer, currentPlayer);
			currentPlayer.planHeist(targetPlayer);
			targetPlayer.setHeistedBy(currentPlayer);
			
		}
		else {
			
			removeHeistRecursive(targetPlayer, currentPlayer);
			currentPlayer.planHeist(targetPlayer);
			targetPlayer.setHeistedBy(currentPlayer);
			
		}
		
	}
	
	public void removeHeistRecursive(PlayerD topPlayer, PlayerD removePlayer) {
		
		for(Iterator<PlayerD> iterator = topPlayer.getPlannedHeists().iterator(); iterator.hasNext(); ) {
			
			PlayerD p = iterator.next();
			
			if(p.equals(removePlayer)) {
				
				iterator.remove();
				removeHeistRecursive(topPlayer, removePlayer);
				
			}
			
			else removeHeistRecursive(p, removePlayer);
			
		}
		
	}

}
