package view;

import controller.GameEngineD;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {
	
	public static int SCENE_WIDTH = 860;
	public static int SCENE_HEIGHT = 600;
	
	public static GameEngineD gameEngine;

	public void launchApp(GameEngineD gameEngine) {
		
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

