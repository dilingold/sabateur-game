package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import model.Board;
import model.Player;
import model.cards.PathCard;
import view.PlayAgainView;
import model.cards.Card;

//allows for one component to be dropped on another
public class DropListener {

	private ActionCardValidator validator = new ActionCardValidator();

	public void dragOver(DragEvent event, ImageView target) {

		if (event.getGestureSource() != target) {

			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

		}

		event.consume();

	}

	/*
	 * when a card is dropped on the board, it goes through a validation process, and if it is
	 * valid, the board is updated to reflect the move
	 */
	public boolean drop(Stage stage, DragEvent event, Player currentPlayer, int draggedCardIndex, ImageView target, int row, int col) {
		
		//for debugging
		//System.out.println(currentPlayer.getHand().getCards().get(draggedCardIndex).getType());
		Deal deal = new Deal();
		if(validator.checkMove(currentPlayer.getHand().getCards().get(draggedCardIndex), col, row)) {

			if (event.getGestureSource() != target) {

				Board.getInstance().playCard(row,col, currentPlayer.getHand().getCards().get(draggedCardIndex));


				//if the dragged card is a path card, get the correct rotation and image
				if (currentPlayer.getHand().getCards().get(draggedCardIndex).getType() == "path") {

					PathCard draggedCard = (PathCard) currentPlayer.getHand().getCards().get(draggedCardIndex);
					String imageName = "/resources/images/cards/" + draggedCard.getName() + "-rotate" + draggedCard.getRotation() + ".png";
					Image image = new Image(getClass().getResourceAsStream(imageName));
					target.setImage(image);
					currentPlayer.getHand().discardCard(draggedCardIndex);
					deal.drawCard(currentPlayer);
					
					if(validator.checkMinersWin(row, col)) {
						
						new PlayAgainView(stage).displayView("miners");;
						
					}
					
					else if(validator.checkSabateursWin()) {
						
						new PlayAgainView(stage).displayView("sabateurs");
						
					}
									
					return true;

				}

				else {

					Card draggedCard = currentPlayer.getHand().getCards().get(draggedCardIndex);
					String imageName = "/resources/images/cards/" + draggedCard.getName() + ".png";
					Image image = new Image(getClass().getResourceAsStream(imageName));
					target.setImage(image);
					currentPlayer.getHand().discardCard(draggedCardIndex);
					deal.drawCard(currentPlayer);
					
					if(validator.checkSabateursWin()) {
						
						new PlayAgainView(stage).displayView("sabateurs");
						
					}
					
					return true;

				}

			}

		}

		return false;

	}
	
	/*
	 * when a card is dropped on the discard icon, it is removed from the player's hand
	 */
	public boolean drop(Stage stage, DragEvent event, Player currentPlayer, int draggedCardIndex, ImageView target) {
		
		Deal deal = new Deal();
		currentPlayer.getHand().discardCard(draggedCardIndex);
		deal.drawCard(currentPlayer);
		
		if(validator.checkSabateursWin()) {
			
			new PlayAgainView(stage).displayView("sabateurs");
			
		}
		
		return true;

	}

}