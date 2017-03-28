package model;
import model.Treasure;
/**
 * Created by johnny on 3/27/17.
 */
public class Board{

    private char[][] gameBoard;
    private int numCols = 7;
    private int numRows = 7;
    //Constructor for the game board
    public Board(){

        this.gameBoard = new char[numCols][numRows];

    }
    //Initializes the game board
    public void initBoard() {
        for (int cols=0; cols<numCols; cols++) {
            for (int rows=0; rows<numRows; rows++) {
                this.gameBoard[cols][rows] = 'X';
                System.out.print(gameBoard[cols][rows]);
            }
            System.out.println("");
        }
            this.gameBoard[0][1] = 'G';
            this.gameBoard[0][3] = 'C';
            this.gameBoard[0][5] = 'C';
    }

    //Getters
    public char[][] getGameBoard() {
        return gameBoard;
    }
    //Setters
    public void setGameBoard(int column, int row, char cardType) {
        this.gameBoard[column][row] = cardType;
    }
    //Prints updated board
    public void printBoard(){
        System.out.println("Updated Board");
        for (int cols=0; cols<numCols; cols++) {
            for (int rows=0; rows<numRows; rows++) {

                System.out.print(gameBoard[cols][rows]);
            }
            System.out.println("");
        }

    }


}

