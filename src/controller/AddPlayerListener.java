package controller;

import javafx.stage.Stage;
import view.AddPlayerView;
import model.totalPlayers;

public class AddPlayerListener {

	public void playerCount(int numPlayers, Stage stage) {
		totalPlayers totalPlayers = new totalPlayers(numPlayers);
		totalPlayers.setNumPlayers(numPlayers);
		System.out.println(totalPlayers.getNumPlayers());
		changeScene(totalPlayers.getNumPlayers(), stage);
	}
	
	public void changeScene(int numPlayers, Stage stage) {
		
		AddPlayerView addPlayerView = new AddPlayerView(stage);
		addPlayerView.displayView(numPlayers);
		
	}

}
