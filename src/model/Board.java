package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.cards.*;

/**
 * Created by johnny on 3/29/17.
 */

public class Board {
	
    private static Board ourInstance = new Board();

    public static Board getInstance() {
    	
        return ourInstance;
        
    }
    
    private Card[][] gameBoard;
    private int numCols;
    private int numRows;
    private int[] treasureRows;
    private int[] treasureCols;

    private Board() {

        

    }

    //Initializes the game board
    public void initBoard() {
    	
    	this.gameBoard = new Card[numRows][numCols];
    	
        for (int rows=0; rows < numRows; rows++) {
        	
            for (int cols=0; cols < numCols; cols++) {
            	
            	EmptyCard card = new EmptyCard();
            	
                this.gameBoard[rows][cols] = card;
                
            }
            
        }
        
    }
    
    public void setTreasure(int[] rows, int[] cols) {
    	
    	List<Card> treasure = new ArrayList<Card>();
    	treasure.add(new GoldCard());
    	
    	for (int i = 1; i < rows.length; i++) {
    		
    		treasure.add(new StoneCard());
    		
    	}
    	
    	Collections.shuffle(treasure);
    	
    	int i = 0;
    	for (int row : rows) {
    		
    		Board.getInstance().playCard(row, cols[i], treasure.get(i));
    		i++;
    		
    	}
    	
    }

    public Card getCard(int row, int column) {
    	
        return gameBoard[row][column];
        
    }
    
	/**
	 * Place card in location on board
	 * 
	 * @pre.condition 0 <= row < board.numCols
	 * @pre.condition 0 <= column < board.numRows
	 * 
	 */
    public void playCard(int row, int column, Card cardType) {
    	assert 0 <= row;
		assert row < Board.getInstance().getRows();
		assert 0 <= column;
		assert column < Board.getInstance().getCols();
		
        gameBoard[row][column] = cardType;
        
    }

    public Card[][] currentBoard() {
    	
        return this.gameBoard;
        
    }

    public void printBoard() {
    	
        System.out.println("UPDATED BOARD");
        
        for(int i = 0; i < numRows; i++) {
        	
            for(int k = 0; k < numCols; k++) {
            	
                System.out.println(this.gameBoard[i][k]);
                
            }
            
        }
        
    }
    
    public int getRows(){
    	return numRows;
    }
    public int getCols(){
    	return numCols;
    }
    
    public void setRows(int rows){
    	this.numRows = rows;
    }
    public void setCols(int cols){
    	this.numCols = cols;
    }
    public void setTreasureRows(int[] treasureRows) {
    	this.treasureRows = treasureRows;
    }
    public void setTreasureCols(int[] treasureCols) {
    	this.treasureCols = treasureCols;
    }
    public int[] getTreasureRows() {
    	return treasureRows;
    }
    public int[] getTreasureCols() {
    	return treasureCols;
    }

    public static void setBoard(Board oldBoard) {
        ourInstance = oldBoard;
    }

}
