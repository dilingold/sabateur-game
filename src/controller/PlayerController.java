package controller;

import model.Deck;
import model.Hand;
import model.Miner;
import model.PlayerD;
import model.Sabateur;
import model.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//This class is the creator and information expert on Players
public class PlayerController {

    private static ArrayList<PlayerD> players = null;
    private static PlayerController ourInstance = new PlayerController();

    public static PlayerController getInstance() {
    	
        return ourInstance;
        
    }

    private PlayerController() {

    }

    public boolean createPlayers(String[] playerNames) {
    	
        players = new ArrayList<>();
        List<String> roles = setPlayerRoles(playerNames.length);
                
        int i = 0;
        for(String pNames: playerNames) {
        	
        	if (roles.get(i) == "miner") {
        		
        		PlayerD player = new Miner(pNames, i);
                players.add(player);
        		
        	}
        	
        	else {
        		
        		PlayerD player = new Sabateur(pNames, i);
        		players.add(player);
        		
        	}
            i++;
            
        }
        
        return true;
        
    }
    
    public void dealPlayerHands() {
    	
    	for(PlayerD player : players) {
			
			Hand hand = new Hand();
			
			for (int i = 0; i < 6; i++) {
				
				hand.addCard(Deck.getInstance().draw());
				
			}
			
			player.setHand(hand);
			
		}
    	
    }

    public PlayerD getPlayerByPosition(int position) {
    	
        return players.get(position);
        
    }

    public int playerCount() {
    	
        return players.size();
        
    }

    public ArrayList<PlayerD> getPlayerList() {
    	
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
    	
    	for(PlayerD player : players) {
    		
    		player.getHand().getCards().clear();
    		
    	}
    	
    }
    public static ArrayList<PlayerD> getPlayers(){
        return players;
    }
    public static ArrayList<ArrayList<Card>> getHands(){
        ArrayList<ArrayList<Card>> handList = new ArrayList<ArrayList<Card>>();
        for(int i = 0; i < players.size(); i++){
            ArrayList<Card> handOfPlayer = new ArrayList<Card>();
            for(int j = 0; j < (players.get(i).getHand().getHand().size()); j++){
                handOfPlayer.add(players.get(i).getHand().getHand().get(j));
            }
            handList.add(handOfPlayer);
        }
        return handList;
    }
    public static void setHand(ArrayList<ArrayList<Card>> priorHandList){
        for(int i = 0; i < players.size(); i++){
                players.get(i).getHand().setHand(priorHandList.get(i));
        }
    }
    
    public static void setPlayers(ArrayList<PlayerD> oldPlayers){
        players = oldPlayers;
    }
    public static ArrayList<PlayerD> copyPlayerList(){
        ArrayList<PlayerD> playersCopy = new ArrayList<PlayerD>();
        for(int i = 0; i < players.size(); i ++){
            playersCopy.add(players.get(i));
        }
        return playersCopy;
    }

}