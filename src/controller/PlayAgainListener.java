package controller;

import javafx.stage.Stage;
import model.Player;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {

		RestartGame restartGame = new RestartGame();

		restartGame.restartBoard();
		restartGame.restartDeck();
		restartGame.restartPlayer();


		
		new PlayGameListener().changeScene(stage);
		
	}

}
