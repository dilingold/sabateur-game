package view;

import controller.PlayerCountListener;
import controller.createContent;
import controller.AddPlayerListener;
import controller.ExitListener;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/** NOTE: Perhaps Instead of constantly changing stages have one stage for the menu navigation
 * have them all in the single stage and switch scenes. Changing stages will resize the window
 * regardless if they changed it previously. JavaFX has a section on scene switching instead of stage switching.
 */

public class WelcomeView {

	Stage stage;

	public WelcomeView(Stage stage) {

		this.stage = stage;

	}

	public void displayView() {
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 85));
		root.setPrefSize(860, 600);

		//root.setGridLinesVisible(true);

		stage.setTitle("G2 Sabateur");

		createContent.Title title = new createContent.Title("S A B A T E U R");

		createContent.MenuItem startGame = new createContent.MenuItem("START GAME");
		startGame.setOnMouseClicked(event -> {
			System.out.println();
		});

		createContent.MenuItem itemExit = new createContent.MenuItem("EXIT");

		createContent.MenuBox vbox = new createContent.MenuBox(
				startGame,
				new createContent.MenuItem("LOAD GAME"),
				new createContent.MenuItem("LEADERBOARD"),
				itemExit
		);

		root.add(title, 0, 0, 1, 1);
		root.add(vbox,0, 2);

		startGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				PlayerCountListener playerCountListener = new PlayerCountListener();
				playerCountListener.changeScene(stage);
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