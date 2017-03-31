package controller;

import javafx.stage.Stage;
import model.Board;
import model.PlayerInformation;
import view.GameView;
import model.totalPlayers;

public class PlayGameListener {
	
	public void changeScene(String[] pName, Stage stage) {
		
		GameView gameView = new GameView(stage);
		gameView.displayView(PlayerInformation.getInstance().playerCount(), pName);
	}

	// Incomplete. The current players name
	public String PlayerName(int i) {
		String playerName = null;
		PlayerInformation.getInstance().getPlayerByName("John");

		return playerName;
	}

	public int[][] getCurrentBoard() {
		return Board.getInstance().currentBoard();
	}

}
