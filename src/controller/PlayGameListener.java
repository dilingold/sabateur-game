package controller;

import javafx.stage.Stage;
import view.GameView;
import model.totalPlayers;

public class PlayGameListener {
	
	public void changeScene(int totalPlayers, String[] pName, Stage stage) {
		
		GameView gameView = new GameView(stage);
		gameView.displayView(totalPlayers, pName);
	}

}
