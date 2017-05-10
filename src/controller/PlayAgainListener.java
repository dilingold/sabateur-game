package controller;

import javafx.stage.Stage;
import model.Board;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {
		
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
