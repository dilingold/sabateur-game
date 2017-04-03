package view;

import controller.AddPlayerListener;
import controller.BackToWelcomeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlayerCountView {

	private Stage stage;

	public PlayerCountView(Stage stage) {
		
		this.stage = stage;
		
	}
	
	public void displayView() {
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 85));
		root.setPrefSize(860, 600);
		
		stage.setTitle("G2 Sabateur");

		createContent.Title title = new createContent.Title("S A B A T E U R");

		createContent.subTitle subTitle= new createContent.subTitle("How Many Players");
		
		root.add(title, 0, 0, 1, 1);
		root.add(subTitle, 0, 1, 1, 1);

		createContent.MenuItem players3 = new createContent.MenuItem("3 PLAYERS");
		players3.setOnMouseClicked(event -> {
			
			AddPlayerListener addPlayerListener = new AddPlayerListener();
			addPlayerListener.playerCount(3, stage);
			
		});

		createContent.MenuItem players4 = new createContent.MenuItem("4 PLAYERS");
		players4.setOnMouseClicked(event -> {
			
			AddPlayerListener addPlayerListener = new AddPlayerListener();
			addPlayerListener.playerCount(4, stage);
			
		});

		createContent.MenuItem players5 = new createContent.MenuItem("5 PLAYERS");
		players5.setOnMouseClicked(event -> {
			
			AddPlayerListener addPlayerListener = new AddPlayerListener();
			addPlayerListener.playerCount(5, stage);
			
		});

		createContent.MenuItem players6 = new createContent.MenuItem("6 PLAYERS");
		players6.setOnMouseClicked(event -> {
			
			AddPlayerListener addPlayerListener = new AddPlayerListener();
			addPlayerListener.playerCount(6, stage);
			
		});

		createContent.MenuItem returnMenu = new createContent.MenuItem("BACK");
		returnMenu.setOnMouseClicked(event ->  {
			
				BackToWelcomeListener backListener = new BackToWelcomeListener();
				backListener.backToWelcome(stage);
				
		});

		createContent.MenuBox vbox = new createContent.MenuBox(
				players3,
				players4,
				players5,
				players6,
				returnMenu
		);

		root.add(vbox, 0, 2);

		Scene scene = new Scene(root, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);

		
		stage.setScene(scene);
		scene.getStylesheets().add(PlayerCountView.class.getResource("style.css").toExternalForm());
		
	}

}
