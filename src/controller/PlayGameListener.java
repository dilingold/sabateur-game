package controller;

import javafx.stage.Stage;
import view.GameView;

//listens for when the user selects the play game button from the AddPlayerView
//displays the GameView
public class PlayGameListener {
	static GameView gameView;
	public static void changeScene(Stage stage) {
		
		PlayerController players = PlayerController.getInstance();
		gameView = new GameView(stage);
		gameView.displayView(players.playerCount(), players.getPlayerList());
		
	}
	public static GameView getGameView(){
		return gameView;
	}

}
