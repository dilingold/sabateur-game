package controller;

import javafx.stage.Stage;
import view.AddPlayerView;
import view.PlayerCountView;

public class PlayerCountListener {
	
	public void changeScene(Stage stage) {
		
		PlayerCountView playerCountView = new PlayerCountView(stage);
		playerCountView.displayView();
		
	}

}
