package model;

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
    private int numCols = 7;
    private int numRows = 7;

    private Board() {

        this.gameBoard = new Card[numRows][numCols];

    }

    //Initializes the game board
    public void initBoard() {
    	
        for (int rows=0; rows < numRows; rows++) {
        	
            for (int cols=0; cols < numCols; cols++) {
            	
            	EmptyCard card = new EmptyCard();
            	
                this.gameBoard[rows][cols] = card;
                
            }
            
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
    	assert 0 < row;
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

}
