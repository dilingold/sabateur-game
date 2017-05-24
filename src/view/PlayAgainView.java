package view;

import controller.PlayAgainListener;
import controller.PlayGameListener;
import controller.PlayerController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.PlayerD;

public class PlayAgainView {
	
	private Stage stage;
	
	public PlayAgainView(Stage stage) {
		
		this.stage = stage;
		System.out.println("play again screen");
		PlayGameListener.stopTime();
	}
	
	public void displayView(String winner) {
		
		String winnerString;
		if (winner == "miners") {
			
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

			new PlayAgainListener().playAgain(stage);
			
		});
		
		createContent.MenuBox vbox = new createContent.MenuBox(playAgain);
		
		createContent.subTitle scoreSubTitle = new createContent.subTitle("Gold");
		createContent.MenuBox scoreVBox = new createContent.MenuBox();
		scoreVBox.getChildren().add(scoreSubTitle);
		for (PlayerD player : PlayerController.getInstance().getPlayerList()) {
			
			createContent.MenuText playerText = new createContent.MenuText(
					player.getName() + ": " + player.getGold());
			
			scoreVBox.getChildren().add(playerText);
			
		}
		
		root.add(title, 0, 0, 1, 1);
		root.add(subTitle, 0, 2);
		root.add(vbox, 0, 4);
		root.add(scoreVBox, 2, 2, 1, 4);
		
		Scene scene = new Scene(root, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);
		stage.setScene(scene);
		scene.getStylesheets().add(MainView.class.getResource("style.css").toExternalForm());
		
	}

}
