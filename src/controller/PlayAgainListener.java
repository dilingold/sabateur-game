package controller;

import javafx.stage.Stage;
import model.Board;
import model.PlayerD;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {
		
		for(PlayerD player : PlayerController.getInstance().getPlayerList()) {
			
			System.out.println(player.getName() + ": " + player.getGold());
			
		}
		
		resetBoard();
		resetDeck();
		resetPlayers();
		
		new PlayGameListener().changeScene(stage);
		
	}
	
	public void resetBoard() {
		
		BoardBuilder boardBuilder = new BoardBuilder();
		boardBuilder.getRows();
		boardBuilder.getCols();
		boardBuilder.initBoard();
		boardBuilder.setTreasureSites();
		boardBuilder.setStart();
		
	}
	
	public void resetDeck() {

		DeckBuilder deckBuilder = new DeckBuilder();
		deckBuilder.addAllCards();
		deckBuilder.Shuffle();
		
	}
	
	public void resetPlayers() {
		
		PlayerController.getInstance().clearPlayerHands();
		PlayerController.getInstance().dealPlayerHands();
		GameEngine.setCurrentPlayerIndex(0);
	}

}
