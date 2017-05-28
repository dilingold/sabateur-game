package controller;

import javafx.stage.Stage;
import model.Player;

public class PlayAgainListener {
	
	public void playAgain(Stage stage) {
		
		for(Player player : PlayerController.getInstance().getPlayerList()) {
			
			System.out.println(player.getName() + ": " + player.getGold());
			
		}

		RestartGame restartGame = new RestartGame();

		restartGame.restartBoard();
		restartGame.restartDeck();
		restartGame.restartPlayer();


		
		new PlayGameListener().changeScene(stage);
		
	}

}
