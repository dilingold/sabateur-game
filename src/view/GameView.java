package view;

import java.util.ArrayList;

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
	private Text playerText = null;
	private Player currentPlayer;
	private int draggedCardIndex;
	private Button roleBtn;
	private HBox hbCards;
	private VBox vbCards;

	public GameView(Stage stage) {

		this.stage = stage;

	}

	public void displayView(int totalPlayers, ArrayList<Player> playerNames) {
		
		currentPlayer = MainView.gameEngine.getCurrentPlayer();

		stage.setTitle("Play Game");
		GridPane gameGrid = new GridPane();
		gameGrid.setAlignment(Pos.CENTER);
		gameGrid.setHgap(10);
		gameGrid.setVgap(10);
		gameGrid.setPadding(new Insets(25, 25, 25, 25));
		gameGrid.setGridLinesVisible(false);

		VBox vbBoard = new VBox(10);

		Text boardText = new Text("Board");
		vbBoard.setAlignment(Pos.CENTER);
		boardText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		boardText.setFill(Color.WHITE);
		vbBoard.getChildren().add(boardText);

		GridPane boardGrid = new GridPane();

		int[][] currentBoard = MainView.gameEngine.getBoard().currentBoard();
		
		for(int i = 0; i < 7; i++) {
			
			for(int k = 0; k < 7; k++) {
								
				switch (currentBoard[k][i]) {
				
					case 0:
						Image image = new Image("/resources/images/board/empty.png");
						ImageView pic = new ImageView();
						pic.setFitWidth(60);
						pic.setFitHeight(60);
						pic.setImage(image);
						makeDroppableBoard(pic);
						boardGrid.add(pic, i, k);
						break;
					case 1:
						Image goldImage = new Image("/resources/images/board/goal.png");
						ImageView goldPic = new ImageView();
						goldPic.setFitWidth(60);
						goldPic.setFitHeight(60);
						goldPic.setImage(goldImage);
						boardGrid.add(goldPic, i, k);
						break;
					case 2:
						Image coalimage = new Image("/resources/images/board/goal.png");
						ImageView coalPic = new ImageView();
						coalPic.setFitWidth(60);
						coalPic.setFitHeight(60);
						coalPic.setImage(coalimage);
						boardGrid.add(coalPic, i, k);
						break;
					case 5:
						Image startImage = new Image("/resources/images/cards/start.png");
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
		playerText = new Text(MainView.gameEngine.getCurrentPlayer().getName() + " Hand");
		playerText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		playerText.setFill(Color.WHITE);

		vbCards = new VBox(10);
		vbCards.setAlignment(Pos.BOTTOM_CENTER);
		vbCards.getChildren().add(playerText);

		hbCards = new HBox(10);
		hbCards.setAlignment(Pos.TOP_CENTER);

		roleBtn = new Button("Role");
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
		
		displayHand();

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
			pLabel.setMinWidth(150.0);
			pLabel.setGraphic(new ImageView(image));
			vbPlayers.getChildren().add(pLabel);
			k++;
			
		}

		Text discardText = new Text("Discard");
		discardText.setFill(Color.WHITE);
		discardText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		Label discardIcon = new Label();
		discardIcon.setPrefHeight(60);
		discardIcon.setPrefWidth(60);
		Image image = new Image(getClass().getResourceAsStream("/resources/images/board/discard.png"));
		discardIcon.setGraphic(new ImageView(image));

		// Deck Area
		VBox vbDiscard = new VBox();
		vbDiscard.setSpacing(10);

		vbDiscard.getChildren().add(discardText);
		vbDiscard.getChildren().add(discardIcon);
		vbDiscard.setAlignment(Pos.CENTER);

		gameGrid.add(vbBoard, 0, 0);
		gameGrid.add(vbCards, 0, 1);
		gameGrid.add(vbPlayers, 2, 0, 1, 2);
		gameGrid.add(vbDiscard, 2, 1, 1, 2);

		Scene scene = new Scene(gameGrid, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);

		stage.setScene(scene);
		scene.getStylesheets().add(AddPlayerView.class.getResource("style.css").toExternalForm());

	}
	
	public void displayHand() {
		
		HBox hb = new HBox(10);
		hb.setAlignment(Pos.TOP_CENTER);
		hb.getChildren().add(roleBtn);
		
		Hand hand = currentPlayer.getHand();
		
		for (int i = 0; i < hand.cardCount(); i++) {
			
			String cardName = hand.getCards().get(i).getName();
			String imageName = "/resources/images/cards/" + cardName + ".png";
			Image image = new Image(getClass().getResourceAsStream(imageName));
			Button btn = new Button();
			btn.setGraphic(new ImageView(image));
			makeDraggable(btn, i);
			btn.setPrefHeight(60);
			btn.setPrefWidth(60);
			hb.getChildren().add(btn);
		
		}
		
		vbCards.getChildren().add(hb);
		hbCards = hb;
		
	}

	public void makeDraggable(Button btn, int index) {
		
		btn.setOnDragDetected(event -> {
			
			draggedCardIndex = index;
			Dragboard db = btn.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			ClipboardContent content = new ClipboardContent();
			content.putString(btn.getText());
			db.setContent(content);
			event.consume();
			
		});

	}
	
	public void makeDroppableBoard(ImageView target) {
		
		target.setOnDragOver(event ->  {
			
			if (event.getGestureSource() != target) {
				
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				
			}
			
			event.consume();
			
		});
		
		target.setOnDragDropped(event ->  {
			
			if (event.getGestureSource() != target) {

				String draggedCardName = currentPlayer.getHand().getCards().get(draggedCardIndex).getName();
				String imageName = "/resources/images/cards/" + draggedCardName + ".png";
				Image image = new Image(getClass().getResourceAsStream(imageName));
				target.setImage(image);

				// Temp change players turn to test
				currentPlayer = MainView.gameEngine.nextPlayer();
				playerText.setText(currentPlayer.getName() + " Hand");
				vbCards.getChildren().remove(hbCards);
				displayHand();
				
			}
			
		});

	}

}