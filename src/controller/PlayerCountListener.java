package controller;

import javafx.stage.Stage;
import view.PlayerCountView;

//listens for when the user selects the start game button from the welcome page
//displays the PlayerCountView for the user to select how many players
public class PlayerCountListener {
	
	public void changeScene(Stage stage) {
		
		PlayerCountView playerCountView = new PlayerCountView(stage);
		playerCountView.displayView();
		
	}

}
