package controller;

import model.Board;
import model.cards.StartCard;

public class BoardBuilder implements Reset{
	
	private int maxRow;
	private int maxCol;

	public void reset() {
		getRows();
		getCols();
		initBoard();
		setTreasureSites();
		setStart();
	}
	
	public void setRows(int rows) {
		
		Board.getInstance().setRows(rows);
		maxRow = rows-1;
		
	}
	
	public void getRows() {
		
		maxRow = Board.getInstance().getRows() - 1;
		
	}
	
	public void setCols(int cols) {
		
		Board.getInstance().setCols(cols);
		maxCol = cols-1;
		
	}
	
	public void getCols() {
		
		maxCol = Board.getInstance().getCols() - 1;
		
	}
	
	public void initBoard() {
		
		Board.getInstance().initBoard();
		
	}
	
	public void setTreasureSites(int[] rows, int[] cols) {
		
		Board.getInstance().setTreasure(rows, cols);
		
	}
	
	public void setTreasureSites() {
		
		Board.getInstance().setTreasure(Board.getInstance().getTreasureRows(), Board.getInstance().getTreasureCols());
		
	}
	
	public void setStart() {
		
		Board.getInstance().playCard(maxRow, maxCol/2, new StartCard());
		
	}

}
