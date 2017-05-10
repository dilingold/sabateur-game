package controller;

import javafx.stage.Stage;
import model.Board;
import model.Player;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {
		
		for(Player player : PlayerController.getInstance().getPlayerList()) {
			
			System.out.println(player.getName() + ": " + player.getGold());
			
		}
		
		BoardBuilder boardBuilder = new BoardBuilder();
		boardBuilder.getRows();
		boardBuilder.getCols();
		boardBuilder.initBoard();
		boardBuilder.setTreasureSites(3);
		boardBuilder.setStart();
		
		DeckBuilder deckBuilder = new DeckBuilder();
		deckBuilder.clearDeck();
		deckBuilder.addEndPathCards(3);
		deckBuilder.addLPathCards(3);
		deckBuilder.addStraighPathCards(3);
		deckBuilder.addTPathCards(6);
		deckBuilder.addXPathCards(3);
		deckBuilder.Shuffle();
		
		PlayerController.getInstance().distributeGold();
		
		PlayerController.getInstance().clearPlayerHands();
		PlayerController.getInstance().dealPlayerHands();
		
		GameEngine.setCurrentPlayerIndex(0);
		
		new PlayGameListener().changeScene(stage);
		
	}

}
