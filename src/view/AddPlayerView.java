package view;

import controller.*;
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

import java.util.ArrayList;

public class AddPlayerView {
	
	private int numPlayers;
	
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
		//root.setGridLinesVisible(true);

		stage.setTitle("G2 Sabateur");

		createContent.Title title = new createContent.Title("S A B A T E U R");

		createContent.subTitle subTitle = new createContent.subTitle("Player Name's");
		root.add(title, 0, 0, 2, 1);
		root.add(subTitle, 0, 1, 2, 1);

		ArrayList<TextField> nameList = new ArrayList<TextField>();
		String[] pName = new String[totalPlayers];
		//numPlayers = 3;
		int k = 1;
		for (int i = 0; i < totalPlayers; i++) {


			Label name = new Label(i+1 + ". Player Name");
			root.add(name, 0, k+1);
			
			TextField nameTextField = new TextField();
			nameList.add(nameTextField);
			root.add(nameTextField, 1, k+1);
			k++;
		}

		/*Button addPlayerBtn = new Button("+");
		root.add(addPlayerBtn, 4, 4);
		Button removePlayerBtn = new Button("-");




		// Need to save / store player names for when gameview starts...
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
					root.getChildren().remove(addPlayerBtn);
					root.getChildren().remove(removePlayerBtn);
					root.add(removePlayerBtn, 3, k);
					root.add(addPlayerBtn, 4, k);
				}
			}
		});
		// Removeing players from the list can be difficult with current setup. Not able to pop generic
		// name && nameTextField
		removePlayerBtn.setOnMouseClicked(event -> {
			if (numPlayers > 3) {
				numPlayers--;
			}
		});*/
		
		//Button backBtn = new Button("Back");
		createContent.MenuItem playBtn = new createContent.MenuItem("PLAY");
		//Button playBtn = new Button("Play");
		createContent.MenuItem backBtn = new createContent.MenuItem("BACK");
		
		playBtn.setOnMouseClicked(event ->  {
				
				PlayGameListener playGameListener = new PlayGameListener();
				int i = 0;
				for (TextField field : nameList) {
					pName[i] = field.getText();
					//System.out.println(pName[i]);
					i++;
				}
				AddPlayerListener addPlayerListener = new AddPlayerListener();
				addPlayerListener.createPlayer(pName);

				playGameListener.changeScene(pName, stage);
			
		});
		
		backBtn.setOnMouseClicked(event ->  {
			//BackToWelcomeListener backListener = new BackToWelcomeListener();
			//backListener.backToWelcome(stage);
			PlayerCountListener playerCountListener = new PlayerCountListener();
			playerCountListener.changeScene(stage);
		});
		
		HBox hbButtons = new HBox();
		hbButtons.getChildren().add(backBtn);
		hbButtons.getChildren().add(playBtn);
		hbButtons.setPadding(new Insets(0, 0, 0, 0));
		hbButtons.setAlignment(Pos.CENTER_LEFT);
		hbButtons.setSpacing(50);
		root.add(backBtn, 0, 5, 1, 1);
		root.add(playBtn, 1, 5, 1, 1);
		
		VBox vBox = new VBox();
		vBox.getChildren().add(root);
		//vBox.getChildren().add(hbButtons);
		
		Scene scene = new Scene(vBox, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);

		
		stage.setScene(scene);
		scene.getStylesheets().add(AddPlayerView.class.getResource("style.css").toExternalForm());
		
	}

}
