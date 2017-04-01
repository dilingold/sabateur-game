package model;

import java.util.ArrayList;

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

        int i = 0;
        for(String pNames: playerNames) {

            Player player = new Player(pNames);
            players.add(player);
            player.setUID(i);
            System.out.println(player.getName());
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
