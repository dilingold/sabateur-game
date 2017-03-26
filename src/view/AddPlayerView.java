package view;

import controller.BackToWelcomeListener;
import controller.PlayGameListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import controller.createContent;

public class AddPlayerView {
	
	private int numPlayers;
	
	private Stage stage;
	
	public AddPlayerView(Stage stage) {
		
		this.stage = stage;
		
	}
	
	public void displayView() {
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 85));
		root.setPrefSize(860, 600);
		root.setGridLinesVisible(true);

		stage.setTitle("G2 Sabateur");

		createContent.Title title = new createContent.Title("S A B A T E U R");

		createContent.subTitle subTitle = new createContent.subTitle("Add Players");
		root.add(title, 0, 0, 2, 1);
		root.add(subTitle, 0, 1, 2, 1);

		numPlayers = 3;
		int k = 1;
		for (int i = 0; i < numPlayers; i++) {


			Label name = new Label(i+1 + ". Player Name");
			root.add(name, 0, k+1);
			
			TextField nameTextField = new TextField();
			root.add(nameTextField, 1, k+1);
			k++;
		}
		
		Button addPlayerBtn = new Button("+");
		root.add(addPlayerBtn, 2, 0);
		
		addPlayerBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int k = numPlayers + 1;
				if (numPlayers < 6) {
					
					numPlayers++;
					k++;
										
					Label name = new Label(numPlayers + ". Player Name");
					root.add(name, 0, k);
					
					TextField nameTextField = new TextField();
					root.add(nameTextField, 1, k);
					
				}
			}
		});
		
		Button backBtn = new Button("Back");
		
		Button playBtn = new Button("Play");
		
		playBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				PlayGameListener playGameListener = new PlayGameListener();
				playGameListener.changeScene(stage);
				
			}		
			
		});
		
		backBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				BackToWelcomeListener backListener = new BackToWelcomeListener();
				backListener.backToWelcome(stage);
				
			}		
			
		});
		
		HBox hbButtons = new HBox();
		hbButtons.getChildren().add(backBtn);
		hbButtons.getChildren().add(playBtn);
		hbButtons.setPadding(new Insets(25, 0, 0, 0));
		hbButtons.setAlignment(Pos.CENTER);
		hbButtons.setSpacing(300);
		
		VBox vBox = new VBox();
		vBox.getChildren().add(root);
		vBox.getChildren().add(hbButtons);
		
		Scene scene = new Scene(vBox, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);

		
		stage.setScene(scene);
		scene.getStylesheets().add(AddPlayerView.class.getResource("style.css").toExternalForm());
		
	}

}
