package controller;

import javafx.stage.Stage;
import view.AddPlayerView;

public class AddPlayerListener {
	
	public void changeScene(Stage stage) {
		
		AddPlayerView addPlayerView = new AddPlayerView(stage);
		addPlayerView.displayView();
		
	}

}
