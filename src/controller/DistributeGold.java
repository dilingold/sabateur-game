package controller;

import java.util.List;

import model.Player;

public class DistributeGold {
	
	private static Player topDogHeist;
	private static Player topDogExpose;
		
	// if the player to find gold is a miner, give them 4 extra gold 
	public static void currentPlayer(Player currentPlayer) {
		
		if(currentPlayer.getType() == "miner") {
			
			currentPlayer.addGold(4);
			
		}
		
	}
	
	// distributes 10 gold to each miner
	public static void miners() {
				
		List<Player> players = PlayerController.getInstance().getPlayerList();
		for (Player player : players) {
			
			if(player.getType() == "miner") {
				
				player.addGold(10);
				
			}
			
		}
		
	}
	
	// distributes 10 gold to each saboteur
	public static void sabateurs() {
		
		List<Player> players = PlayerController.getInstance().getPlayerList();
		for (Player player : players) {
			
			if(player.getType() == "sabateur") {
				
				player.addGold(10);
				
			}
			
		}
		
	}
	
	// distributes gold to players who successfully planned a heist on a miner
	public static void heistedMiners() {
		
		for (Player p : PlayerController.getInstance().getPlayerList()) {
			
			topDogHeist = p;
			System.out.println(p.getName() + " heists:");
			distributeHeistsRecursive(p);
			
		}
		
	}
	
	// distributes gold to players who successfully exposed a saboteur
	public static void exposedSabateurs() {
		
		for (Player p : PlayerController.getInstance().getPlayerList()) {
			
			topDogExpose = p;
			System.out.println(p.getName() + " exposed:");
			distributeExposedSabRecursive(p);
			
		}
		
	}
	
	public static void distributeHeistsRecursive(Player player) {
		
		for (Player p : player.getPlannedHeists()) {

			System.out.println(p.getName());
			if (p.getGold() > 0) {
				
				topDogHeist.addGold(1);
				p.removeGold(1);
				
			}
			distributeHeistsRecursive(p);
			
		}
		
	}
	
	public static void distributeExposedSabRecursive(Player player) {
		
		for (Player p : player.getExposedSabateurs()) {

			System.out.println(p.getName());
			if (p.getGold() > 0) {
				
				topDogExpose.addGold(1);
				p.removeGold(1);
				
			}

			distributeExposedSabRecursive(p);
			
		}
		
	}

}
