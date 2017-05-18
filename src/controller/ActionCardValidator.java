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

	private Boolean validatePath(Card card, int row, int col) {

		Boolean validated = false;
		
		//check that dropped card matches any neighboring cards and leads back to start
		if (Board.getInstance().getCard(row, col).getType() == "path") {
			return false;
		}
		Card squareUp = null;
		Card squareDown = null;
		Card squareLeft = null;
		Card squareRight = null;
		if(row > 0)
			squareUp = Board.getInstance().getCard((row - 1), col);
		if(row < Board.getInstance().getRows()-1)
			squareDown = Board.getInstance().getCard((row + 1), col);
		if(col < Board.getInstance().getCols()-1)
			squareRight = Board.getInstance().getCard(row, (col + 1));
		if(col > 0)
			squareLeft = Board.getInstance().getCard(row, (col - 1));
		
		// check that dropped card is attached on at least one side to another path card
		boolean attachedToPath = false;
		
		boolean squareDownIsPath = squareDown != null && squareDown.getType() == "path" 
				&& !((PathCard)squareDown).getIsToxic();
		boolean squareRightIsPath = squareRight != null && squareRight.getType() == "path"
				&& !((PathCard)squareRight).getIsToxic();
		boolean squareUpIsPath = squareUp != null && squareUp.getType() == "path"
				&& !((PathCard)squareUp).getIsToxic();
		boolean squareLeftIsPath = squareLeft != null && squareLeft.getType() == "path"
				&& !((PathCard)squareLeft).getIsToxic();
		
		boolean attachedToSquareDown = squareDownIsPath && checkExitsTrue(card, squareDown, 3);
		boolean attachedToSquareRight = squareRightIsPath && checkExitsTrue(card, squareRight, 2);
		boolean attachedToSquareUp = squareUpIsPath && checkExitsTrue(card, squareUp, 1);
		boolean attachedToSquareLeft = squareLeftIsPath && checkExitsTrue(card, squareLeft, 0);
		
		if (!(attachedToSquareDown || attachedToSquareRight || attachedToSquareUp || attachedToSquareLeft)) {
			return false;
		}
		
		else attachedToPath = true;
		
		// check that dropped cards' sides match up to all surrounding path cards - exits are either
		// both true or both false
		boolean validPathPosition = false;
		
		if (squareDownIsPath) {
			
			if (!checkExitsMatch(card, squareDown, 3)) {
				return false;
			}
			
			validPathPosition = true;
			
		}
		if (squareRightIsPath) {
			
			if (!checkExitsMatch(card, squareRight, 2)) {
				return false;
			}
			validPathPosition = true;
			
		}
		
		if (squareUpIsPath) {
			if (!checkExitsMatch(card, squareUp, 1)) {
				return false;
			}
			validPathPosition = true;
			
		}
		
		if (squareLeftIsPath) {
			if (!checkExitsMatch(card, squareLeft, 0)) {
				return false;
			}
			validPathPosition = true;
			
		}
		
		// recursively check the path successfully leads back to start position
		visitedSquares = new ArrayList<Card>();
		boolean validPathToStart = (checkPathRecursive(row+1, col) || checkPathRecursive(row-1, col)
				|| checkPathRecursive(row, col+1) || checkPathRecursive(row, col-1));
		
		if (attachedToPath && validPathPosition && validPathToStart) {
			
			return true;
			
		}
		
		else return false;

	}
	
	public boolean checkPathRecursive(int row, int col) {

		boolean validated = false;
		
		Card square = null;
		// check square is on board
		if (row >= 0 && row < Board.getInstance().getRows()
				&& col >= 0 && col < Board.getInstance().getCols()) {
			square = Board.getInstance().getCard(row, col);
			if (!(square.getType() == "path")) 
				return false;
		}
		
		else return false;
		
		// check if square is disabled
		if (((PathCard)square).getIsToxic()) {
			System.out.println("toxic - returning false");
			return false;
		}
		
		// check square has not already been visited
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
			
			Card squareUp = null;
			Card squareDown = null;
			Card squareLeft = null;
			Card squareRight = null;
			if(row > 0)
				squareUp = Board.getInstance().getCard((row - 1), col);
			if(row < Board.getInstance().getRows()-1)
				squareDown = Board.getInstance().getCard((row + 1), col);
			if(col < Board.getInstance().getCols()-1)
				squareRight = Board.getInstance().getCard(row, (col + 1));
			if(col > 0)
				squareLeft = Board.getInstance().getCard(row, (col - 1));
			
			// check square below
			if (squareDown != null && checkExitsTrue(square, squareDown, 3)) {
				System.out.println("checking down");
				validated = checkPathRecursive(row+1, col);
			}
				
			// check square to right
			if (!validated && squareRight != null && checkExitsTrue(square, squareRight, 2)) {
				System.out.println("checking right");
				validated = checkPathRecursive(row, col+1);
			}
			
			// check square above
			if (!validated && squareUp != null && checkExitsTrue(square, squareUp, 1)) {
				System.out.println("checking up");
				validated = checkPathRecursive(row-1, col);
					
			}
			
			// check square to left
			if (!validated && squareLeft != null && checkExitsTrue(square, squareLeft, 0)){
				System.out.println("checking left");
				validated = checkPathRecursive(row, col-1);
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
	
	public boolean checkExitsMatch(Card playerCard, Card boardCard, int exit) {
		
		int boardExit;
		if (exit > 1) {
			boardExit = exit - 2;
		}
		else boardExit = exit + 2;
		
		boolean exitsTrue = playerCard.getExits()[exit] && boardCard.getExits()[boardExit];
		boolean exitsFalse = !playerCard.getExits()[exit] && !boardCard.getExits()[boardExit];

		if (exitsTrue || exitsFalse) {
			return true;
		}
		else return false;
		
	}
	
	public boolean checkExitsTrue(Card playerCard, Card boardCard, int exit) {
		
		int boardExit;
		if (exit > 1) {
			boardExit = exit - 2;
		}
		else boardExit = exit + 2;
		
		boolean exitsTrue = playerCard.getExits()[exit] && boardCard.getExits()[boardExit];

		if (exitsTrue) {
			return true;
		}
		else return false;
		
	}
	
	public boolean checkMinersWin(int row, int col) {
			
		Card playedSquare = Board.getInstance().getCard(row, col);
		
		Card squareUp = null;
		Card squareDown = null;
		Card squareLeft = null;
		Card squareRight = null;
		if(row > 0)
			squareUp = Board.getInstance().getCard((row - 1), col);
		if(row < Board.getInstance().getRows()-1)
			squareDown = Board.getInstance().getCard((row + 1), col);
		if(col < Board.getInstance().getCols()-1)
			squareRight = Board.getInstance().getCard(row, (col + 1));
		if(col > 0)
			squareLeft = Board.getInstance().getCard(row, (col - 1));
		
		//check if the played square leads to gold on the right
		if (squareRight != null) { 
			if (squareRight.getName() == "gold" && checkExitsTrue(playedSquare, squareRight, 2)) {
				
				return true;
				
			}
			
		}
		
		//check if square to the left is gold
		if (squareLeft != null) { 
			
			if (squareLeft.getName() == "gold" && checkExitsTrue(playedSquare, squareLeft, 0)) {
				
				return true;
				
			}
			
		}
		
		//check if square to the top is gold
		if (squareUp != null) { 
						
			if (squareUp.getName() == "gold" && checkExitsTrue(playedSquare, squareUp, 1)) {
				
				return true;
				
			}
			
		}
		
		//check if square to the bottom is gold
		if (squareDown != null) { 
			
			if (squareDown.getName() == "gold" && checkExitsTrue(playedSquare, squareDown, 3)) {
				
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
