package controller;
import model.Player;
import model.cards.PersonalCard;

public class PersonalCardValidator {
	
	
	public boolean checkMove(PersonalCard card, Player target) {
		Boolean validated = false;
			if(card.getEffect() == "destroyTools"){
				if(target.areToolsDamaged() == false){
					target.changeToolsDamage();
					validated = true;
				}
			if(card.getEffect() == "fix"){
				if(target.areToolsDamaged() == true){
					target.changeToolsDamage();
					validated = true;
				}	
			}
			
		}
		return validated;
	}	

}
