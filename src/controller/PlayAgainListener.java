package controller;

import javafx.stage.Stage;
import model.Board;
import model.PlayerD;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {
		
		for(PlayerD player : PlayerController.getInstance().getPlayerList()) {
			
			System.out.println(player.getName() + ": " + player.getGold());
			
		}

		Resetter resetter = new Resetter();
		BoardBuilder boardBuilder = new BoardBuilder();
		DeckFactory deckBuilder = new DeckFactory();

		Command resetGame = new ResetBoardCommand(boardBuilder, deckBuilder);

		resetter.setCommand(resetGame);
		resetter.invokeReset();

		new PlayGameListener().changeScene(stage);
		
		//resetBoard();
		//resetDeck();
		//resetPlayers();
		

		
	}
	/*
	public void resetBoard() {
		
		BoardBuilder boardBuilder = new BoardBuilder();
		boardBuilder.getRows();
		boardBuilder.getCols();
		boardBuilder.initBoard();
		boardBuilder.setTreasureSites();
		boardBuilder.setStart();
		
	}
	
	public void resetDeck() {

		DeckFactory deckBuilder = new DeckFactory();
		deckBuilder.addAllCards();
		deckBuilder.Shuffle();
		
	}
	
	public void resetPlayers() {
		
		PlayerController.getInstance().clearPlayerHands();
		PlayerController.getInstance().dealPlayerHands();
		GameEngine.setCurrentPlayerIndex(0);
	}
*/
}
