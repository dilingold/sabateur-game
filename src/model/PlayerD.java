package model;

import java.util.ArrayList;
import java.util.List;

import model.cards.Card;

public abstract class PlayerD {
	
    private String name;
    private int UID;
    protected String type;
    private String status;
    private Hand hand;
    private Boolean toolsDamaged = false;
    private Boolean hasPowerTool = false;
    private Boolean hasSuperPowerTool = false;
    private int gold;
    private List<PlayerD> exposedSabateurs = new ArrayList<PlayerD>();
    private List<PlayerD> heists = new ArrayList<PlayerD>();
    private PlayerD heistedBy = null;
    private PlayerD exposedBy = null;
    
    public PlayerD(String PlayerName, int UID) {

        name = PlayerName;
        hand = new Hand();
        this.gold = 0;
        this.UID = UID;
        
    }

    public String getName() {
    	
        return name;
        
    }

    public void setName(String name) {
    	
        this.name = name;
        
    }
    
    public String getType() {
    	
    	return type;
    	
    }
    
    public int getUID() {
    	
    	return UID;
    	
    }
    
    public void drawCard() {
    	
    	Card card = Deck.getInstance().draw();
    	if(card != null) {
    		
    		hand.addCard(card);
    		
    	}
    	
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
    
    public Boolean areToolsDamaged() {
    	
    	return toolsDamaged;
    	
    }
    
    public void changeToolsDamage() {
    	
    	if(toolsDamaged == true)
    		toolsDamaged = false;
    	else
    		toolsDamaged = true;
    	
    }
    
    public void givePowerTool() {
    	
    	hasPowerTool = true;
    	
    }
    
    public void removePowerTool() {
    	
    	hasPowerTool = false;
    	
    }
    
    public Boolean hasPowerTool() {
    	
    	return hasPowerTool;
    	
    }
    
    public Boolean hasSuperPowerTool() {
    	
    	return hasSuperPowerTool;
    	
    }
    
    public void giveSuperPowerTool() {
    	
    	hasSuperPowerTool = true;
    	hasPowerTool = false;
    	
    }
    
    public void removeSuperPowerTool() {
    	
    	hasSuperPowerTool = false;
    	
    }
    
    public int getGold() {
    	
    	return gold;
    	
    }
    
    public void addGold(int gold) {
    	
    	this.gold+=gold;
    	
    }
    
    public void removeGold(int gold) {
    	
    	if (this.gold >= gold)
    		this.gold-=gold;
 
    }
    
    public void exposeSabateur(PlayerD player) {
    	
    	exposedSabateurs.add(player);
    	
    }
    
    public List<PlayerD> getExposedSabateurs() {
    	
    	return exposedSabateurs;
    	
    }
    
    public boolean removeExposedSabateur(PlayerD player) {
    	
    	return exposedSabateurs.remove(player);
    	
    }
    
    public void setExposedBy(PlayerD player) {
    	
    	this.exposedBy = player;
    	
    }
    
    public PlayerD getExposedBy() {
    	
    	return exposedBy;
    	
    }
    
    public void planHeist(PlayerD player) {
    	
    	heists.add(player);
    	
    }
    
    public List<PlayerD> getPlannedHeists() {
    	
    	return heists;
    	
    }
    
    public boolean removeHeist(PlayerD player) {
    	
    	return heists.remove(player);
    	
    }
    
    public void setHeistedBy(PlayerD player) {
    	
    	this.heistedBy = player;
    	
    }
    
    public PlayerD getHeistedBy() {
    	
    	return heistedBy;
    	
    }
    
}