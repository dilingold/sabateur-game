package controller;

import javafx.stage.Stage;
import model.Board;
import view.GameView;
import java.util.Collections;

public class PlayGameListener {
	
	public void changeScene(Stage stage) {
		
		PlayerInformation players = PlayerInformation.getInstance();
		GameView gameView = new GameView(stage);
		gameView.displayView(players.playerCount(), players.getPlayerList());
	}

	// Incomplete. The current players name
	public String PlayerName(int position) {
		return PlayerInformation.getInstance().getPlayerByPosition(position).getName();

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
