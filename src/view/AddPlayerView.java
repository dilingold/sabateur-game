package view;

import controller.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddPlayerView {

	private Stage stage;

	public AddPlayerView(Stage stage) {

		this.stage = stage;

	}

	public void displayView(int totalPlayers) {

		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 85));
		root.setPrefSize(860, 600);

		stage.setTitle("G2 Sabateur");

		createContent.Title title = new createContent.Title("S A B A T E U R");

		createContent.subTitle subTitle = new createContent.subTitle("Player Names");
		root.add(title, 0, 0, 2, 1);
		root.add(subTitle, 0, 1, 2, 1);

		ArrayList<TextField> nameList = new ArrayList<TextField>();
		String[] playerNames = new String[totalPlayers];
		int rowIndex = 1;
		for (int i = 0; i < totalPlayers; i++) {

			Label name = new Label(i+1 + ". Player Name");
			root.add(name, 0, rowIndex+1);

			TextField nameTextField = new TextField();
			nameList.add(nameTextField);
			root.add(nameTextField, 1, rowIndex+1);
			rowIndex++;
			
		}

		createContent.MenuItem playBtn = new createContent.MenuItem("PLAY");

		createContent.MenuItem backBtn = new createContent.MenuItem("BACK");

		playBtn.setOnMouseClicked(event ->  {

			PlayGameListener playGameListener = new PlayGameListener();
			
			int i = 0;
			for (TextField field : nameList) {
				
				playerNames[i] = field.getText();
				i++;
				
			}
			
			AddPlayerListener addPlayerListener = new AddPlayerListener();
			addPlayerListener.createPlayers(playerNames);

			playGameListener.changeScene(playerNames, stage);

		});

		backBtn.setOnMouseClicked(event ->  {

			PlayerCountListener playerCountListener = new PlayerCountListener();
			playerCountListener.changeScene(stage);

		});

		HBox hbButtons = new HBox();
		hbButtons.getChildren().add(backBtn);
		hbButtons.getChildren().add(playBtn);
		hbButtons.setPadding(new Insets(0, 0, 0, 0));
		hbButtons.setAlignment(Pos.CENTER_LEFT);
		hbButtons.setSpacing(50);
		root.add(hbButtons, 0, 8, 3, 1);

		VBox vBox = new VBox();
		vBox.getChildren().add(root);

		Scene scene = new Scene(vBox, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);


		stage.setScene(scene);
		scene.getStylesheets().add(AddPlayerView.class.getResource("style.css").toExternalForm());

	}

}