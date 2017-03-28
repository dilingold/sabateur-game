package model;

/** Main class to store player name and all relevant details on each player.
 * Extend player hand here?
 */

public class Player {
    private String name;
    private boolean role;

    // Constructor
    public Player (String PlayerName) {

        name = PlayerName;
    }

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
}
