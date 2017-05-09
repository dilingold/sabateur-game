package view;

import controller.PlayGameListener;
import controller.Treasure;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Board;
import model.cards.StartCard;

public class PlayAgainView {
	
	private Stage stage;
	
	public PlayAgainView(Stage stage) {
		
		this.stage = stage;
		
	}
	
	public void displayView(String winner) {
		
		String winnerString;
		if (winner == "miner") {
			
			winnerString = "Miners Win!";
			
		}
		
		else winnerString = "Sabateurs Win!";
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 85));
		root.setPrefSize(860,  600);
		
		stage.setTitle("G2 Sabateur");
		
		createContent.Title title = new createContent.Title("S A B A T E U R");
		
		createContent.subTitle subTitle = new createContent.subTitle(winnerString);
		
		createContent.MenuItem playAgain = new createContent.MenuItem("PLAY AGAIN");
		playAgain.setOnMouseClicked(event -> {
			
			Board.getInstance().initBoard();
			new Treasure().setTreasure();
			Board.getInstance().playCard(6, 3, new StartCard());
			PlayGameListener playGameListener = new PlayGameListener();
			playGameListener.changeScene(stage);
			
		});
		
		createContent.MenuBox vbox = new createContent.MenuBox(playAgain);
		
		root.add(title, 0, 0, 1, 1);
		root.add(subTitle, 0, 2);
		root.add(vbox, 0, 4);
		
		Scene scene = new Scene(root, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);
		stage.setScene(scene);
		scene.getStylesheets().add(MainView.class.getResource("style.css").toExternalForm());
		
	}

}
