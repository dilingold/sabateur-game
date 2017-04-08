package model;

public class Player {
	
    private String name;
    private boolean role;
    private String status;
    private int UID;
    private Hand hand;
    private Boolean toolsDamaged = false;

    public Player (String PlayerName, Hand hand) {

        name = PlayerName;
        this.hand = hand;
        
    }

    public int getUID() {
    	
    	return UID;
    	
    }

    public void setUID(int UID) {
    	
    	this.UID = UID;
    	
    }

    public String getName() {
    	
        return name;
        
    }

    public void setName(String name) {
    	
        this.name = name;
        
    }

    public boolean getRole() {
    	
        return role;
        
    }

    public void setRole(boolean role) {
    	
        this.role = role;
        
    }

    public Hand getHand() {
    	
    	return hand;
    	
    }

    public void setHand(Hand hand) {
    	
    	this.hand = hand;
    	
    }
    
    public String getStatus() {
    	
    	return status;
    	
    }

    public void setStatus(String status) {
    	
    	this.status = status;
    	
    }
    public Boolean areToolsDamaged(){
    	return toolsDamaged;
    }
    public void changeToolsDamage(){
    	if(toolsDamaged == true)
    		toolsDamaged = false;
    	else
    		toolsDamaged = true;
    }
    
}