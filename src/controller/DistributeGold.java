package controller;

import java.util.List;

import model.PlayerD;

public class DistributeGold {
	
	private static PlayerD topDogHeist;
	private static PlayerD topDogExpose;
		
	public static void currentPlayer(PlayerD currentPlayer) {
		
		if(currentPlayer.getType() == "miner") {
			
			currentPlayer.addGold(4);
			
		}
		
	}
	
	public static void miners() {
				
		List<PlayerD> players = PlayerController.getInstance().getPlayerList();
		for (PlayerD player : players) {
			
			if(player.getType() == "miner") {
				
				player.addGold(10);
				
			}
			
		}
		
	}
	
	public static void sabateurs() {
		
		List<PlayerD> players = PlayerController.getInstance().getPlayerList();
		for (PlayerD player : players) {
			
			if(player.getType() == "sabateur") {
				
				player.addGold(10);
				
			}
			
		}
		
	}
	
	public static void heistedMiners() {
		
		for (PlayerD p : PlayerController.getInstance().getPlayerList()) {
			
			topDogHeist = p;
			System.out.println(p.getName() + " heists:");
			distributeHeistsRecursive(p);
			
		}
		
	}
	
	public static void exposedSabateurs() {
		
		for (PlayerD p : PlayerController.getInstance().getPlayerList()) {
			
			topDogExpose = p;
			System.out.println(p.getName() + " exposed:");
			distributeExposedSabRecursive(p);
			
		}
		
	}
	
	public static void distributeHeistsRecursive(PlayerD player) {
		
		for (PlayerD p : player.getPlannedHeists()) {

			System.out.println(p.getName());
			if (p.getGold() > 0) {
				
				topDogHeist.addGold(1);
				p.removeGold(1);
				
			}
			distributeHeistsRecursive(p);
			
		}
		
	}
	
	public static void distributeExposedSabRecursive(PlayerD player) {
		
		for (PlayerD p : player.getExposedSabateurs()) {

			System.out.println(p.getName());
			if (p.getGold() > 0) {
				
				topDogExpose.addGold(1);
				p.removeGold(1);
				
			}

			distributeExposedSabRecursive(p);
			
		}
		
	}

}
