package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import model.Player;

public class DropListener {
	
	public void dragOver(DragEvent event, ImageView target) {
		
		if (event.getGestureSource() != target) {
			
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			
		}
		
		event.consume();
		
	}
	
	public void drop(DragEvent event, Player currentPlayer, int draggedCardIndex, ImageView target) {
		
		if (event.getGestureSource() != target) {
		
			String draggedCardName = currentPlayer.getHand().getCards().get(draggedCardIndex).getName();
			String imageName = "/resources/images/cards/" + draggedCardName + ".png";
			Image image = new Image(getClass().getResourceAsStream(imageName));
			target.setImage(image);
		
		}
		
	}

}
