package controller;

import java.util.Iterator;

import model.Player;

public class ExposeSabateur {
	
	public void playCard(Player currentPlayer, Player targetPlayer) {
		
		if (targetPlayer.getType() == "sabateur") {
		
			if (targetPlayer.getExposedBy() != null) {
			
				targetPlayer.getExposedBy().removeExposedSabateur(targetPlayer);
				removeExposedSabRecursive(targetPlayer, currentPlayer);
				currentPlayer.exposeSabateur(targetPlayer);
				targetPlayer.setExposedBy(currentPlayer);
			
			}
			else {
			
				removeExposedSabRecursive(targetPlayer, currentPlayer);
				currentPlayer.exposeSabateur(targetPlayer);
				targetPlayer.setExposedBy(currentPlayer);
				
			}
			
		}
		
	}
	
	public void removeExposedSabRecursive(Player topPlayer, Player removePlayer) {
		
		for(Iterator<Player> iterator = topPlayer.getExposedSabateurs().iterator(); iterator.hasNext(); ) {
			
			Player p = iterator.next();
			
			if(p.equals(removePlayer)) {
				
				iterator.remove();
				removeExposedSabRecursive(topPlayer, removePlayer);
				
			}
			
			else removeExposedSabRecursive(p, removePlayer);
			
		}
		
	}

}
