package controller;

import java.util.Iterator;

import model.Player;

public class PlanHeist {
	
	public void playCard(Player currentPlayer, Player targetPlayer) {
		
		if (targetPlayer.getType() == "miner") {
		
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
