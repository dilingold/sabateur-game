package controller;

import java.util.Iterator;

import model.Player;

public class PlanHeist {
	
	public void playCard(Player currentPlayer, Player targetPlayer) {
		
		// heist card can only be played on a miner
		if (targetPlayer.getType() == "miner") {
		
			// if target player is already being heisted by another player, the original
			// player is removed and the current player becomes the new heister
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
		
	}
	
	// resursively make sure the current player heisting the target player is not being heisted
	// down the line by the target player
	public void removeHeistRecursive(Player topPlayer, Player removePlayer) {
		
		for(Iterator<Player> iterator = topPlayer.getPlannedHeists().iterator(); iterator.hasNext(); ) {
			
			Player p = iterator.next();
			
			if(p.equals(removePlayer)) {
				
				iterator.remove();
				removeHeistRecursive(topPlayer, removePlayer);
				
			}
			
			else removeHeistRecursive(p, removePlayer);
			
		}
		
	}

}
