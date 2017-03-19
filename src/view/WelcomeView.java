package view;

import controller.AddPlayerListener;
import controller.ExitListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomeView {
	
	Stage stage;
	
	public WelcomeView(Stage stage) {
		
		this.stage = stage;
		
	}
	
	public void displayView() {
		
		stage.setTitle("Welcome");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//grid.setGridLinesVisible(true);
		
		Text sceneTitle = new Text("SABATEUR");
		sceneTitle.setId("title-text");
		GridPane.setHalignment(sceneTitle, HPos.CENTER);
		//sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(sceneTitle, 0, 0, 1, 1);
		
		Button playBtn = new Button("PLAY GAME");
		playBtn.setPrefWidth(300);
		playBtn.setPrefHeight(50);
		Button scoreBtn = new Button("LEADERBOARD");
		scoreBtn.setPrefWidth(300);
		scoreBtn.setPrefHeight(50);
		Button exitBtn = new Button("EXIT");
		exitBtn.setPrefWidth(300);
		exitBtn.setPrefHeight(50);
		
		VBox vbBtn = new VBox(10);
		vbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		vbBtn.getChildren().add(playBtn);
		vbBtn.getChildren().add(scoreBtn);
		vbBtn.getChildren().add(exitBtn);
		grid.add(vbBtn, 0, 2);
		
		playBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				AddPlayerListener addPlayerListener = new AddPlayerListener();
				addPlayerListener.changeScene(stage);
				
			}
			
		});
		
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				ExitListener exitListener = new ExitListener();
				exitListener.closeWindow(stage);
				
			}
			
		});
		
		Scene scene = new Scene(grid, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);
		stage.setScene(scene);
		scene.getStylesheets().add(MainView.class.getResource("style.css").toExternalForm());
				
	}

}
