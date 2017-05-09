package controller;

import model.Board;
import model.Deck;
import model.Player;
import view.MainView;
import model.cards.*;
public class GameEngine {

	private MainView mainView;
	private Board board;
	private static PlayerController players;
	private static int currentPlayerIndex;
	private Treasure treasure = new Treasure();

	//run game
	public static void main(String[] args) {

		new GameEngine();

	}

	public GameEngine() {

		//setup board, players, deck and view
		StartCard card = new StartCard();
		int column = 3;
		int row = 6;

		BoardBuilder boardBuilder = new BoardBuilder();
		boardBuilder.initBoard();
		boardBuilder.setStart();
		boardBuilder.setTreasureSites(5);

		players = PlayerController.getInstance();
		currentPlayerIndex = 0;
		mainView = new MainView();
		mainView.launchApp(this);

	}



	public int getCurrentPlayerIndex() {

		return currentPlayerIndex;

	}


	//set the next player's turn
	public Player nextPlayer() {

		if (currentPlayerIndex == players.getPlayerList().size()-1) {

			currentPlayerIndex = 0;

		}

		else currentPlayerIndex++;

		return getCurrentPlayer();

	}

	public Player getCurrentPlayer() {

		return players.getPlayerByPosition(currentPlayerIndex);

	}
	public Player getPrevPlay() {

		return players.getPlayerByPosition(currentPlayerIndex);

	}
	
	public static Player getNextPlayer() {

		if (currentPlayerIndex == players.getPlayerList().size()-1) {

			return players.getPlayerByPosition(0);

		}

		else return players.getPlayerByPosition(currentPlayerIndex+1);

	}


}

