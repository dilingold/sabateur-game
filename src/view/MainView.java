package view;

import controller.GameEngine;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {
	
	public static int SCENE_WIDTH = 860;
	public static int SCENE_HEIGHT = 600;
	
	public static GameEngine gameEngine;

	public void launchApp(GameEngine gameEngine) {
		
		this.gameEngine = gameEngine;
		launch();

	}
	
	@Override
	public void start(Stage stage) {
		
		WelcomeView welcomeView = new WelcomeView(stage);
		welcomeView.displayView();
		
		stage.show();

	}

}

