package controller;

import javafx.stage.Stage;
import model.Board;
import model.Player;
import model.PlayerInformation;
import view.GameView;
import model.totalPlayers;

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
			PlayerInformation.getInstance().getPlayerByName(PlayerName(position)).setIsTurn(true);
			PlayerInformation.getInstance().getPlayerByName(PlayerName(position-1)).setIsTurn(false);
			return PlayerName(position);
		}
		else {
			position = 0;
			PlayerInformation.getInstance().getPlayerByName(PlayerName(position)).setIsTurn(true);
			PlayerInformation.getInstance().getPlayerByName(PlayerName(PlayerInformation.getInstance().playerCount()-1)).setIsTurn(false);
			return PlayerName(position);
		}
	}

	public String getTurn() {
		return PlayerInformation.getInstance().checkTurn();
	}

}
