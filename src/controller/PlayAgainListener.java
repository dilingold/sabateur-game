package controller;

import javafx.stage.Stage;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {
		
		BoardBuilder boardBuilder = new BoardBuilder();
		boardBuilder.initBoard();
		boardBuilder.setStart();
		boardBuilder.setTreasureSites(5);
		
		new PlayGameListener().changeScene(stage);
		
	}

}
