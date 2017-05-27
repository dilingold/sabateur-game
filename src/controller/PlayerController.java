package controller;

import model.Deck;
import model.Hand;
import model.Miner;
import model.Player;
import model.Sabateur;

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

    public void reset() {
        clearPlayerHands();
        dealPlayerHands();
        GameEngine.setCurrentPlayerIndex(0);
    }

    private PlayerController() {

    }

    public boolean createPlayers(String[] playerNames) {
    	
        players = new ArrayList<>();
        List<String> roles = setPlayerRoles(playerNames.length);
                
        int i = 0;
        for(String pNames: playerNames) {
        	
        	if (roles.get(i) == "miner") {
        		
        		Player player = new Miner(pNames, i);
                players.add(player);
        		
        	}
        	
        	else {
        		
        		Player player = new Sabateur(pNames, i);
        		players.add(player);
        		
        	}
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
    
    public List<String> setPlayerRoles(int size) {
    	
    	List<String> roles = new ArrayList<String>();    	
        for(int i = 0; i < size; i++) {
        		
        	if(i < size/2) {
        			
            	roles.add("sabateur");
            			
            }
            		
            else roles.add("miner");
        		
        }
        
        Collections.shuffle(roles);
        return roles;
    	
    }
    
    public void clearPlayerHands() {
    	
    	for(Player player : players) {
    		
    		player.getHand().getCards().clear();
    		
    	}
    	
    }

}