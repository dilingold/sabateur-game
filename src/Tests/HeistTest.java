package Tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.DistributeGold;
import model.Miner;
import model.PlayerD;
import model.Sabateur;
import model.cards.HeistCard;
import model.cards.PersonalCard;

public class HeistTest {
		
	public static void main(String[] args) {
		
		PlayerD bob = new Miner("Bob");
		PlayerD jane = new Miner("Jane");
		PlayerD matt = new Sabateur("Matt");
		PlayerD al = new Sabateur("Al");
		
		List<PlayerD> players = new ArrayList<PlayerD>();
		players.add(bob);
		players.add(jane);
		players.add(matt);
		players.add(al);
		
		DistributeGold dg = new DistributeGold();
		
		bob.planHeist(jane);
		jane.setHeistedBy(bob);
		
		jane.planHeist(matt);
		matt.setHeistedBy(jane);
		
		if (jane.getHeistedBy() != null) {
			
			jane.getHeistedBy().removeHeist(jane);
			removeHeistRecursive(jane, matt);
			matt.planHeist(jane);
			jane.setHeistedBy(matt);
			
		}
		else {
			
			removeHeistRecursive(al, jane);
			matt.planHeist(jane);
			jane.setHeistedBy(matt);
			
		}
		
		for (PlayerD p : players) {
			
			System.out.println(p.getName() + " heists:");
			dg.distributeHeistsRecursive(p);
			
		}
		
		
	}
	
	public static void removeHeistRecursive(PlayerD player, PlayerD remove) {
		
		for(Iterator<PlayerD> iterator = player.getPlannedHeists().iterator(); iterator.hasNext(); ) {
			PlayerD p = iterator.next();
			if(p.equals(remove)) {
				
				iterator.remove();
				removeHeistRecursive(player, remove);
				
			}
			else removeHeistRecursive(p, remove);
			
		}
		
	}

}
