package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import controller.DragCardListener;
import controller.DropListener;
import controller.GameEngine;
import controller.PlayGameListener;

import controller.*;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Board;
import model.EventObserver;
import model.Hand;
import model.Player;
import model.cards.*;
//import sun.applet.Main;

public class  GameView implements Observer{

	private Stage stage;
	private Text playerText = null;
	
	private Player currentPlayer;
	//made static for access to reset view
	private static ImageView[][] imageViews;

	private int draggedCardIndex;
	private Button roleBtn;
	private Button undoTurnBtn;
	private HBox hbCards;
	private VBox vbCards;
	private List<Label> playerLabels;
	private Label timeLabel = new Label();
	private EventObserver timerUpdate ;

	@Override
	public void update(Observable observable, Object arg)
	{
		timerUpdate = (EventObserver) observable;
		try {
			currentPlayer.getHand().discardCard(0);
			currentPlayer.drawCard();
		}catch (Exception e) {
			PlayGameListener.stopTime();
		}

		if(timerUpdate.getTimerStatus()) {
			nextTurn();
		}

		//PlayGameListener.stopTime();
	}

	//T - accessible for refresh script
	private GridPane boardGrid;
	
	/*
	 * this view is the game view which includes all the components required to play the game
	 * including the board, players, current player's hand and a discard pile
	 */
	public GameView(Stage stage) {

		this.stage = stage;
		PlayGameListener.startTimer(timeLabel);
		stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
			if (KeyCode.ESCAPE == event.getCode()) {
				//code to add
			}
		});

	}

	public void displayView(int totalPlayers, ArrayList<Player> playerNames) {
		BorderPane root = new BorderPane();
		final Menu menu1 = new Menu("File");
		final Menu menu2 = new Menu("Options");
		final Menu menu3 = new Menu("Help");

		final MenuItem menuItem1 = new MenuItem("Load");

		menu1.getItems().addAll(menuItem1);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2, menu3);

		menuBar.setStyle("-fx-stroke: red;");

		menuItem1.setOnAction(event -> {
			System.out.println("OPEN STATE");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(stage);
			VBox dialogVbox = new VBox(20);
			HBox hBox = new HBox(20);

			TextField numberField1 = new TextField();
			numberField1.setMaxWidth(40.0);

			TextField numberField2 = new TextField();
			numberField2.setMaxWidth(40.0);

			TextField numberField3 = new TextField();
			numberField3.setMaxWidth(40.0);

			Button load = new Button("Load");

			dialogVbox.getChildren().add(new Text("Enter Game State"));
			hBox.getChildren().addAll(numberField1, numberField2, numberField3);

			dialogVbox.getChildren().add(hBox);
			dialogVbox.getChildren().add(load);


			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();

			load.setOnAction(event1 -> {
				System.out.println("PASSING BOX 1 2 and 3 and closing window here");
				dialog.close();
			});

		});
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
		vbBoard.getChildren().add(timeLabel);

		//T - making accessible for refresh board
		boardGrid = new GridPane();

		//display the board in the centre of the screen
		//get the board and populate it with the start card, the goal cards and blank cards
		//add appropriate images in correct positions
		//make only the blank positions on the board droppable so player's path cards can be dropped on them
		Board currentBoard = Board.getInstance();
		int rows = currentBoard.getRows();
		int cols = currentBoard.getCols();
		imageViews = new ImageView[rows][cols];
		for(int i = 0; i < cols; i++) {

			for(int k = 0; k < rows; k++) {

				switch (currentBoard.getCard(k, i).getName()) {

					case "blank card":
						Image image = new Image("/resources/images/board/empty.png");
						ImageView pic = new ImageView();
						pic.setFitWidth(60);
						pic.setFitHeight(60);
						pic.setImage(image);
						makeDroppable(pic, "board");
						boardGrid.add(pic, i, k);
						imageViews[k][i] = pic;
						break;
					case "gold":
						Image goldImage = new Image("/resources/images/board/backofCard.png");
						ImageView goldPic = new ImageView();
						goldPic.setFitWidth(60);
						goldPic.setFitHeight(60);
						goldPic.setImage(goldImage);
						makeDroppable(goldPic, "board");
						boardGrid.add(goldPic, i, k);
						imageViews[k][i] = goldPic;
						break;
					case "stone":
						Image coalimage = new Image("/resources/images/board/backofCard.png");
						ImageView coalPic = new ImageView();
						coalPic.setFitWidth(60);
						coalPic.setFitHeight(60);
						coalPic.setImage(coalimage);
						makeDroppable(coalPic, "board");
						boardGrid.add(coalPic, i, k);
						imageViews[k][i] = coalPic;
						break;
					case "start":
						Image startImage = new Image("/resources/images/cards/start.png");
						ImageView startPic = new ImageView();
						startPic.setFitWidth(60);
						startPic.setFitHeight(60);
						startPic.setImage(startImage);
						boardGrid.add(startPic, i, k);
						imageViews[k][i] = startPic;
					
/*	
 * For refresh view method:
					default: //else
						case "path":
							String pathImageName = "/resources/images/cards/" + currentBoard.getCard(k, i).getName() + "-rotate"
								+ ((PathCard) currentBoard.getCard(k, i)).getRotation() + ".png";
							Image pathImage = new Image(pathImageName);
							ImageView pathPic = new ImageView();
							pathPic.setFitWidth(60);
							pathPic.setFitHeight(60);
							pathPic.setImage(pathImage);
							boardGrid.add(pathPic, i, k);
							imageViews[k][i] = pathPic;
						case "action":
							String actionImageName = "/resources/images/cards/"+currentBoard.getCard(k, i).getName() + ".png";
							Image actionImage = new Image(actionImageName);
							ImageView actionPic = new ImageView();
							actionPic.setFitWidth(60);
							actionPic.setFitHeight(60);
							actionPic.setImage(actionImage);
							boardGrid.add(actionPic, i, k);
							imageViews[k][i] = actionPic;
*/
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

        undoTurnBtn = new Button("Undo Turn");
		undoTurnBtn.setPrefHeight(80);
		undoTurnBtn.setPrefWidth(70);
		hbCards.getChildren().add(undoTurnBtn);

		//placeholder: a card to reveal the player's role
		roleBtn.setOnAction(event ->  {
			
			if (roleBtn.getText() == "Role") {
				
				String role = MainView.gameEngine.getCurrentPlayer().getType();
				roleBtn.setText(role);
				
			}
			
			else {
				
				roleBtn.setText("Role");
				
			}
			
		});
		//when undo turn button pressed
		undoTurnBtn.setOnAction(event ->  {
		            
        		    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(stage);
                    VBox dialogVbox = new VBox(20);
                    
                    dialogVbox.getChildren().add(new Text("Choose how many turns to revert by"));

                    Button buttonTypeOne = new Button("One");
                    Button buttonTypeTwo = new Button("Two");
                    Button buttonTypeThree = new Button("Three");
                    Button buttonTypeCancel = new Button("Cancel");
                    buttonTypeCancel.setOnAction(e -> dialog.close());
                    buttonTypeOne.setOnAction(e ->{
                        if(GameEngine.getTurn() > 1){
                            revertTurn(1);
                            dialog.close();
                        }
                    });
                    buttonTypeTwo.setOnAction(e ->{
                        if(GameEngine.getTurn() > 2){
                            revertTurn(2);
                            dialog.close();
                        }
                    });
                    buttonTypeThree.setOnAction(e ->{
                        if(GameEngine.getTurn() > 3){
                            revertTurn(3);
                            dialog.close();
                        }
                    });
                    
                    dialogVbox.getChildren().addAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);
     
                    
                    

                    Scene dialogScene = new Scene(dialogVbox, 300, 200);
                    dialog.setScene(dialogScene);
                    dialog.show();
		            //int turnsToRevert = Integer.parseInt(selectedValue.toString());
		            /*if(GameEngine.getTurn() > turnsToRevert){
		                GameEngine.getGameStates().loadState(turnsToRevert);
		                undoTurnBtn.setDisable(true);
		            }*/
		  

        });
		
		displayHand();

		VBox vbPlayers = new VBox(10);
		vbPlayers.setAlignment(Pos.TOP_CENTER);

		Text playersText = new Text("Players");
		GridPane.setHalignment(playersText, HPos.CENTER);
		playersText.setFill(Color.WHITE);
		playersText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		vbPlayers.getChildren().add(playersText);
		
		playerLabels = new ArrayList<Label>();
		
		//display the players with images to the top right of the screen
		int k = 0;
		for(Player player: playerNames) {
			
			String imageName;
			imageName = "/resources/images/players/a" + (k+1) + ".png";
			
			Image image = new Image(getClass().getResourceAsStream(imageName));
			Label pLabel = new Label(player.getName());
			pLabel.setMinWidth(150.0);
			ImageView playerImageView = new ImageView();
			playerImageView.setImage(image);
			playerImageView.setFitWidth(60);
			playerImageView.setFitHeight(60);
			pLabel.setGraphic(playerImageView);
			makeDroppable(pLabel, player);
			vbPlayers.getChildren().add(pLabel);
			k++;
			
			playerLabels.add(pLabel);
			
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


		root.setTop(menuBar);
		root.setCenter(gameGrid);
		Scene scene = new Scene(root, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);

		stage.setScene(scene);
		scene.getStylesheets().add(AddPlayerView.class.getResource("style.css").toExternalForm());

	}
	
	//display the current player's hand on the bottom of the screen
	public void displayHand() {
		
		HBox hb = new HBox(10);
		hb.setAlignment(Pos.TOP_CENTER);
		hb.getChildren().add(roleBtn);
		hb.getChildren().add(undoTurnBtn);
		
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
		
		DropListener dropListener = new DropListener(this);
		
		target.setOnDragOver(event ->  {
			dropListener.dragOver(event, target);
			
		});
		target.setOnDragDropped(event ->  {

			Node source = (Node) event.getSource();
			
			if (dropLocation == "board") {
				Integer rowIndex = GridPane.getRowIndex(source);
				Integer colIndex = GridPane.getColumnIndex(source);
				if(dropListener.drop(stage, event, currentPlayer, draggedCardIndex, target,
						imageViews, rowIndex, colIndex)) {
					
					nextTurn();
					
				}
				
			}
			
			else if (dropLocation == "discard") {
				
				if(dropListener.drop(stage, event, currentPlayer, draggedCardIndex, target)) {
					
					nextTurn();
					
				}
				
			}
			
			
		});

	}
	
	public void makeDroppable(Label target, Player player) {
		
		DropListener dropListener = new DropListener(this);
		
		target.setOnDragOver(event ->  {
			
			dropListener.dragOver(event, target);
			
		});
		
		target.setOnDragDropped(event ->  {
			
			Node source = (Node) event.getSource();	
			if(dropListener.drop(stage, event, currentPlayer, player, draggedCardIndex, target)) {
				
				nextTurn();
				
			}
			
		});

	}
	
	//change to the next player's turn
	public void nextTurn() {
		
		currentPlayer = MainView.gameEngine.nextPlayer();
		playerText.setText(currentPlayer.getName() + " Hand");
		vbCards.getChildren().remove(hbCards);
		displayHand();
		PlayGameListener.updateTime();
		
	}
	
	public void setPowerToolImage(Player player) {
		
		Label target = playerLabels.get(player.getUID());
		String imageName = "/resources/images/players/a" + (player.getUID()+1) + "-power.png";
		
		Image image = new Image(getClass().getResourceAsStream(imageName));
		target.setMinWidth(150.0);
		ImageView playerImageView = new ImageView();
		playerImageView.setImage(image);
		playerImageView.setFitWidth(60);
		playerImageView.setFitHeight(60);
		target.setGraphic(playerImageView);
		
	}
	
	public void setSuperPowerToolImage(Player player) {
		
		Label target = playerLabels.get(player.getUID());
		String imageName = "/resources/images/players/a" + (player.getUID()+1) + "-super.png";
		
		Image image = new Image(getClass().getResourceAsStream(imageName));
		target.setMinWidth(150.0);
		ImageView playerImageView = new ImageView();
		playerImageView.setImage(image);
		playerImageView.setFitWidth(60);
		playerImageView.setFitHeight(60);
		target.setGraphic(playerImageView);
		
	}
	
	public void removePowerToolImage() {
		
		Label target = playerLabels.get(currentPlayer.getUID());
		String imageName = "/resources/images/players/a" + (currentPlayer.getUID()+1) + ".png";
		
		Image image = new Image(getClass().getResourceAsStream(imageName));
		target.setMinWidth(150.0);
		ImageView playerImageView = new ImageView();
		playerImageView.setImage(image);
		playerImageView.setFitWidth(60);
		playerImageView.setFitHeight(60);
		target.setGraphic(playerImageView);
		
	}
	
	public void removeSuperPowerToolImage() {
		
		Label target = playerLabels.get(currentPlayer.getUID());
		String imageName = "/resources/images/players/a" + (currentPlayer.getUID()+1) + ".png";
		
		Image image = new Image(getClass().getResourceAsStream(imageName));
		target.setMinWidth(150.0);
		ImageView playerImageView = new ImageView();
		playerImageView.setImage(image);
		playerImageView.setFitWidth(60);
		playerImageView.setFitHeight(60);
		target.setGraphic(playerImageView);
		
	}
	
	
	
	public void setImage(int row, int col, String imageName){
		/*		ImageView playerImageView = new ImageView();
		playerImageView.setImage(image);
		playerImageView.setFitWidth(60);
		playerImageView.setFitHeight(60);
		target.setGraphic(playerImageView);
		*/
		Image image = new Image(getClass().getResourceAsStream(imageName));

		ImageView card = new ImageView();
		card.setFitWidth(60);
		card.setFitHeight(60);
		card.setImage(image);
		//boardGrid.add(coalPic, i, k);
		//imageViews[row][col] = card;
		//boardGrid.add(pic, i, k);
		makeDroppable(card, "board");
		boardGrid.add(card, row, col);
		//imageViews[row][col].setImage(image);
	}
	
	public void refreshHand(){
	    vbCards.getChildren().remove(hbCards);
	    displayHand();
	}
	
	private void revertTurn(int turns){
        //int turnsToRevert = Integer.parseInt(selectedValue.toString());
        if(GameEngine.getTurn() > turns){
            GameEngine.getGameStates().loadState(turns);
        }
	}
	

}