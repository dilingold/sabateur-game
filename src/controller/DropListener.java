package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import model.Board;
import model.Player;
import model.cards.PathCard;
import model.cards.Card;

//allows for one component to be dropped on another
public class DropListener extends ActionCardValidator{
	
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
	public boolean drop(DragEvent event, Player currentPlayer, int draggedCardIndex, ImageView target, int row, int col) {
		//for debugging
		//System.out.println(currentPlayer.getHand().getCards().get(draggedCardIndex).getType());

		if(checkMove(currentPlayer.getHand().getCards().get(draggedCardIndex), col, row)) {
					
			if (event.getGestureSource() != target) {
				
				//for debugging
				//System.out.println(Board.getInstance().getGameBoard(row, col).getName());
				//Board.getInstance().printBoard();
				
				Board.getInstance().setGameBoard(col,row, currentPlayer.getHand().getCards().get(draggedCardIndex));
				

				//if the dragged card is a path card, get the correct rotation and image
				if (currentPlayer.getHand().getCards().get(draggedCardIndex).getType() == "path") {
					
					PathCard draggedCard = (PathCard) currentPlayer.getHand().getCards().get(draggedCardIndex);
					String imageName = "/resources/images/cards/" + draggedCard.getName() + "-rotate" + draggedCard.getRotation() + ".png";
					Image image = new Image(getClass().getResourceAsStream(imageName));
					target.setImage(image);
					return true;
					
				}
				
				else {
					
					Card draggedCard = currentPlayer.getHand().getCards().get(draggedCardIndex);
					String imageName = "/resources/images/cards/" + draggedCard.getName() + ".png";
					Image image = new Image(getClass().getResourceAsStream(imageName));
					target.setImage(image);
					return true;
					
				}
				
			}
			
		}
				
		return false;
		
	}

}
