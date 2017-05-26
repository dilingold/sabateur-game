package Tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.DistributeGold;
import model.Miner;
import model.Player;
import model.Sabateur;
import model.cards.HeistCard;
import model.cards.PersonalCard;

public class HeistTest {
		
	public static void main(String[] args) {
		
		Player bob = new Miner("Bob", 0);
		Player jane = new Miner("Jane", 1);
		Player matt = new Sabateur("Matt", 2);
		Player al = new Sabateur("Al", 3);
		
		List<Player> players = new ArrayList<Player>();
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
		
		for (Player p : players) {
			
			System.out.println(p.getName() + " heists:");
			dg.distributeHeistsRecursive(p);
			
		}
		
		
	}
	
	public static void removeHeistRecursive(Player player, Player remove) {
		
		for(Iterator<Player> iterator = player.getPlannedHeists().iterator(); iterator.hasNext(); ) {
			Player p = iterator.next();
			if(p.equals(remove)) {
				
				iterator.remove();
				removeHeistRecursive(player, remove);
				
			}
			else removeHeistRecursive(p, remove);
			
		}
		
	}

}
