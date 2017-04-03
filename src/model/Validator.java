package model;
import model.*;
import model.cards.Card;

/**
 * Created by johnny on 3/30/17.
 */
public class Validator {

    public Validator() {
        //we also need a curse validator
    }

    
    
    public boolean checkMove(Card card, int row, int column){
    	Boolean validated = false;
    	
        if(card.type() == "path"){
        	validated = validatePath(card, row, column);
        }
        if(card.type() == "action"){
        	validated = validateAction(card, row, column);
        }
        if(validated == true){
        	//tell board to play card in location
    		//Board.getInstance().playCard(card, row, column)
    	}

        return validated;
    }

		private Boolean validatePath(Card card, int row, int column) {
			Boolean validated = false;
			//check if location is empty
			//if(Board.getInstance().isEmpty(row,column) == true){
				//check if any adjacent tiles are path cards
				//first check if there's a tile down
				//if(Board.getInstance().getCard((row-1), column) != null)
					//check if this tile has exit UP
					//if(Board.getInstance().getCard((row-1), column).getExits[1]
						//validated = true;
				//then left
				//if(Board.getInstance().getCard((row), column-1) != null)
					//check if this tile has exit RIGHT
					//if(Board.getInstance().getCard((row), column-1).getExits[2]
						//validated = true;
				//right
				//if(Board.getInstance().getCard((row), column+1) != null)
				//check if this tile has exit LEFT
				//if(Board.getInstance().getCard((row), column+1).getExits[0]
					//validated = true;
				//down
				//if(Board.getInstance().getCard((row+1), column) != null)
				//check if this tile has exit DOWN
				//if(Board.getInstance().getCard((row+1), column).getExits[3]
					//validated = true;
			//}
			return validated;
		}

		private Boolean validateAction(Card card, int row, int column) {
			Boolean validated = false;
			//get action card type
			String type = card.type();
			switch (type) {
            case "curse":
            		break;
            case "bomb":
					//check if location is not empty
					//if(Board.getInstance().isEmpty(row,column) != true){	
	            		validated = true;
	            	//}
	            	break;
			case "toxic":
					//what does toxic do?
					break;
			}
			return validated;
		}




}
