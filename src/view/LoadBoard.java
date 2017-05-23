package view;

import controller.DistributeGold;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.stage.Stage;
import model.Board;
import model.PlayerD;
import model.cards.ActionCard;
import model.cards.Card;
import model.cards.PathCard;
import model.cards.PowerToolDecorator;
import model.cards.SuperPowerToolDecorator;

public class LoadBoard {

    ImageView[][] imageView = new ImageView[][](); 
    //GameView.getImageView();
    
    
    
    public boolean drop(Stage stage, DragEvent event, PlayerD currentPlayer, int draggedCardIndex, 
            ImageView target, ImageView[][] imageViews, int row, int col) {
        
        //for debugging
        //System.out.println(currentPlayer.getHand().getCards().get(draggedCardIndex).getType());
        if(validator.checkMove(currentPlayer.getHand().getCards().get(draggedCardIndex), row, col)) {

            if (event.getGestureSource() != target) {

                Card card;
                boolean minersWin = false;

                //if the dragged card is a path card, get the correct rotation and image
                if (currentPlayer.getHand().getCards().get(draggedCardIndex).getType() == "path") {
                    
                    if (currentPlayer.hasPowerTool() && !currentPlayer.hasSuperPowerTool()) {
                        card = new PowerToolDecorator(currentPlayer.getHand().getCards().get(draggedCardIndex)).doAction(row, col);
                        currentPlayer.removePowerTool();
                        gameView.removePowerToolImage();
                        playCard(card, target, currentPlayer, draggedCardIndex);
                        minersWin = validator.checkMinersWin(row, col);
                    }
                    
                    
                    else {
                        card = currentPlayer.getHand().getCards().get(draggedCardIndex).doAction(row, col);
                        playCard(card, target, currentPlayer, draggedCardIndex);
                        
                    }
                    

                }

                else if (currentPlayer.getHand().getCards().get(draggedCardIndex).getType() == "action") {
                    
                    card = (ActionCard) currentPlayer.getHand().getCards().get(draggedCardIndex);
                    Card boardCard = Board.getInstance().getCard(row, col);
                    String imageName;
                    if(((ActionCard) card).getEffect() == "enable") {
                        imageName = "/resources/images/cards/" + boardCard.getName() 
                                + "-rotate" + ((PathCard)boardCard).getRotation() + ".png";
                        ((PathCard) boardCard).setIsToxic(false);
                    }
                    else {
                        imageName = "/resources/images/cards/" + card.getName() + ".png";
                        ((PathCard) boardCard).setIsToxic(true);
                    }
                    Image image = new Image(getClass().getResourceAsStream(imageName));
                    target.setImage(image);
                    currentPlayer.getHand().discardCard(draggedCardIndex);
                    currentPlayer.drawCard();
                    
                    if(validator.checkSabateursWin()) {
                        
                        DistributeGold.sabateurs();
                        new PlayAgainView(stage).displayView("sabateurs");
                        
                    }
                    
                    return true;

                }

            }

        }
                
        return false;

   } 
}
