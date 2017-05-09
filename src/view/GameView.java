package view;

import java.util.ArrayList;

import controller.DragCardListener;
import controller.DropListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Board;
import model.Hand;
import model.Player;
import model.cards.*;
//import sun.applet.Main;

public class  GameView {

	private Stage stage;
	private Text playerText = null;
	private Player currentPlayer;
	private int draggedCardIndex;
	private Button roleBtn;
	private HBox hbCards;
	private VBox vbCards;

	/*
	 * this view is the game view which includes all the components required to play the game
	 * including the board, players, current player's hand and a discard pile
	 */
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

		//display the board in the centre of the screen
		//get the board and populate it with the start card, the goal cards and blank cards
		//add appropriate images in correct positions
		//make only the blank positions on the board droppable so player's path cards can be dropped on them
		Board currentBoard = Board.getInstance();
		for(int i = 0; i < 7; i++) {

			for(int k = 0; k < 7; k++) {

				switch (currentBoard.getCard(k, i).getName()) {

					case "blank card":
						Image image = new Image("/resources/images/board/empty.png");
						ImageView pic = new ImageView();
						pic.setFitWidth(60);
						pic.setFitHeight(60);
						pic.setImage(image);
						makeDroppable(pic, "board");
						boardGrid.add(pic, i, k);
						break;
					case "gold":
						Image goldImage = new Image("/resources/images/board/gold.png");
						ImageView goldPic = new ImageView();
						goldPic.setFitWidth(60);
						goldPic.setFitHeight(60);
						goldPic.setImage(goldImage);
						boardGrid.add(goldPic, i, k);
						break;
					case "stone":
						Image coalimage = new Image("/resources/images/board/coal.png");
						ImageView coalPic = new ImageView();
						coalPic.setFitWidth(60);
						coalPic.setFitHeight(60);
						coalPic.setImage(coalimage);
						boardGrid.add(coalPic, i, k);
						break;
					case "start":
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

		//placeholder: a card to reveal the player's role
		roleBtn.setOnAction(event ->  {
			
			if (roleBtn.getText() == "Role") {
				
				String role = MainView.gameEngine.getCurrentPlayer().getRole();
				roleBtn.setText(role);
				
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

		//display the players with images to the top right of the screen
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

		//display the discard icon to the bottom right of the screen
		Text discardText = new Text("Discard");
		discardText.setFill(Color.WHITE);
		discardText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		Image image = new Image(getClass().getResourceAsStream("/resources/images/board/discard.png"));
		ImageView discardImageView = new ImageView();
		discardImageView.setImage(image);
		discardImageView.setFitWidth(60);
		discardImageView.setFitHeight(60);
		makeDroppable(discardImageView, "discard");

		VBox vbDiscard = new VBox();
		vbDiscard.setSpacing(10);

		vbDiscard.getChildren().add(discardText);
		vbDiscard.getChildren().add(discardImageView);
		vbDiscard.setAlignment(Pos.CENTER);

		gameGrid.add(vbBoard, 0, 0);
		gameGrid.add(vbCards, 0, 1);
		gameGrid.add(vbPlayers, 2, 0, 1, 2);
		gameGrid.add(vbDiscard, 2, 1, 1, 2);

		Scene scene = new Scene(gameGrid, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);

		stage.setScene(scene);
		scene.getStylesheets().add(AddPlayerView.class.getResource("style.css").toExternalForm());

	}
	
	//display the current player's hand on the bottom of the screen
	public void displayHand() {
		
		HBox hb = new HBox(10);
		hb.setAlignment(Pos.TOP_CENTER);
		hb.getChildren().add(roleBtn);
		
		Hand hand = currentPlayer.getHand();
		for (int i = 0; i < hand.cardCount(); i++) {
			
			Button btn = new Button();
			
			//add the correct images to all cards
			//make all cards draggable
			//if the card is a path card, rotate card when it is clicked
			if (hand.getCards().get(i) == null) {
				String imageName = "/resources/images/board/empty.png";
				Image image = new Image(getClass().getResourceAsStream(imageName));
				btn.setGraphic(new ImageView(image));
			}
			else if(hand.getCards().get(i).getType() == "path"){

				PathCard pathCard = (PathCard) hand.getCards().get(i);
				makeClickable(btn, pathCard, i);
				String imageName = "/resources/images/cards/" + pathCard.getName() + "-rotate" + pathCard.getRotation() + ".png";
				Image image = new Image(getClass().getResourceAsStream(imageName));
				btn.setGraphic(new ImageView(image));
			}
			else {
				Card card = hand.getCards().get(i);
				String imageName = "/resources/images/cards/" + card.getName() + ".png";
				Image image = new Image(getClass().getResourceAsStream(imageName));
				btn.setGraphic(new ImageView(image));
				
			}

			if(hand.getCards().get(i) != null){
				makeDraggable(btn, i);
			}
			btn.setPrefHeight(60);
			btn.setPrefWidth(60);
			hb.getChildren().add(btn);
		
		}
		
		vbCards.getChildren().add(hb);
		hbCards = hb;
		
	}

	public void makeDraggable(Button btn, int index) {
		
		btn.setOnDragDetected(event -> {
			
			DragCardListener dragListener = new DragCardListener();
			dragListener.dragCard(btn, event);
			draggedCardIndex = index;
			
		});

	}
	
	//when a path card is clicked from the current player's hand, it rotates once to the right
	public void makeClickable(Button btn, PathCard card, int index) {
		
		btn.setOnAction(event -> {
			
			card.changeRotation();
			String imageName = "/resources/images/cards/" + card.getName() + "-rotate" + card.getRotation() + ".png";
			Image image = new Image(getClass().getResourceAsStream(imageName));
			btn.setGraphic(new ImageView(image));
			
		});
		
	}
	
	/*
	 * when a card is dropped onto the board it goes through a validation process,
	 * if it is a valid move, the next player's turn is called
	 * 
	 * when a card is dropped on the discard icon it is removed from the player's hand 
	 * and the next player's turn is called
	 */
	public void makeDroppable(ImageView target, String dropLocation) {
		
		DropListener dropListener = new DropListener();
		
		target.setOnDragOver(event ->  {
			
			dropListener.dragOver(event, target);
			
		});
		
		target.setOnDragDropped(event ->  {
			
			Node source = (Node) event.getSource();
			
			if (dropLocation == "board") {
				
				Integer rowIndex = GridPane.getRowIndex(source);
				Integer colIndex = GridPane.getColumnIndex(source);
				if(dropListener.drop(stage, event, currentPlayer, draggedCardIndex, target, rowIndex, colIndex) == true) {
					
					nextTurn();
					
				}
				
			}
			
			else if (dropLocation == "discard") {
				
				if(dropListener.drop(event, currentPlayer, draggedCardIndex, target)) {
					
					nextTurn();
					
				}
				
			}
			
			
		});

	}
	
	//change to the next player's turn
	public void nextTurn() {
		
		currentPlayer = MainView.gameEngine.nextPlayer();
		playerText.setText(currentPlayer.getName() + " Hand");
		vbCards.getChildren().remove(hbCards);
		displayHand();
		
	}

}