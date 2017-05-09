package controller;

import java.util.Random;

import model.Board;
import model.cards.StartCard;

public class BoardBuilder {
	
	public void initBoard() {
		
		Board.getInstance().initBoard();
		
	}
	
	public void setTreasureSites(int[] rows, int[] columns) {
		
		new Treasure().setTreasure();
		
	}
	
	public void setTreasureSites(int numTreasures) {
		
		Random rand = new Random();
		
		int[] randRows = new int[numTreasures];
		int[] randCols = new int[numTreasures];
		for (int i = 0; i < numTreasures; i++) {
			
			int randRow = rand.nextInt((6 - 0) + 1) + 0;
			int randCol = rand.nextInt((6 - 0) + 1) + 0;
			System.out.println(randRow + ", " + randCol);
			randRows[i] = randRow;
			randCols[i] = randCol;
			
		}
		new Treasure().setTreasure(randRows, randCols);
		
	}
	
	public void setStart() {
		
		Board.getInstance().playCard(6, 3, new StartCard());
		
	}

}
