package controller;

import javafx.stage.Stage;
import view.GameView;

public class PlayGameListener {
	
	public void changeScene(Stage stage) {
		
		GameView gameView = new GameView(stage);
		gameView.displayView();
		
	}

}
