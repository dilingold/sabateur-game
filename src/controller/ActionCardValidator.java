package controller;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.cards.ActionCard;
import model.cards.Card;
import model.cards.PathCard;

public class ActionCardValidator {

	/**
	 * Validate path element
	 * 
	 * @pre.condition 0 <= row < board.numCols
	 * @pre.condition 0 <= column < board.numRows
	 * @post.condition $return != null
	 */
	
	private List<Card> visitedSquares;
	
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

		if (cardType.getType() == "action") {
			
			validated = validateAction((ActionCard) cardType, row, column);

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
				
				return false;
				
			}
				
			// if the square above to drop position is not empty, check that the exits match up
			if (squareUp != null && squareUp.getType() == "path") {
					
				if (!checkExits(card, squareUp, 1)) {
						
					return false;
						
				}
					
				else validated = true;
				
			}
				
			// if the square left of drop position is not empty, check that the exits match up
			if (squareLeft != null && squareLeft.getType() == "path") {
								
				if (!checkExits(card, squareLeft, 0)) {
					
					return false;
						
				}
					
				else validated = true;
				
			}
			// if the square right of drop position is not empty, check that the exits match up
			if (squareRight != null && squareRight.getType() == "path") {
									
				if (!checkExits(card, squareRight, 2)) {
					
					return false;
						
				}
					
				else validated = true;
				
			}
			// if the square below drop position is not empty, check that the exits match up
			if (squareDown != null && squareDown.getType() == "path") {
										
				if (!checkExits(card, squareDown, 3)) {
					
					return false;
					
				}
				
				else validated = true;
					
			}
			
			if (squareUp != null && (squareUp.getName() == "gold" || squareUp.getName() == "stone")) {
				
				if (!card.getExits()[1]) {
					
					return false;
						
				}
				
			}
			
			if (squareDown != null && (squareDown.getName() == "gold" || squareDown.getName() == "stone")) {
				
				if (!card.getExits()[3]) {
					
					return false;
						
				}
				
			}
			
			if (squareRight != null && (squareRight.getName() == "gold" || squareRight.getName() == "stone")) {
				
				if (!card.getExits()[2]) {
					
					return false;
						
				}
				
			}
			
			if (squareLeft != null && (squareLeft.getName() == "gold" || squareLeft.getName() == "stone")) {
				
				if (!card.getExits()[0]) {
					
					return false;
						
				}
				
			}
			
		}
		
		visitedSquares = new ArrayList<Card>();
		validated = (checkPathRecursive(row+1, column) || checkPathRecursive(row-1, column)
				|| checkPathRecursive(row, column+1) || checkPathRecursive(row, column-1));

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

	private Boolean validateAction(ActionCard card, int row, int column) {

		Boolean validated = false;
		
		if (Board.getInstance().getCard(row, column).getType() != "path") {
			
			return false;
			
		}
		PathCard boardLocation = (PathCard) Board.getInstance().getCard(row, column);
		
			if (card.getEffect() == "disable") {
				
				if (boardLocation.getIsToxic()) {
				
					return false;

				}
				
				else validated = true;
				
			}

			else if (card.getEffect() == "enable") {
				if (!boardLocation.getIsToxic()) {
					
					return false;
				
				}
				else validated = true;

			}
			
			return validated;

	}
	
	public boolean checkExits(Card playerCard, Card boardCard, int exit) {
		
		int boardExit;
		if (exit > 1) {
			boardExit = exit - 2;
		}
		else boardExit = exit + 2;

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
	
	public boolean checkPathRecursive(int row, int col) {

		boolean validated = false;
		
		Card square = null;
		
		if (row >= 0 && row < Board.getInstance().getRows()
				&& col >= 0 && col < Board.getInstance().getCols()) {
			square = Board.getInstance().getCard(row, col);
			if (!(square.getType() == "path")) 
				return false;
		}
		
		else return false;
		
		if (((PathCard)square).getIsToxic()) {
			System.out.println("toxic - returning false");
			return false;
		}
		
		for (Card square1: visitedSquares) {
			
			System.out.println("square " + square1.getName());
			if (square.equals(square1)) {
				
				System.out.println("revisiting square at " + row + ", " + col);
				System.out.println("revisited square " + square1.getName());
				return false;
				
			}
			
		}
		
		visitedSquares.add(square);
		System.out.println("adding " + square.getName() + " at " + row + ", " + col + " to visited list");
		
		// return true if player reaches start position
		System.out.println("checking if hit start position");
		if (square != null && square.getName() == "start") {
			System.out.println("hit start position - returning true");
			
			validated = true;
			
		}
		
		else if (square != null) {
			
			System.out.println("checking down");
			validated = checkPathRecursive(row+1, col);
				
			if (!validated) {
				System.out.println("checking right");
				validated = checkPathRecursive(row, col+1);
			}
			if (!validated) {
				System.out.println("checking up");
				validated = checkPathRecursive(row-1, col);
					
			}
			if (!validated){
				System.out.println("checking left");
				validated = checkPathRecursive(row, col-1);
			}
			
		}
		
		return validated;
	}

}
