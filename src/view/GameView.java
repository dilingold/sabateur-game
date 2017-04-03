package view;

import java.util.ArrayList;

import controller.PlayGameListener;
import controller.PlayerInformation;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Hand;
import model.Player;

public class  GameView {

	private Stage stage;
	int testTurn = 1;
	Text playerText = null;

	public GameView(Stage stage) {

		this.stage = stage;

	}

	public void displayView(int totalPlayers, ArrayList<Player> playerNames) {
		
		PlayerInformation players = PlayerInformation.getInstance();
		Player currentPlayer = MainView.gameEngine.getCurrentPlayer();

		currentPlayer.getHand().print();

		stage.setTitle("Play Game");
		GridPane gameGrid = new GridPane();
		gameGrid.setAlignment(Pos.CENTER);
		gameGrid.setHgap(10);
		gameGrid.setVgap(10);
		gameGrid.setPadding(new Insets(25, 25, 25, 25));
		gameGrid.setGridLinesVisible(true);

		VBox vbBoard = new VBox(10);

		Text boardText = new Text("Board");
		vbBoard.setAlignment(Pos.CENTER);
		boardText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		boardText.setFill(Color.WHITE);
		vbBoard.getChildren().add(boardText);

		GridPane boardGrid = new GridPane();

		// Call the controller for the current gameboard to layout gameboard TEST
		PlayGameListener playGameListener = new PlayGameListener();
		int[][] currentBoard = playGameListener.getCurrentBoard();
		
		for(int i = 0; i < 7; i++) {
			
			for(int k = 0; k < 7; k++) {
				
				System.out.println(currentBoard[i][k]);
				
				switch (currentBoard[k][i]) {
				
					case 0:
						System.out.println("Empty");
						Image image = new Image("/resources/images/board/empty.png");
						ImageView pic = new ImageView();
						pic.setFitWidth(60);
						pic.setFitHeight(60);
						pic.setImage(image);
						makeDroppableBoard(pic);
						boardGrid.add(pic, i, k);
						break;
					case 1:
						Image goldImage = new Image("/resources/images/board/gold.png");
						ImageView goldPic = new ImageView();
						goldPic.setFitWidth(60);
						goldPic.setFitHeight(60);
						goldPic.setImage(goldImage);
						boardGrid.add(goldPic, i, k);
						break;
					case 2:
						Image coalimage = new Image("/resources/images/board/coal.png");
						ImageView coalPic = new ImageView();
						coalPic.setFitWidth(60);
						coalPic.setFitHeight(60);
						coalPic.setImage(coalimage);
						boardGrid.add(coalPic, i, k);
						break;
					case 5:
						Image startImage = new Image("/resources/images/cards/T Path.png");
						ImageView startPic = new ImageView();
						startPic.setFitWidth(60);
						startPic.setFitHeight(60);
						startPic.setImage(startImage);
						boardGrid.add(startPic, i, k);
						
				}
				
			}
			
		}
		
		boardGrid.setAlignment(Pos.BOTTOM_CENTER);
		vbBoard.getChildren().add(boardGrid);

		// Call Controller on Player ones Hand.
		playerText = new Text(playGameListener.PlayerName(0) + " Hand");
		playerText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		playerText.setFill(Color.WHITE);

		VBox vbCards = new VBox(10);
		vbCards.setAlignment(Pos.BOTTOM_CENTER);
		vbCards.getChildren().add(playerText);

		HBox hbCards = new HBox(10);
		hbCards.setAlignment(Pos.TOP_CENTER);

		Button roleBtn = new Button("Role");
		roleBtn.setPrefHeight(80);
		roleBtn.setPrefWidth(70);
		hbCards.getChildren().add(roleBtn);

		roleBtn.setOnAction(event ->  {
			
			if (roleBtn.getText() == "Role") {
				
				roleBtn.setText("Sabateur");
				
			}
			
			else {
				
				roleBtn.setText("Role");
				
			}
			
		});
		
		Hand hand = currentPlayer.getHand();

		for (int i = 0; i < hand.cardCount(); i++) {
			
			String cardName = hand.getCards().get(i).getName();
			String imageName = "/resources/images/cards/" + cardName + ".png";
			Image image = new Image(getClass().getResourceAsStream(imageName));
			Button btn = new Button();
			btn.setGraphic(new ImageView(image));
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
		playersText.setFill(Color.WHITE);
		playersText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		vbPlayers.getChildren().add(playersText);

		int k = 0;
		for(Player player: playerNames) {
			
			String imageName = "/resources/images/players/a" + (k+1) + ".jpg";
			Image image = new Image(getClass().getResourceAsStream(imageName));
			Label pLabel = new Label(player.getName());
			makeDroppable(pLabel, k+1);
			pLabel.setMinWidth(150.0);
			pLabel.setGraphic(new ImageView(image));
			vbPlayers.getChildren().add(pLabel);
			k++;
			
		}

		Button deckButton = new Button("Deck");
		deckButton.setPrefHeight(60);
		deckButton.setPrefWidth(60);

		Button discardButton = new Button("Discard");
		//makeDroppable(discardButton, 1);
		discardButton.setPrefHeight(60);
		discardButton.setPrefWidth(60);

		// Deck Area
		HBox cardPile = new HBox();
		cardPile.setSpacing(20);

		cardPile.getChildren().addAll(discardButton, deckButton);
		cardPile.setAlignment(Pos.CENTER);

		gameGrid.add(vbBoard, 0, 0);
		gameGrid.add(vbCards, 0, 1);
		gameGrid.add(vbPlayers, 2, 0, 1, 2);
		gameGrid.add(cardPile, 2, 1, 1, 2);

		Scene scene = new Scene(gameGrid, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);

		stage.setScene(scene);
		scene.getStylesheets().add(AddPlayerView.class.getResource("style.css").toExternalForm());

	}

	public void makeDraggable(Button btn) {
		
		btn.setOnDragDetected(event -> {
			
			Dragboard db = btn.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			ClipboardContent content = new ClipboardContent();
			content.putString(btn.getText());
			db.setContent(content);
			event.consume();
			
		});

	}

	public void makeDroppable(Label target, int index) {

		target.setOnDragOver(event ->  {
			
			if (event.getGestureSource() != target) {
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				
			}
			
			event.consume();
			
		});

		target.setOnDragDropped(event ->  {
			
			if (event.getGestureSource() != target) {
				
				PlayGameListener playGameListener = new PlayGameListener();

				String imageName = "/resources/images/players/a" + index + "-curse.jpg";
				Image image = new Image(getClass().getResourceAsStream(imageName));
				target.setGraphic(new ImageView(image));

				// Temp change players turn to test
				playerText.setText(playGameListener.nextTurn(0) + " Hand");

			}

		});
	};
	
	public void makeDroppableBoard(ImageView target) {
		
		target.setOnDragOver(event ->  {
			
			if (event.getGestureSource() != target) {
				
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				
			}
			
			event.consume();
			
		});
		
		target.setOnDragDropped(event ->  {
			
			if (event.getGestureSource() != target) {

				PlayGameListener playGameListener = new PlayGameListener();

				String imageName = "/resources/images/cards/cross.png";
				Image image = new Image(getClass().getResourceAsStream(imageName));
				target.setImage(image);

				// Temp change players turn to test
				playerText.setText(playGameListener.nextTurn(0) + " Hand");
				
			}
			
		});

	}

}