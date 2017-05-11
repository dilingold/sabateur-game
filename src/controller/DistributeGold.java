package controller;

import java.util.List;

import model.PlayerD;

public class DistributeGold {
	
	public static void currentPlayer(PlayerD currentPlayer) {
		
		for (PlayerD p : PlayerController.getInstance().getPlayerList()) {
			
			System.out.println(p.getName() + " heists:");
			distributeHeistsRecursive(p);
			
			System.out.println(p.getName() + " exposed:");
			distributeExposedSabRecursive(p);
			
		}
		if(currentPlayer.getType() == "miner") {
			
			currentPlayer.addGold(1);
			
		}
		
	}
	
	public static void miners() {
		
		List<PlayerD> players = PlayerController.getInstance().getPlayerList();
		for (PlayerD player : players) {
			
			if(player.getType() == "miner") {
				
				player.addGold(1);
				
			}
			
		}
		
	}
	
	public static void sabateurs() {
		
		List<PlayerD> players = PlayerController.getInstance().getPlayerList();
		for (PlayerD player : players) {
			
			if(player.getType() == "sabateur") {
				
				player.addGold(1);
				
			}
			
		}
		
	}
	
	public static void distributeHeistsRecursive(PlayerD player) {
		
		for (PlayerD p : player.getPlannedHeists()) {

			System.out.println(p.getName());
			distributeHeistsRecursive(p);
			
		}
		
	}
	
	public static void distributeExposedSabRecursive(PlayerD player) {
		
		for (PlayerD p : player.getExposedSabateurs()) {

			System.out.println(p.getName());
			distributeExposedSabRecursive(p);
			
		}
		
	}

}
