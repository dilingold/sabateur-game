package controller;

import java.util.Random;

import model.Board;
import model.cards.StartCard;

public class BoardBuilder {
	
	private int maxRow;
	private int maxCol;
	
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
	
	public void setTreasureSites(int numTreasures) {
		
		Random rand = new Random();
		
		int[] randRows = new int[numTreasures];
		int[] randCols = new int[numTreasures];
		for (int i = 0; i < numTreasures; i++) {
			
			int randRow = rand.nextInt((maxRow-1 - 0) + 1) + 0;
			int randCol = rand.nextInt((maxCol-1 - 0) + 1) + 0;
			
			randRows[i] = randRow;
			randCols[i] = randCol;
			
		}
		Board.getInstance().setTreasure(randRows, randCols);
		
	}
	
	public void setStart() {
		
		Board.getInstance().playCard(maxRow, maxCol/2, new StartCard());
		
	}

}
