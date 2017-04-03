package controller;

import javafx.stage.Stage;
import view.AddPlayerView;


public class AddPlayerListener {

	public void createPlayers(String[] players) {
		
		PlayerInformation.getInstance().createPlayers(players);

	}
	
	public void changeScene(int numPlayers, Stage stage) {
		
		AddPlayerView addPlayerView = new AddPlayerView(stage);
		addPlayerView.displayView(numPlayers);
		
	}

}
