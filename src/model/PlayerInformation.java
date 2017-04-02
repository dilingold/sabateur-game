package model;

import model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class PlayerInformation {

    private ArrayList<Player> players = null;

    private static PlayerInformation ourInstance = new PlayerInformation();

    public static PlayerInformation getInstance() {
        return ourInstance;
    }

    private PlayerInformation() {

    }

    public boolean createPlayers(String[] playerNames) {
        players = new ArrayList<>();
        //ArrayList<Card> hand  = new ArrayList<>();
        //Hand hand = new Hand();
        Deal deal = new Deal();
        int i = 0;
        for(String pNames: playerNames) {
            Hand hand = new Hand();
            Player player = new Player(pNames, hand);
            players.add(player);
            player.setUID(i);
            deal.fillhand(player);
            System.out.println(player.getName());
            player.getHand().print();
            i++;
        }

        return true;
    }

    public Player getPlayerByName(String name)
    {
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).getName().equals(name))
                return players.get(i);
        }

        return null;
    }

    public String getPlayerByPosition(int position){
        return players.get(position).getName();
    }

    public int playerCount()
    {
        return players.size();
    }

    public ArrayList<Player> getPlayerList(){
        return players;
    }

}