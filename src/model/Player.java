package model;

/** Main class to store player name and all relevant details on each player.
 * Extend player hand here?
 */

public class Player {
    private String name;
    private boolean role;
    private String status = null;
    private boolean isTurn = false;
    private int UID;

    // Constructor
    public Player (String PlayerName) {

        name = PlayerName;
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

    public boolean getisTurn() {
        return isTurn;
    }
}
