package model;

import java.util.ArrayList;

/** Main class to store player name and all relevant details on each player.
 * Extend player hand here?
 */

public class Player {
    private String name;
    private boolean role;
    private String status = null;
    private int UID;
    private Hand hand= null;

    // Constructor
    public Player (String PlayerName, Hand hand) {

        name = PlayerName;
        this.hand = hand;
    }

    public int getUID(){return UID;}

    public void setUID(int UID) {this.UID = UID;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public Hand getHand(){return hand;}

    public void setHand(Hand hand){this.hand = hand;};
}