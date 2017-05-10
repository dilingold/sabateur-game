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

		DeckBuilder deckBuilder = new DeckBuilder();
		deckBuilder.addEndPathCards(3);
		deckBuilder.addLPathCards(6);
		deckBuilder.addStraighPathCards(3);
		deckBuilder.addTPathCards(3);
		deckBuilder.addXPathCards(3);
		deckBuilder.Shuffle();

		players = PlayerController.getInstance();
		currentPlayerIndex = 0;
		mainView = new MainView();
		mainView.launchApp(this);

	}



	public int getCurrentPlayerIndex() {

		return currentPlayerIndex;

	}
	
	public static void setCurrentPlayerIndex(int index) {
		
		currentPlayerIndex = index;
		
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

