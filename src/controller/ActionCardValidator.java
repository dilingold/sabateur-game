package controller;

import model.Board;
import model.cards.Card;

public class ActionCardValidator {

	public boolean checkMove(Card cardType, int row, int column) {

		Boolean validated = false;

		if (cardType.getType() == "path") {

			validated = validatePath(cardType, row, column);
			return validated;

		}

		if (cardType.getType() == "action") {

			validated = validateAction(cardType, row, column);

		}

		if (validated == true) {

			// tell board to play card in location
			Board.getInstance().setGameBoard(row, column, cardType);
		}

		return validated;

	}

	// Code for Assignment 2
	/**
	 * Validate path element
	 * 
	 * @pre.condition 0 <= row < board.numCols
	 * @pre.condition 0 <= column < board.numRows
	 * @post.condition $return != null
	 */
	private Boolean validatePath(Card cardType, int row, int column) {
		assert 0 < row;
		assert row < Board.getInstance().getRows();
		assert 0 <= column;
		assert column < Board.getInstance().getCols();

		Boolean validated = false;
		if (cardType.getType() == "path") {
			
		/*
		 * NOT CURRENTLY WORKING
		 * For implementation in Assignment 2.
		 * 
		 */
/*			if (Board.getInstance().getGameBoard(row, column).getType() == "action") {
				validated = false;
			}

			else if (Board.getInstance().getGameBoard(row, column).getType() == "blank") {
				// check if any adjacent tiles are path cards
				// first check if there's a tile down
				if (Board.getInstance().getGameBoard((row - 1), column) != null)
					// check if this tile has exit UP
					if (Board.getInstance().getGameBoard((row - 1), column).getExits()[1])
						;
				validated = true;
				// then left
				if (Board.getInstance().getGameBoard((row), column - 1) != null)
					// check if this tile has exit RIGHT
					if (Board.getInstance().getGameBoard((row), column - 1).getExits()[2])
						;
				validated = true;
				// right
				if (Board.getInstance().getGameBoard((row), column + 1) != null)
					// check if this tile has exit LEFT
					if (Board.getInstance().getGameBoard((row), column + 1).getExits()[0])
						;
				validated = true;
				// up
				if (Board.getInstance().getGameBoard((row + 1), column) != null)
					// check if this tile has exit DOWN
					if (Board.getInstance().getGameBoard((row + 1), column).getExits()[3])
						;
				validated = true;

			}*/
			validated = true;
		}

		return validated;

	}

	private Boolean validateAction(Card cardType, int row, int column) {

		Boolean validated = false;

		// get action card type
		String type = cardType.getName();

		switch (type) {

		case "curse":
			if (Board.getInstance().getGameBoard(row, column).getType() == "path") {

				validated = true;

			}
			break;

		case "bomb":
			// check if location is not empty
			if (Board.getInstance().getGameBoard(row, column).getType() == "path") {

				validated = true;

			}
			break;

		case "Toxic Card":
			// needs code for assignment 2
			if (Board.getInstance().getGameBoard(row, column).getType() == "path") {

				validated = true;

			}
			break;

		}

		return validated;

	}

}
