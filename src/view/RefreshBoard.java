package view;

import controller.PlayGameListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Board;
import model.cards.Card;
import model.cards.PathCard;

public class RefreshBoard {

	public RefreshBoard() {

	}

	ImageView[][] imageView;
	// GameView.getImageView();

	public void refreshView() {

		for (int i = 0; i < Board.getInstance().getRows(); i++) {
			for (int j = 0; j < Board.getInstance().getCols(); j++) {
				Card card = Board.getInstance().getCard(i, j);
				if (card.getType() != null && card.getType() != "board") {
					System.out.println("cardType = "+ card.getType());
					String imageName;
					if (card.getType() == "path" && card.getName() != "start") {
						imageName = "/resources/images/cards/" + card.getName() + "-rotate"
								+ ((PathCard) card).getRotation() + ".png";
						System.out.println("imageName = "+imageName+", image location = "+i+", "+j);
					} else {
						imageName = "/resources/images/cards/" + card.getName() + ".png";
					}
					PlayGameListener.getGameView().setImage(j, i, imageName);
				}
			}
		}
	}
	/*
	 * //for debugging
	 * //System.out.println(currentPlayer.getHand().getCards().get(
	 * draggedCardIndex).getType());
	 * if(ActionCardValidator.checkMove(currentPlayer.getHand().getCards().get(
	 * draggedCardIndex), row, col)) {
	 * 
	 * if (event.getGestureSource() != target) {
	 * 
	 * Card card; boolean minersWin = false;
	 * 
	 * //if the dragged card is a path card, get the correct rotation and image
	 * if (currentPlayer.getHand().getCards().get(draggedCardIndex).getType() ==
	 * "path") {
	 * 
	 * if (currentPlayer.hasPowerTool() && !currentPlayer.hasSuperPowerTool()) {
	 * card = new PowerToolDecorator(currentPlayer.getHand().getCards().get(
	 * draggedCardIndex)).doAction(row, col); currentPlayer.removePowerTool();
	 * gameView.removePowerToolImage(); playCard(card, target, currentPlayer,
	 * draggedCardIndex); minersWin = validator.checkMinersWin(row, col); }
	 * 
	 * 
	 * else { card =
	 * currentPlayer.getHand().getCards().get(draggedCardIndex).doAction(row,
	 * col); playCard(card, target, currentPlayer, draggedCardIndex);
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * else if
	 * (currentPlayer.getHand().getCards().get(draggedCardIndex).getType() ==
	 * "action") {
	 * 
	 * card = (ActionCard)
	 * currentPlayer.getHand().getCards().get(draggedCardIndex); Card boardCard
	 * = Board.getInstance().getCard(row, col); String imageName;
	 * if(((ActionCard) card).getEffect() == "enable") { imageName =
	 * "/resources/images/cards/" + boardCard.getName() + "-rotate" +
	 * ((PathCard)boardCard).getRotation() + ".png"; ((PathCard)
	 * boardCard).setIsToxic(false); } else { imageName =
	 * "/resources/images/cards/" + card.getName() + ".png"; ((PathCard)
	 * boardCard).setIsToxic(true); } Image image = new
	 * Image(getClass().getResourceAsStream(imageName)); target.setImage(image);
	 * currentPlayer.getHand().discardCard(draggedCardIndex);
	 * currentPlayer.drawCard();
	 * 
	 * if(validator.checkSabateursWin()) {
	 * 
	 * DistributeGold.sabateurs(); new
	 * PlayAgainView(stage).displayView("sabateurs");
	 * 
	 * }
	 * 
	 * return true;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return false;
	 * 
	 * }
	 */
}
