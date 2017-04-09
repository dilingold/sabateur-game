package controller;

import javafx.stage.Stage;
import view.AddPlayerView;

public class AddPlayerListener {
	
	/*
	 * called from the AddPlayerView class
	 * when the user selects the play game button, the player names are added to the players List 
	 * in the PlayerController
	 */
	public void createPlayers(String[] players) {
		
		PlayerController.getInstance().createPlayers(players);

	}
	
	/*
	 * displays the AddPlayerView for the user to input player names
	 */
	public void changeScene(int numPlayers, Stage stage) {
		
		AddPlayerView addPlayerView = new AddPlayerView(stage);
		addPlayerView.displayView(numPlayers);
		
	}

}
