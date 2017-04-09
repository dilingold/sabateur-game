package controller;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

//allows a card to be dragged
public class DragCardListener {
	
	public void dragCard(Button btn, Event event) {
		
		Dragboard db = btn.startDragAndDrop(TransferMode.COPY_OR_MOVE);
		ClipboardContent content = new ClipboardContent();
		content.putString(btn.getText());
		db.setContent(content);
		event.consume();
		
	}

}
