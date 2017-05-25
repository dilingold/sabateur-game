package controller;

import model.Player;
import model.cards.PersonalCard;

public class PersonalCardValidator {
	
	public Boolean checkMove(PersonalCard card, Player currentPlayer, Player targetPlayer) {

		if (card.getName() == "expose") {
			
			if (currentPlayer.equals(targetPlayer)) {
				
				return false;
				
			}
			
		}
		
		else if (card.getName() == "heist") {
			
			if (currentPlayer.equals(targetPlayer)) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	public boolean checkMove(PersonalCard card, Player target) {
		
		Boolean validated = false;
		if(card.getName() == "expose") {
			
			
			
		}
		
		if(card.getEffect() == "destroyTools") {
				
			if(target.areToolsDamaged() == false) {
					
				target.changeToolsDamage();
				validated = true;
					
			}
				
			if(card.getEffect() == "fix") {
				
				if(target.areToolsDamaged() == true) {
					
					target.changeToolsDamage();
					validated = true;
					
				}	
				
			}
			
		}
			
		return validated;
		
	}	

}
