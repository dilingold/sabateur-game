package controller;

import javafx.stage.Stage;
import model.Board;
import view.GameView;
import java.util.Collections;

public class PlayGameListener {
	
	public void changeScene(Stage stage) {
		
		PlayerController players = PlayerController.getInstance();
		GameView gameView = new GameView(stage);
		gameView.displayView(players.playerCount(), players.getPlayerList());
	}

	// Incomplete. The current players name
	public String PlayerName(int position) {
		
		return PlayerController.getInstance().getPlayerByPosition(position).getName();

	}

	public int[][] getCurrentBoard() {
		
		return Board.getInstance().currentBoard();
		
	}

	public String nextTurn(int position) {
		
		if(position < PlayerController.getInstance().playerCount()) {
			
			Collections.rotate(PlayerController.getInstance().getPlayerList(), -1);
			return PlayerName(position);
			
		}
		
		else {
			
			Collections.rotate(PlayerController.getInstance().getPlayerList(), -1);
			return PlayerName(position);
			
		}
		
	}

}
