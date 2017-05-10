package controller;

import model.Deck;
import model.Hand;
import model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//This class is the creator and information expert on Players
public class PlayerController {

    private ArrayList<Player> players = null;
    private static PlayerController ourInstance = new PlayerController();

    public static PlayerController getInstance() {
    	
        return ourInstance;
        
    }

    private PlayerController() {

    }

    public boolean createPlayers(String[] playerNames) {
    	
        players = new ArrayList<>();
                
        int i = 0;
        for(String pNames: playerNames) {
        	
        	System.out.println("Player" + i);
            Hand hand = new Hand();
            Player player = new Player(pNames, hand);
            players.add(player);
            player.setUID(i);
            i++;
            
        }
        
        return true;
        
    }
    
    public void dealPlayerHands() {
    	
    	for(Player player : players) {
			
			Hand hand = new Hand();
			
			for (int i = 0; i < 6; i++) {
				
				hand.addCard(Deck.getInstance().draw());
				
			}
			
			player.setHand(hand);
			
		}
    	
    }

    public Player getPlayerByPosition(int position) {
    	
        return players.get(position);
        
    }

    public int playerCount() {
    	
        return players.size();
        
    }

    public ArrayList<Player> getPlayerList() {
    	
        return players;
        
    }
    
    public void setPlayerRoles() {
    	
    	List<String> roles = new ArrayList<String>();    	
        for(int i = 0; i < playerCount(); i++) {
        		
        	if(i < playerCount()/2) {
        			
            	roles.add("sabateur");
            			
            }
            		
            else roles.add("miner");
        		
        }
        
        Collections.shuffle(roles);
        
        for (int i = 0; i < playerCount(); i++) {
        	
        	players.get(i).setRole(roles.get(i));
        	
        }
    	
    }
    
    public void clearPlayerHands() {
    	
    	for(Player player : players) {
    		
    		player.getHand().getCards().clear();
    		
    	}
    	
    }

}