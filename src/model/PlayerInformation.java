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
        players = new ArrayList<Player>();

        // Old Code
        /*for(int i = 0; i < playerNames.length; i++)
        {
            Player player = new Player(playerNames[i]);
            players.add(player);
        }*/
        for(String pNames: playerNames) {
            //System.out.println(pNames);
            Player player = new Player(pNames);
            players.add(player);
            System.out.println(player.getName());
        }

        players.get(0).setIsTurn(true);

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

    public void playersTurn() {

    }

    // test check whos turn
    public String checkTurn() {
        for(Player p: players) {
            if(p.getisTurn() == true){
                return p.getName();
            }
        }
        return null;
    }


}
