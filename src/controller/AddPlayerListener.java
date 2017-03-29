package controller;

import javafx.stage.Stage;
import model.*;
import view.AddPlayerView;
import model.Player;

import java.util.ArrayList;

public class AddPlayerListener {

	// Need to access totalPlayers when PlayGameListener is called. / Load Game.

	public int playerCount(int numPlayers, Stage stage) {
		totalPlayers totalPlayers = new totalPlayers(numPlayers);
		totalPlayers.setNumPlayers(numPlayers);
		System.out.println(totalPlayers.getNumPlayers());
		changeScene(totalPlayers.getNumPlayers(), stage);
		return totalPlayers.getNumPlayers();
		//return PlayerInformation.getInstance().playerCount();
	}

	public void createPlayer(String[] players) {
		PlayerInformation.getInstance().createPlayers(players);


	}
	
	public void changeScene(int numPlayers, Stage stage) {
		
		AddPlayerView addPlayerView = new AddPlayerView(stage);
		addPlayerView.displayView(numPlayers);
	}

}
