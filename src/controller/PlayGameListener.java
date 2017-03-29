package controller;

import javafx.stage.Stage;
import model.PlayerInformation;
import view.GameView;
import model.totalPlayers;

public class PlayGameListener {
	
	public void changeScene(String[] pName, Stage stage) {
		
		GameView gameView = new GameView(stage);
		gameView.displayView(PlayerInformation.getInstance().playerCount(), pName);
	}

	public String PlayerName(int i) {
		String playerName = null;
		PlayerInformation.getInstance().getPlayerByName("John");

		return playerName;
	}

}
