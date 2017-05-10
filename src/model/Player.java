package model;

public class Player {
	
    private String name;
    private String role;
    private String status;
    private int UID;
    private Hand hand;
    private Boolean toolsDamaged = false;
    private int gold;

    public Player (String PlayerName, Hand hand, String role) {

        name = PlayerName;
        this.hand = hand;
        this.role = role;
        this.gold = 0;
        
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

    public String getRole() {
    	
        return role;
        
    }

    public void setRole(String role) {
    	
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
    
    public int getGold() {
    	
    	return gold;
    	
    }
    
    public void addGold(int gold) {
    	
    	this.gold+=gold;
    	
    }
    
}