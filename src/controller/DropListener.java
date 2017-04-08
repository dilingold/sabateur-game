package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import model.Board;
import model.Player;
import model.cards.Card;

public class DropListener extends ActionCardValidator{
	
	public void dragOver(DragEvent event, ImageView target) {
		
		if (event.getGestureSource() != target) {
			
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			
		}
		
		event.consume();
		
	}
	
	public boolean drop(DragEvent event, Player currentPlayer, int draggedCardIndex, ImageView target, int row, int col) {
		
		System.out.println(currentPlayer.getHand().getCards().get(draggedCardIndex).getType());

		if(checkMove(currentPlayer.getHand().getCards().get(draggedCardIndex), col, row)){
			Board.getInstance().setGameBoard(col,row, currentPlayer.getHand().getCards().get(draggedCardIndex));
			if (event.getGestureSource() != target) {
				System.out.println(Board.getInstance().getGameBoard(row, col).getName());
				Board.getInstance().setGameBoard(col,row, currentPlayer.getHand().getCards().get(draggedCardIndex));
				Board.getInstance().printBoard();

				String draggedCardName = currentPlayer.getHand().getCards().get(draggedCardIndex).getName();
				String imageName = "/resources/images/cards/" + draggedCardName + ".png";
				Image image = new Image(getClass().getResourceAsStream(imageName));
				target.setImage(image);
				return true;

			}
		}
		else
			System.out.println("ITS FALSE");
		return false;



		
	}

}
