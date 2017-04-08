package model;
//import com.sun.java.util.jar.pack.Instruction;

import model.cards.*;

/**
 * Created by johnny on 3/29/17.
 */

public class Board extends Treasure {
    private static Board ourInstance = new Board();

    public static Board getInstance() {
        return ourInstance;
    }

    private Card[][] gameBoard;
    EmptyCard card = new EmptyCard();
    private int numCols = 7;
    private int numRows = 7;

    //Constructor for the game board

    private Board() {

        this.gameBoard = new Card[numRows][numCols];

    }

    //Initializes the game board
    public void initBoard() {
        for (int rows=0; rows < numRows; rows++) {
            for (int cols=0; cols < numCols; cols++) {
                this.gameBoard[rows][cols] = card;
            }
        }
    }

    //Getters
    public Card getGameBoard(int row, int column) {
        return gameBoard[row][column];
    }
    //Setters
    public void setGameBoard(int row, int column, Card cardType) {
        gameBoard[row][column] = cardType;
    }

    public Card[][] currentBoard(){
        return this.gameBoard;
    }

    public void printBoard() {
        System.out.println("UPDATED BOARD");
        for(int i = 0; i < numRows; i++) {
            for(int k = 0; k < numCols; k++){
                System.out.println(this.gameBoard[i][k]);
            }
        }
    }

}
