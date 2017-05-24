package controller;

import javafx.stage.Stage;
import model.Board;
import model.Player;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {
		
		for(Player player : PlayerController.getInstance().getPlayerList()) {
			
			System.out.println(player.getName() + ": " + player.getGold());
			
		}
		
		/*
		Command Pattern
		 */
		Restart restart = new Restart();
		BoardBuilder boardBuilder = new BoardBuilder();
		DeckFactory deckBuilder = new DeckFactory();

		Command resetGame = new ResetGameCommand(boardBuilder, deckBuilder);

		restart.setCommand(resetGame);
		restart.invokeReset();
		
		new PlayGameListener().changeScene(stage);
		
	}
	
	/*public void resetBoard() {
		
		BoardBuilder boardBuilder = new BoardBuilder();
		boardBuilder.getRows();
		boardBuilder.getCols();
		boardBuilder.initBoard();
		boardBuilder.setTreasureSites();
		boardBuilder.setStart();
		
	}
	
	public void resetDeck() {

		DeckFactory deck = new DeckFactory();
		deck.addAllCards();
		deck.Shuffle();
		
	}
	
	public void resetPlayers() {
		
		PlayerController.getInstance().clearPlayerHands();
		PlayerController.getInstance().dealPlayerHands();
		GameEngine.setCurrentPlayerIndex(0);
	}*/

}
