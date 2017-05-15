package controller;

import model.Board;
import model.cards.Card;

public class ActionCardValidator {

	/**
	 * Validate path element
	 * 
	 * @pre.condition 0 <= row < board.numCols
	 * @pre.condition 0 <= column < board.numRows
	 * @post.condition $return != null
	 */
	public boolean checkMove(Card cardType, int row, int column) {

		assert 0 < row;
		assert row < Board.getInstance().getRows();
		assert 0 <= column;
		assert column < Board.getInstance().getCols();
		
		Boolean validated = false;

		if (cardType.getType() == "path") {

			validated = validatePath(cardType, row, column);
			return validated;

		}

		if (cardType.getType() == "toxic") {
			
			validated = validateAction(cardType, row, column);

		}

		if (validated == true) {

			// tell board to play card in location
			Board.getInstance().playCard(row, column, cardType);
		}

		return validated;

	}



	private Boolean validatePath(Card card, int row, int column) {

		Boolean validated = false;
		
		if (card.getType() == "path") {
			Card dropLocation = Board.getInstance().getCard(row, column);
			Card squareUp = null;
			Card squareDown = null;
			Card squareLeft = null;
			Card squareRight = null;
			if(row > 0)
				squareUp = Board.getInstance().getCard((row - 1), column);
			if(row < Board.getInstance().getRows()-1)
				squareDown = Board.getInstance().getCard((row + 1), column);
			if(column < Board.getInstance().getCols()-1)
				squareRight = Board.getInstance().getCard(row, (column + 1));
			if(column > 0)
				squareLeft = Board.getInstance().getCard(row, (column - 1));
			
			//check that player is dropping card in an empty position
			if (!(dropLocation.getName() == "blank card")) {
				
				System.out.println("invalid - non blank drop location");
				return false;
				
			}
				
			// if the square above to drop position is not empty, check that the exits match up
			if (squareUp != null && squareUp.getType() == "path") {

				System.out.println("checking exits square up...");
					
				if (!checkExits(card, squareUp, 1)) {
						
					System.out.println("invalid square up");
					return false;
						
				}
					
				else validated = true;
				System.out.println("valid square up...");
				
			}
				
			// if the square left of drop position is not empty, check that the exits match up
			if (squareLeft != null && squareLeft.getType() == "path") {
				
				System.out.println("checking square left");
				
				if (!checkExits(card, squareLeft, 0)) {
					
					System.out.println("invalid square left");
					return false;
						
				}
					
				else validated = true;
				System.out.println("valid square left...");
				
			}
			// if the square right of drop position is not empty, check that the exits match up
			if (squareRight != null && squareRight.getType() == "path") {
					
				System.out.println("checking square right");
				
				if (!checkExits(card, squareRight, 2)) {
					
					System.out.println("invalid square right");
					return false;
						
				}
					
				else validated = true;
				System.out.println("valid square right...");
				
			}
			// if the square below drop position is not empty, check that the exits match up
			if (squareDown != null && squareDown.getType() == "path") {
					
				System.out.println("checking square down");
					
				if (!checkExits(card, squareDown, 3)) {
					
					System.out.println("invalid square down");
					return false;
					
				}
				
				else validated = true;
				System.out.println("valid square down...");
					
			}
			
			if (squareUp != null && (squareUp.getName() == "gold" || squareUp.getName() == "stone")) {
				
				if (!card.getExits()[1]) {
					
					System.out.println("invalid square up");
					return false;
						
				}
				
			}
			
			if (squareDown != null && (squareDown.getName() == "gold" || squareDown.getName() == "stone")) {
				
				if (!card.getExits()[3]) {
					
					System.out.println("invalid square down");
					return false;
						
				}
				
			}
			
			if (squareRight != null && (squareRight.getName() == "gold" || squareRight.getName() == "stone")) {
				
				if (!card.getExits()[2]) {
					
					System.out.println("invalid square right");
					return false;
						
				}
				
			}
			
			if (squareLeft != null && (squareLeft.getName() == "gold" || squareLeft.getName() == "stone")) {
				
				if (!card.getExits()[0]) {
					
					System.out.println("invalid square left");
					return false;
						
				}
				
			}
			
		}

		return validated;

	}
	
	public boolean checkSuperPowerMove(Card card, int row, int col) {
				
		if(row > Board.getInstance().getRows()-1 || row < 0 || 
				col > Board.getInstance().getCols()-1 || col < 0) {
			
			return false;
			
		}
		
		Card boardLocation = Board.getInstance().getCard(row, col);
		if(boardLocation.getName() == "stone" || boardLocation.getName() == "gold" 
				|| boardLocation.getName() == "start") {
			
			System.out.println("returning false " + boardLocation.getName());
			return false;
			
		}
				
		return true;
		
	}

	private Boolean validateAction(Card cardType, int row, int column) {

		Boolean validated = false;

		// get action card type
		String type = cardType.getName();

		switch (type) {

		case "clean":
			//needs code for assignment 2
			if (Board.getInstance().getCard(row, column).getType() == "path") {
				
				validated = true;

			}
			break;

		case "bomb":
			// check if location is not empty
			if (Board.getInstance().getCard(row, column).getType() == "path") {
				
				validated = true;
				
			}
			break;

		case "Toxic Card":
			// needs code for assignment 2
			if (Board.getInstance().getCard(row, column).getType() == "path") {
				System.out.println("validated");
				validated = true;

			}
			break;

		}

		return validated;

	}
	
	public boolean checkExits(Card playerCard, Card boardCard, int exit) {
		
		int boardExit;
		if (exit > 1) {
			boardExit = exit - 2;
		}
		else boardExit = exit + 2;
		System.out.println("card exit: " + exit + playerCard.getExits()[exit] + " board exit: " + boardExit + boardCard.getExits()[boardExit]);
		if (playerCard.getExits()[exit] && boardCard.getExits()[boardExit]) {
			return true;
		}
		else return false;
		
	}
	
	public boolean checkMinersWin(int row, int col) {
				
		//check if square to the right is gold
		if (col < Board.getInstance().getCols()-1 && Board.getInstance().getCard(row, col+1) != null) { 
			if (Board.getInstance().getCard(row, col+1).getName() == "gold") {
				
				return true;
				
			}
			
		}
		
		//check if square to the left is gold
		if (col > 0 && Board.getInstance().getCard(row, col-1) != null) { 
			
			if (Board.getInstance().getCard(row, col-1).getName() == "gold") {
				
				return true;
				
			}
			
		}
		
		//check if square to the top is gold
		if (row > 0 && Board.getInstance().getCard(row-1, col) != null) { 
						
			if (Board.getInstance().getCard(row-1, col).getName() == "gold") {
				
				return true;
				
			}
			
		}
		
		//check if square to the bottom is gold
		if (row < Board.getInstance().getRows()-1 && Board.getInstance().getCard(row+1, col) != null) { 
			
			if (Board.getInstance().getCard(row+1, col).getName() == "gold") {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public Boolean checkSabateursWin() {
				
		if (GameEngine.getNextPlayer().getHand().cardCount() == 0) {
			
			return true;
			
		}
		
		return false;
		
	}

}
