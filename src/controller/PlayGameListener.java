package controller;

import javafx.stage.Stage;
import view.GameView;

//listens for when the user selects the play game button from the AddPlayerView
//displays the GameView
public class PlayGameListener {
	
	public static void changeScene(Stage stage) {
		
		PlayerController players = PlayerController.getInstance();
		GameView gameView = new GameView(stage);
		gameView.displayView(players.playerCount(), players.getPlayerList());
		
	}

}
