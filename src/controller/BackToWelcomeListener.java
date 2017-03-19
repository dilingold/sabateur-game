package controller;

import javafx.stage.Stage;
import view.WelcomeView;

public class BackToWelcomeListener {
	
	public void backToWelcome(Stage stage) {
		
		WelcomeView welcomeView = new WelcomeView(stage);
		welcomeView.displayView();
		
	}

}
