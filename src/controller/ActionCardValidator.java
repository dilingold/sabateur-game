package controller;
import model.Board;
import model.cards.Card;

public class ActionCardValidator {

	public boolean checkMove(Card cardType, int row, int column) {

		Boolean validated = false;
		System.out.println(cardType.getType());

		if(cardType.getType() == "path") {

			validated = validatePath(cardType, row, column);
			return validated;

		}

		if(cardType.getType() == "action") {

			validated = validateAction(cardType, row, column);

		}

		if(validated == true) {

			//tell board to play card in location
			Board.getInstance().setGameBoard(row, column, cardType);
		}

		return validated;

	}

    //Code for Assignment 2
	private Boolean validatePath(Card cardType, int row, int column) {

		Boolean validated = false;
		String type = cardType.getType();
		switch (type) {
		
			case "path":
				if (Board.getInstance().getGameBoard(row, column).getType() == "action") {
					
					validated = false;
					
				}
				
				System.out.println("TEST");
				System.out.println(Board.getInstance().getGameBoard(row, column).getType());
				if (Board.getInstance().getGameBoard(row, column).getType() == "blank") {
					
					validated = true;
					
				}
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
		}
		
		return validated;
		
	}

	private Boolean validateAction(Card cardType, int row, int column) {

		Boolean validated = false;

		//get action card type
		String type = cardType.getName();
		
		switch (type) {
		
          case "curse":
			if(Board.getInstance().getGameBoard(row,column).getType() == "path") {
				
				validated = true;
				
			}
			break;
			
           case "bomb":
			//check if location is not empty
			if(Board.getInstance().getGameBoard(row,column).getType() == "path") {
				
				validated = true;
				
			}
			break;
			
            case "Toxic Card":
			//what does toxic do?
			if(Board.getInstance().getGameBoard(row,column).getType() == "path") {
				
				validated = true;
				
			}
			break;
			
		}

		return validated;

	}

}