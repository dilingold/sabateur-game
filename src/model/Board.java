package model;
//import com.sun.java.util.jar.pack.Instruction;
import model.Squares;
import model.Treasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * Created by johnny on 3/29/17.
 */
public class Board {
    private static Board ourInstance = new Board();

    public static Board getInstance() {
        return ourInstance;
    }

    private int[][] gameBoard;

    //Constructor for the game board

    private Board() {

        this.gameBoard = new int[Squares.NUM_COLS][Squares.NUM_ROWS];

    }

    //Initializes the game board
    public void initBoard() {
        for (int cols=0; cols < Squares.NUM_COLS; cols++) {
            for (int rows=0; rows<Squares.NUM_ROWS; rows++) {
                this.gameBoard[cols][rows] = Squares.EMPTY_SQUARE;
                System.out.print(gameBoard[cols][rows]);
            }
            System.out.println("");
        }
        setTreasure();
    }
    //Sets the treasure on the board
    public void setTreasure(){
        //should the two array be in treasure class?????
        // or should this methoud be in treasure class
        //tutor said it was fine!!!! but still dunno
        int[] treasureArr = {Treasure.GOLD, Treasure.COAL, Treasure.COAL};

        int[] boardCoordinates = {Treasure.TREASURE_COL_POS_1, Treasure.TREASURE_COL_POS_2,
                Treasure.TREASURE_COL_POS_3};

        List<Integer> treasure = new ArrayList<>();

        List<Integer> coordinates = new ArrayList<>();

        for(int i: treasureArr)
                treasure.add(i);

        for(int i: boardCoordinates)
                coordinates.add(i);

        Collections.shuffle(treasure);
        Collections.shuffle(coordinates);

        for (int i = 0; i < 3; i++){

            this.gameBoard[Treasure.ROW_POSITION][coordinates.get(i)] = treasure.get(i);
        }
    }

    //Getters
    public int getGameBoard(int row, int column) {
        return gameBoard[row][column];
    }
    //Setters
    public void setGameBoard(int column, int row, int cardType) {
        this.gameBoard[column][row] = cardType;
    }

    //Prints updated board
    public void printBoard(){
        System.out.println("Updated Board");
        for (int cols=0; cols<Squares.NUM_COLS; cols++) {
            for (int rows=0; rows<Squares.NUM_ROWS; rows++) {

                System.out.print(gameBoard[cols][rows]);
            }
            System.out.println("");
        }

    }

    public int[][] currentBoard(){
        return this.gameBoard;
    }
}
