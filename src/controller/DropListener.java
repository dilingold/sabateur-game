package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import model.Player;
import model.cards.PathCard;

public class DropListener {
	
	public void dragOver(DragEvent event, ImageView target) {
		
		if (event.getGestureSource() != target) {
			
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			
		}
		
		event.consume();
		
	}
	
	public void drop(DragEvent event, Player currentPlayer, int draggedCardIndex, ImageView target) {
		
		if (event.getGestureSource() != target) {
		
			PathCard draggedCard = (PathCard) currentPlayer.getHand().getCards().get(draggedCardIndex);
			String imageName = "/resources/images/cards/" + draggedCard.getName() + "-rotate" + draggedCard.getRotation() + ".png";
			Image image = new Image(getClass().getResourceAsStream(imageName));
			target.setImage(image);
		
		}
		
	}

}
