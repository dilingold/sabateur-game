package view;

import controller.PlayerCountListener;
import controller.ExitListener;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WelcomeView {

	Stage stage;

	public WelcomeView(Stage stage) {

		this.stage = stage;
	}

	public void displayView() {

		BorderPane root = new BorderPane();
		GridPane inner = new GridPane();
		inner.setAlignment(Pos.CENTER_LEFT);
		inner.setHgap(10);
		inner.setVgap(10);
		inner.setPadding(new Insets(25, 25, 25, 85));
		inner.setPrefSize(860, 600);

		stage.setTitle("G2 Sabateur");

		createContent.Title title = new createContent.Title("S A B A T E U R");

		createContent.MenuItem startGame = new createContent.MenuItem("START GAME");

		createContent.MenuItem itemExit = new createContent.MenuItem("EXIT");

		createContent.MenuBox vbox = new createContent.MenuBox(
				startGame,
				new createContent.MenuItem("LOAD GAME"),
				new createContent.MenuItem("LEADERBOARD"),
				itemExit	
		);

		final Menu menu1 = new Menu("File");
		final Menu menu2 = new Menu("Options");
		final Menu menu3 = new Menu("Help");

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2, menu3);

		inner.add(title, 0, 0, 1, 1);
		inner.add(vbox,0, 2);
		root.setTop(menuBar);
		root.setCenter(inner);
		//display the player count view when the user chooses to start a new game
		//the player count view will allow the user to select how many players will be playing
		startGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				new BoardOptionsView(stage).displayView();
				
			}
			
		});

		itemExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				ExitListener exitListener = new ExitListener();
				exitListener.closeWindow(stage);
				
			}
			
		});

		Scene scene = new Scene(root, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);
		stage.setScene(scene);
		scene.getStylesheets().add(MainView.class.getResource("style.css").toExternalForm());

	}

}