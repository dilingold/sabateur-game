package controller;

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
        
        int numPlayers = playerNames.length;
        
        List<String> roles = new ArrayList<String>();    	
        for(int i = 0; i < numPlayers; i++) {
        		
        	if(i < numPlayers/2) {
        			
            	roles.add("miner");
            			
            }
            		
            else roles.add("sabateur");
        		
        }
        
        Collections.shuffle(roles);
        
        int i = 0;
        for(String pNames: playerNames) {
        	
            Hand hand = new Hand();
            Player player = new Player(pNames, hand, roles.get(i));
            players.add(player);
            player.setUID(i);
            i++;
            
        }

        return true;
        
    }
    
    public void dealPlayerHands() {
    	
    	Deal deal = new Deal();
    	for(Player player : players) {
    		
    		deal.deal(player);
    		
    	}
    	
    }
    
    public void distributeGold() {
    	
    	
    	
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
    
    public void clearPlayerHands() {
    	
    	for(Player player : players) {
    		
    		player.getHand().getCards().clear();
    		
    	}
    	
    }

}