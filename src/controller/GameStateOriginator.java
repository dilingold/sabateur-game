package controller;

import java.util.Stack;

import model.cards.Card;

public class GameStateOriginator {
    static int turn = 0;
    static int currentPlayerIndex = 0;
    private static int numberOfRegressions = 0;
    static Stack<Integer> priorStates = new Stack<Integer>();
    
    
 
    
    public static void saveState() {
        currentPlayerIndex = GameEngine.getCurrentPlayerIndex();
        int stateID = generateStateID();
        priorStates.push(stateID);
        GameStateCaretaker.saveBoardState(stateID, GameStateMemento.getBoardState());
        GameStateCaretaker.savePlayerState(stateID, GameStateMemento.getPlayerState());
        GameStateCaretaker.saveHandListState(stateID, GameStateMemento.getPlayerHands());
        GameStateCaretaker.saveDeckState(stateID, GameStateMemento.saveDeck());
        // For debugging: printout of saved board state
       /* System.out.println("State " + stateID + " saved. BoardState: ");
        for (int r = 0; r < boardStates.get(stateID).getRows(); r++) {
            for (int c = 0; c < boardStates.get(stateID).getCols(); c++) {
                System.out.println("Cardname: " + boardStates.get(stateID).getCard(r, c).getName());                
                if (boardStates.get(stateID).getCard(r, c).getType() == "path") {
                    if (((PathCard) boardStates.get(stateID).getCard(r, c)).getIsToxic() == true) {
                        System.out.println("This card is toxic");
                    }

                }
            }
        }*/

    }

    public void loadState(int turnsReverted) {

       
        int oldTurn = (GameEngine.getTurn() - turnsReverted);
        GameStateMemento.setTurn(oldTurn);
        int oldStateID = generateStateID(turnsReverted);
        GameStateMemento.setDeck(GameStateCaretaker.getDeckState(oldStateID));
        GameStateMemento.setPlayers(GameStateCaretaker.getPlayerState(oldStateID));
        GameStateMemento.setHand(GameStateCaretaker.getHandListState(oldStateID));
        GameStateMemento.setBoard(GameStateCaretaker.getBoardState(oldStateID));
        GameStateMemento.refreshView();
        numberOfRegressions++;
     // For debugging: printout of loaded board state
        /*System.out.println("State " + oldStateID + " loaded. BoardState: ");
        for (int r = 0; r < boardStates.get(oldStateID).getRows(); r++) {
            for (int c = 0; c < boardStates.get(oldStateID).getCols(); c++) {
                System.out.println("Cardname: " + boardStates.get(oldStateID).getCard(r, c).getName());
                if (boardStates.get(oldStateID).getCard(r, c).getType() == "path") {
                    if (((PathCard) boardStates.get(oldStateID).getCard(r, c)).getIsToxic() == true) {
                        System.out.println("This card is toxic");
                    }

                }
            }
        }*/
    }

    private static int generateStateID() {
        String stateID = Integer.toString(GameEngine.getTurn()) + Integer.toString(currentPlayerIndex)
                + Integer.toString(numberOfRegressions);
        return Integer.parseInt(stateID);
    }

    private static int generateStateID(int turnsReverted) {
        // String stateID =
        // Integer.toString(turn-turnsReverted)+Integer.toString(currentPlayerIndex)+Integer.toString(numberOfRegressions);
        int numberPlayers = GameEngine.getPlayerSize();
        for (int i = 0; i < ((turnsReverted * numberPlayers) - 1); i++) {
            int statediscarded = priorStates.pop();
        }
        String stateID = Integer.toString(priorStates.pop());
        return Integer.parseInt(stateID);
    }
}
