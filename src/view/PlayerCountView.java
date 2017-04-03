package view;

import controller.AddPlayerListener;
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
		
		createContent.MenuBox vbox = new createContent.MenuBox();
		
		int i = 3;
		while (i <= 6) {
			
			createContent.MenuItem playersMenuItem = createPlayersMenuItem(i);
			vbox.getChildren().add(playersMenuItem);
			
			i++;
				
		}

		root.add(vbox, 0, 2);

		Scene scene = new Scene(root, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);

		
		stage.setScene(scene);
		scene.getStylesheets().add(PlayerCountView.class.getResource("style.css").toExternalForm());
		
	}
	
	public createContent.MenuItem createPlayersMenuItem(int i) {
		
		createContent.MenuItem playersMenuItem = new createContent.MenuItem(i + " PLAYERS");
		playersMenuItem.setOnMouseClicked(event -> {
			
			AddPlayerListener addPlayerListener = new AddPlayerListener();
			addPlayerListener.changeScene(i, stage);
			
		});
		
		return playersMenuItem;
		
	}

}
