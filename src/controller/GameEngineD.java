package controller;

import model.Board;
import model.Deck;
import model.Player;
import view.MainView;

public class GameEngineD {
	
	private MainView mainView;
	private Board board;
	private PlayerInformation players;
	private Deck deck;
	private int currentPlayerIndex;
	
	public static void main(String[] args) {
		
		new GameEngineD();

	}
	
	public GameEngineD() {
		
		//setup board
		board = Board.getInstance();
		board.initBoard();
		board.setGameBoard(6, 3, 5);
		
		players = PlayerInformation.getInstance();
		deck = Deck.getInstance();
		currentPlayerIndex = 0;
		mainView = new MainView();
		mainView.launchApp(this);
		
	}
	
	public Board getBoard() {
		
		return board;
		
	}
	
	public PlayerInformation getPlayers() {
		
		return players;
		
	}
	
	public Deck getDeck() {
		
		return deck;
		
	}
	
	public int getCurrentPlayerIndex() {
		
		return currentPlayerIndex;
		
	}
	
	public void setCurrentPlayerIndex(int playerIndex) {
		
		currentPlayerIndex = playerIndex;
		
	}
	
	public Player getCurrentPlayer() {
		
		return players.getPlayerByPosition(currentPlayerIndex);
		
	}

}

