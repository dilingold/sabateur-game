package controller;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import model.Board;
import model.Player;
import model.cards.PathCard;
import model.cards.PersonalCard;
import model.cards.XPathCard;
import view.GameView;
import view.PlayAgainView;
import model.cards.ActionCard;
import model.cards.Card;

//allows for one component to be dropped on another
public class DropListener {

	private ActionCardValidator validator;
	private GameView gameView;
	
	public DropListener(GameView gameView) {
		
		this.gameView = gameView;
		
	}

	public void dragOver(DragEvent event, ImageView target) {

		if (event.getGestureSource() != target) {

			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

		}

		event.consume();

	}
	
	public void dragOver(DragEvent event, Label target) {

		if (event.getGestureSource() != target) {

			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

		}

		event.consume();

	}

	/*
	 * when a card is dropped on the board, it goes through a validation process, and if it is
	 * valid, the board is updated to reflect the move
	 */
	public boolean drop(Stage stage, DragEvent event, Player currentPlayer, int draggedCardIndex, 
			ImageView target, ImageView[][] imageViews, int row, int col) {
		
		validator = new ActionCardValidator();
		
		//for debugging

		if(validator.checkMove(currentPlayer.getHand().getCards().get(draggedCardIndex), row, col)) {

			if (event.getGestureSource() != target) {

				Card card;
				boolean minersWin = false;

				//if the dragged card is a path card, get the correct rotation and image
				if (currentPlayer.getHand().getCards().get(draggedCardIndex).getType() == "path") {
					
					if (currentPlayer.hasPowerTool() && !currentPlayer.hasSuperPowerTool()) {
						
						card = new XPathCard(0);
						usePowerTool(row, col, card);
						currentPlayer.removePowerTool();
						gameView.removePowerToolImage();
						playCard(card, target, currentPlayer, draggedCardIndex);
						minersWin = validator.checkMinersWin(row, col);
					}
					
					else if(currentPlayer.hasSuperPowerTool()) {
						
						card = new XPathCard(0);
						minersWin = useSuperPowerTool(row, col, card, imageViews, currentPlayer, draggedCardIndex);
						currentPlayer.removeSuperPowerTool();
						gameView.removeSuperPowerToolImage();
						
					}
					
					else {
						card = currentPlayer.getHand().getCards().get(draggedCardIndex);
						Board.getInstance().playCard(row, col, card);
						playCard(card, target, currentPlayer, draggedCardIndex);
						minersWin = validator.checkMinersWin(row, col);
						
					}
					
					
					if(minersWin) {
						
						DistributeGold.currentPlayer(currentPlayer);
						distributeGold("miners");
						new PlayAgainView(stage).displayView("miners");
						
					}
					
					else if(validator.checkSabateursWin()) {
						
						distributeGold("sabateurs");
						new PlayAgainView(stage).displayView("sabateurs");
						
					}
									
					return true;

				}

				else if (currentPlayer.getHand().getCards().get(draggedCardIndex).getType() == "action") {
					
					card = (ActionCard) currentPlayer.getHand().getCards().get(draggedCardIndex);
					Card boardCard = Board.getInstance().getCard(row, col);
					String imageName;
					if(((ActionCard) card).getEffect() == "enable") {
						System.out.println("enable card");
						imageName = "/resources/images/cards/" + boardCard.getName() 
								+ "-rotate" + ((PathCard)boardCard).getRotation() + ".png";
						((PathCard) boardCard).setIsToxic(false);
						((PathCard) boardCard).setIsInfested(false);
						((PathCard) boardCard).setIsBlocked(false);
					}
					else if(((ActionCard) card).getEffect() == "search") {
						imageName = "/resources/images/cards/" + boardCard.getName() + ".png";
						System.out.println("hi..........");
					}
					else {
						System.out.println("disable card");
						imageName = "/resources/images/cards/" + card.getName() + ".png";
						if (((ActionCard) card).getName() == "Toxic Card")
							((PathCard) boardCard).setIsToxic(true);
						if (((ActionCard) card).getName() == "Rat")
							((PathCard) boardCard).setIsInfested(true);
						if (((ActionCard) card).getName() == "Road Block") {
							System.out.println("setting block path to true");
							((PathCard) boardCard).setIsBlocked(true);
						}
					}
					Image image = new Image(getClass().getResourceAsStream(imageName));
					target.setImage(image);
					currentPlayer.getHand().discardCard(draggedCardIndex);
					currentPlayer.drawCard();
					
					if(validator.checkSabateursWin()) {
						
						distributeGold("sabateurs");
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
		
		validator = new ActionCardValidator();
		currentPlayer.getHand().discardCard(draggedCardIndex);
		currentPlayer.drawCard();
		
		if(validator.checkSabateursWin()) {
			
			distributeGold("sabateurs");
			new PlayAgainView(stage).displayView("sabateurs");
			
		}
		
		return true;

	}
	
	// when a card is dropped on a player, if it is a personal card and a legal move,
	// discard card, draw new card, check if sabateurs won and return true
	public boolean drop(Stage stage, DragEvent event, Player currentPlayer, Player targetPlayer, int draggedCardIndex, Label target) {
		
		validator = new ActionCardValidator();
		PersonalCardValidator personalCardValidator = new PersonalCardValidator();
		
		if(!(currentPlayer.getHand().getCards().get(draggedCardIndex).getType() == "personal")) {
			
			return false;
			
		}
		
		PersonalCard card = (PersonalCard)currentPlayer.getHand().getCards().get(draggedCardIndex);
		if(personalCardValidator.checkMove(card, currentPlayer, targetPlayer)) {
			
			if (card.getName() == "power tool") {
				
				if (targetPlayer.hasPowerTool()) {
					givePowerTool(targetPlayer);
					gameView.setSuperPowerToolImage(targetPlayer);
					
				}
				
				else {
					
					if (!targetPlayer.hasSuperPowerTool()) {
				
						givePowerTool(targetPlayer);
						gameView.setPowerToolImage(targetPlayer);
						
					}
					
				}
				
			}
			
			else if (card.getName() == "heist") {
				
				new PlanHeist().playCard(currentPlayer, targetPlayer);
				
			}
			
			else if (card.getName() == "expose") {
				
				new ExposeSabateur().playCard(currentPlayer, targetPlayer);
				
			}

			currentPlayer.getHand().discardCard(draggedCardIndex);
			currentPlayer.drawCard();
			
			if(validator.checkSabateursWin()) {
				
				distributeGold("sabateurs");
				new PlayAgainView(stage).displayView("sabateurs");
				
			}
			
			return true;
			
		}
		
		return false;

	}
	
	public void givePowerTool(Player targetPlayer) {
		
		if (targetPlayer.hasPowerTool()) {
			targetPlayer.removePowerTool();
			targetPlayer.giveSuperPowerTool();
			
		}
		
		else {
			
			if (!targetPlayer.hasSuperPowerTool()) {
		
				targetPlayer.givePowerTool();
				
			}
			
		}
		
	}
	
	public void usePowerTool(int row, int col, Card card) {
		
		Board.getInstance().playCard(row, col, card);
		
	}
	
	public boolean useSuperPowerTool(int row, int col, Card card, 
			ImageView[][] imageViews, Player currentPlayer, int draggedCardIndex) {
		
		boolean minersWin = false;
		
		Card cardUp;
		Card cardDown;
		Card cardRight;
		Card cardLeft;
		Board.getInstance().playCard(row, col, card);
		playCard(card, imageViews[row][col], currentPlayer, draggedCardIndex);
		
		ActionCardValidator validator = new ActionCardValidator();
		 if (validator.checkSuperPowerMove(cardRight=new XPathCard(0), row, col+1)) {
			Board.getInstance().playCard(row, col+1, cardRight);
			playCard(cardRight, imageViews[row][col+1], currentPlayer, draggedCardIndex);
			minersWin = validator.checkMinersWin(row, col+1);
		 }
		if (validator.checkSuperPowerMove(cardLeft=new XPathCard(0), row, col-1)) {
			Board.getInstance().playCard(row, col-1, cardLeft);
			playCard(cardLeft, imageViews[row][col-1], currentPlayer, draggedCardIndex);
			minersWin = validator.checkMinersWin(row, col-1);
		}
		if (validator.checkSuperPowerMove(cardDown=new XPathCard(0), row+1, col)) {
			Board.getInstance().playCard(row+1, col, cardDown);
			playCard(cardDown, imageViews[row+1][col], currentPlayer, draggedCardIndex);
			minersWin = validator.checkMinersWin(row+1, col);
		}
		if (validator.checkSuperPowerMove(cardUp=new XPathCard(0), row-1, col)) {
			Board.getInstance().playCard(row-1, col, cardUp); 
			playCard(cardUp, imageViews[row-1][col], currentPlayer, draggedCardIndex);
			minersWin = validator.checkMinersWin(row-1, col);
		}
		
		return minersWin;
		
	}
	
	public void playCard(Card card, ImageView target, Player currentPlayer, int draggedCardIndex) {
		
		String imageName = "/resources/images/cards/" + card.getName() + "-rotate" + ((PathCard) card).getRotation() + ".png";
		Image image = new Image(getClass().getResourceAsStream(imageName));
		target.setImage(image);
		currentPlayer.getHand().discardCard(draggedCardIndex);
		currentPlayer.drawCard();
		
	}
	
	public void distributeGold(String winners) {
		
		if (winners == "sabateurs")
			DistributeGold.sabateurs();
		else if (winners == "miners")
			DistributeGold.miners();
		DistributeGold.heistedMiners();
		DistributeGold.exposedSabateurs();
		
	}

}