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

}
