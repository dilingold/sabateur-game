package controller;

import javafx.stage.Stage;
import model.Player;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {
		
		for(Player player : PlayerController.getInstance().getPlayerList()) {
			
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
		boardBuilder.setTreasureSites(3);
		boardBuilder.setStart();
		
	}
	
	public void resetDeck() {

		DeckBuilder deckBuilder = new DeckBuilder();
		deckBuilder.clearDeck();
		deckBuilder.addEndPathCards();
		deckBuilder.addLPathCards();
		deckBuilder.addStraighPathCards();
		deckBuilder.addTPathCards();
		deckBuilder.addXPathCards();
		deckBuilder.Shuffle();
		
	}
	
	public void resetPlayers() {
		
		PlayerController.getInstance().clearPlayerHands();
		PlayerController.getInstance().dealPlayerHands();
		PlayerController.getInstance().setPlayerRoles();
		GameEngine.setCurrentPlayerIndex(0);
	}

}
