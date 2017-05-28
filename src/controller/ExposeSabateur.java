package controller;

import java.util.Iterator;

import model.Player;

public class ExposeSabateur {
	
	public void playCard(Player currentPlayer, Player targetPlayer) {
		
		// expose sabateur can only be played on a sabateur
		if (targetPlayer.getType() == "sabateur") {
		
			// if target player is already being expose by another player, the original
			// player is removed and the current player becomes the new exposer
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
	
	// resursively make sure the current player exposing the target player is not being exposed
	// down the line by the target player
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
