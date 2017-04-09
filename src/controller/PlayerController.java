package controller;

import model.Hand;
import model.Player;

import java.util.ArrayList;

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
        Deal deal = new Deal();
        
        int i = 0;
        for(String pNames: playerNames) {
        	
            Hand hand = new Hand();
            Player player = new Player(pNames, hand);
            players.add(player);
            player.setUID(i);
            deal.deal(player);
            i++;
            
        }

        return true;
        
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

}