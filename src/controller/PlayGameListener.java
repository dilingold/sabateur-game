package controller;

import javafx.stage.Stage;
import model.Board;
import model.Player;
import model.PlayerInformation;
import view.GameView;
import model.TotalPlayers;
import java.util.Collections;

public class PlayGameListener {
	
	public void changeScene(String[] pName, Stage stage) {
		
		GameView gameView = new GameView(stage);
		gameView.displayView(PlayerInformation.getInstance().playerCount(), pName);
	}

	// Incomplete. The current players name
	public String PlayerName(int position) {
		return PlayerInformation.getInstance().getPlayerByPosition(position);

	}

	public int[][] getCurrentBoard() {
		return Board.getInstance().currentBoard();
	}

	public String nextTurn(int position) {
		if(position < PlayerInformation.getInstance().playerCount()) {
			Collections.rotate(PlayerInformation.getInstance().getPlayerList(), -1);
			return PlayerName(position);
		}
		else {
			Collections.rotate(PlayerInformation.getInstance().getPlayerList(), -1);
			return PlayerName(position);
		}
	}

}
