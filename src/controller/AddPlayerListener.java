package controller;

import javafx.stage.Stage;
import model.*;
import view.AddPlayerView;
import model.Player;

import java.util.ArrayList;

public class AddPlayerListener {

	public void createPlayer(String[] players) {
		PlayerInformation.getInstance().createPlayers(players);


	}
	
	public void changeScene(int numPlayers, Stage stage) {
		
		AddPlayerView addPlayerView = new AddPlayerView(stage);
		addPlayerView.displayView(numPlayers);
	}

}
