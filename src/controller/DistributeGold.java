package controller;

import java.util.List;

import model.Player;

public class DistributeGold {
	
	public static void currentPlayer(Player currentPlayer) {
		
		if(currentPlayer.getRole() == "miner") {
			
			currentPlayer.addGold(1);
			
		}
		
	}
	
	public static void miners() {
		
		List<Player> players = PlayerController.getInstance().getPlayerList();
		for (Player player : players) {
			
			if(player.getRole() == "miner") {
				
				player.addGold(1);
				
			}
			
		}
		
	}
	
	public static void sabateurs() {
		
		List<Player> players = PlayerController.getInstance().getPlayerList();
		for (Player player : players) {
			
			if(player.getRole() == "sabateur") {
				
				player.addGold(1);
				
			}
			
		}
		
	}

}
