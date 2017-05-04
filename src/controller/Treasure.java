package controller;

import model.Board;
import model.cards.Card;
import model.cards.CardInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.cards.GoldCard;
import model.cards.StoneCard;


public class Treasure{

    private Board board;
    //standard treasure positions
    private int ROW_POSITION = 0;
    private int TREASURE_COL_POS_1 = 1;
    private int TREASURE_COL_POS_2 = 3;
    private int TREASURE_COL_POS_3 = 5;

    CardInterface gold = new GoldCard();
    CardInterface stoneOne = new StoneCard();
    CardInterface stoneTwo = new StoneCard();

    private List<CardInterface> treasure = new ArrayList<>();

    private List<Integer> coordinates = new ArrayList<>();

    public void setTreasure(){

        board = Board.getInstance();

        int[] boardCoordinates = {TREASURE_COL_POS_1, TREASURE_COL_POS_2,
                TREASURE_COL_POS_3};

        treasure.add(gold);
        treasure.add(stoneOne);
        treasure.add(stoneTwo);

        for(int i: boardCoordinates)
            coordinates.add(i);

        Collections.shuffle(treasure);
        Collections.shuffle(coordinates);

        for (int i = 0; i < 3; i++){

            board.playCard(ROW_POSITION, coordinates.get(i), treasure.get(i));
        }
    }


}
