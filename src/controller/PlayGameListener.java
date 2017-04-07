package controller;

import javafx.stage.Stage;
import view.GameView;

public class PlayGameListener {
	
	public void changeScene(Stage stage) {
		
		PlayerController players = PlayerController.getInstance();
		GameView gameView = new GameView(stage);
		gameView.displayView(players.playerCount(), players.getPlayerList());
		
	}

}
