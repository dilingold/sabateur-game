package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class  GameView {
	
	private Stage stage;
	
	public GameView(Stage stage) {
		
		this.stage = stage;
		
	}
	
	public void displayView() {
		
		stage.setTitle("Play Game");
		
		GridPane gameGrid = new GridPane();
		gameGrid.setAlignment(Pos.TOP_CENTER);
		gameGrid.setHgap(10);
		gameGrid.setVgap(10);
		gameGrid.setPadding(new Insets(25, 25, 25, 25));
		//gameGrid.setGridLinesVisible(true);
		
		final int numCols = 9;
		final int numRows = 5;
		
		VBox vbBoard = new VBox(10);
		
		Text boardText = new Text("Board");
		vbBoard.setAlignment(Pos.CENTER);
		boardText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		vbBoard.getChildren().add(boardText);
		
		GridPane boardGrid = new GridPane();
		
		for (int i = 0; i < numCols; i++) {
			
			for (int j = 0; j < numRows; j++) {
				
				Button btn = new Button();
				btn.setPrefHeight(60);
				btn.setPrefWidth(60);
				boardGrid.add(btn, i, j);
				
			}
			
		}
		//boardGrid.setGridLinesVisible(true);
		
		vbBoard.getChildren().add(boardGrid);
		
		Text playerText = new Text("Player 1 Hand");
		playerText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		VBox vbCards = new VBox(10);
		vbCards.setAlignment(Pos.BOTTOM_CENTER);
		vbCards.getChildren().add(playerText);
		
		HBox hbCards = new HBox(10);
		hbCards.setAlignment(Pos.TOP_CENTER);
		
		Button roleBtn = new Button("Role");
		roleBtn.setPrefHeight(80);
		roleBtn.setPrefWidth(70);
		hbCards.getChildren().add(roleBtn);
		
		roleBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				if (roleBtn.getText() == "Role") {
					
					roleBtn.setText("Sabateur");
					
				}
				
				else {
					
					roleBtn.setText("Role");
					
				}
				
			}
			
		});
		
		for (int i = 0; i < 6; i++) {
			
			Button btn = new Button("Card " + i);
			makeDraggable(btn);
			btn.setPrefHeight(60);
			btn.setPrefWidth(60);
			hbCards.getChildren().add(btn);
			
		}
		
		vbCards.getChildren().add(hbCards);
		
		VBox vbPlayers = new VBox(10);
		vbPlayers.setAlignment(Pos.TOP_CENTER);
		
		Text playersText = new Text("Players");
		GridPane.setHalignment(playersText, HPos.CENTER);
		playersText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		vbPlayers.getChildren().add(playersText);
		
		int numPlayers = 6;
		
		for (int i = 0; i < numPlayers; i++) {
			
			String imageName = "a" + (i+1) + ".jpg";
			Image image = new Image(getClass().getResourceAsStream(imageName));
			
			Label player = new Label("Player " + (i+1));
			makeDroppable(player, i+1);
			player.setGraphic(new ImageView(image));
			vbPlayers.getChildren().add(player);
			
		}
		
		Text deckText = new Text("Deck");
		GridPane.setHalignment(deckText, HPos.CENTER);
		deckText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		Button deckButton = new Button("Deck");
		deckButton.setPrefHeight(60);
		deckButton.setPrefWidth(60);
		
		vbPlayers.getChildren().add(deckText);
		vbPlayers.getChildren().add(deckButton);
		
		gameGrid.add(vbBoard, 0, 0);
		gameGrid.add(vbCards, 0, 1);
		gameGrid.add(vbPlayers, 2, 0, 1, 2);
		
		Scene scene = new Scene(gameGrid, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);
		
		stage.setScene(scene);
		scene.getStylesheets().add(AddPlayerView.class.getResource("style.css").toExternalForm());
		
	}
	
	public void makeDraggable(Button btn) {
		
		btn.setOnDragDetected(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent event) {
				
				Dragboard db = btn.startDragAndDrop(TransferMode.COPY_OR_MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putString(btn.getText());
				db.setContent(content);
				
				event.consume();
				
			}
			
		});
		
	}
	
	public void makeDroppable(Label target, int index) {
		
		target.setOnDragOver(new EventHandler<DragEvent>() {
			
			public void handle(DragEvent event) {
				
				if (event.getGestureSource() != target) {
					
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
					
				}
				
				event.consume();
				
			}
			
		});
		
		target.setOnDragDropped(new EventHandler<DragEvent>() {
			
			public void handle(DragEvent event) {
				
				if (event.getGestureSource() != target) {
					
					//target.setText("curse");
					
					String imageName = "a" + index + "-curse.jpg";
					Image image = new Image(getClass().getResourceAsStream(imageName));
					target.setGraphic(new ImageView(image));
					
				}
				
			}
			
		});
		
	}

}
