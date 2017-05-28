package model.cards;

public abstract class PathCard implements Card, Cloneable{

    protected String type;
    protected String name;
    protected boolean[] exits = new boolean[4];
    protected int rotation = 0;
    protected boolean isToxic = false;
    protected boolean isInfested = false;
    protected boolean isBlocked = false;


    public PathCard() {

        type = "path";

    }

    public boolean[] getExits() {

        return exits;

    }

    //Cycles each of the varibles in the exits array the amount
    //of times the card has been rotated, then returns the result.
    //Does not change the original exits array variable.
    private void rotateExits() {
        
        boolean tmp = exits[3];
        exits[3] = exits[2];
        exits[2] = exits[1];
        exits[1] = exits[0];
        exits[0] = tmp;
        
    }

    public int getRotation() {

        return rotation;

    }

    // changes rotation one tick.
    // rotate card by clicking on it in the player's hand
    public void changeRotation() {

        rotateExits();
        if (rotation == 3)
            rotation = 0;
        else
            rotation++;

    }

    @Override
    public String getType() {

        return type;

    }

    @Override
    public String getName() {

        return name;

    }


    public boolean getIsToxic() {

        return isToxic;

    }

    public void setIsToxic(boolean isToxic) {

        this.isToxic = isToxic;

    }
    
    public boolean getIsInfested() {

        return isInfested;

    }

    public void setIsInfested(boolean isInfested) {

        this.isInfested = isInfested;

    }
    
    public boolean getIsBlocked() {

        return isBlocked;

    }

    public void setIsBlocked(boolean isBlocked) {

        this.isBlocked = isBlocked;

    }

    public Card getCopy() {
        try {
            return (Card) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
