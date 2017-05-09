package controller;

import javafx.stage.Stage;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {
		
		BoardBuilder boardBuilder = new BoardBuilder();
		boardBuilder.initBoard();
		boardBuilder.setTreasureSites(5);
		boardBuilder.setStart();
		
		DeckBuilder deckBuilder = new DeckBuilder();
		deckBuilder.clearDeck();
		deckBuilder.addEndPathCards(3);
		deckBuilder.addLPathCards(3);
		deckBuilder.addStraighPathCards(3);
		deckBuilder.addTPathCards(3);
		deckBuilder.addXPathCards(3);
		deckBuilder.Shuffle();
		
		PlayerController.getInstance().clearPlayerHands();
		PlayerController.getInstance().dealPlayerHands();
		
		new PlayGameListener().changeScene(stage);
		
	}

}
