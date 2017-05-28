package view;

import controller.GameEngine;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {
	
	public static int SCENE_WIDTH = 1200;
	public static int SCENE_HEIGHT = 600;
	
	public static GameEngine gameEngine;

	public void launchApp(GameEngine gameEngine) {
		
		MainView.gameEngine = gameEngine;
		launch();

	}
	
	@Override
	public void start(Stage stage) {
		
		//display the welcome view at the start of the game
		WelcomeView welcomeView = new WelcomeView(stage);
		welcomeView.displayView();
		
		stage.show();

	}

}

