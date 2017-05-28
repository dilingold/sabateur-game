package controller;

import java.util.Stack;

public class GameStateOriginator {
    static int turn = 0;
    static int currentPlayerIndex = 0;
    private static int numberOfRegressions = 0;
    static Stack<String> priorStates = new Stack<String>();
    static String lastStateID = new String("-");
    
 
    
    public static void saveState() {
        currentPlayerIndex = GameEngine.getCurrentPlayerIndex();
        String stateID = generateStateID();
        lastStateID = stateID;
        priorStates.push(stateID);
        GameStateCaretaker.saveBoardState(stateID, GameStateMemento.getBoardMemento());
        GameStateCaretaker.savePlayerState(stateID, GameStateMemento.getPlayersMemento());
        GameStateCaretaker.saveHandListState(stateID, GameStateMemento.getHandlistMemento());
        GameStateCaretaker.saveDeckState(stateID, GameStateMemento.getDeckMemento());
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
        String oldStateID = generateStateID(turnsReverted);
        GameStateMemento.setDeck(GameStateCaretaker.getDeckState(oldStateID));
        GameStateMemento.setPlayers(GameStateCaretaker.getPlayerState(oldStateID));
        GameStateMemento.setHand(GameStateCaretaker.getHandListState(oldStateID));
        GameStateMemento.setBoard(GameStateCaretaker.getBoardState(oldStateID));
        GameStateMemento.refreshView();
        numberOfRegressions++;
        
    }

    private static String generateStateID() {
        String stateID = Integer.toString(GameEngine.getTurn()) +";"+ Integer.toString(currentPlayerIndex)
                +";"+ Integer.toString(numberOfRegressions);
        System.out.println("State generated: " + stateID);
        return stateID;
    }

    private static String generateStateID(int turnsReverted) {
        int numberPlayers = GameEngine.getPlayerSize();
        for (int i = 0; i < ((turnsReverted * numberPlayers) - 1); i++) {

            String statediscarded = priorStates.pop();
            System.out.println("State discarded: " + statediscarded);
        }
        String stateID = priorStates.pop();
        System.out.println("State to load generated: " + stateID);
        return stateID;
    }
    public static String getLastStateID(){
        return lastStateID;
    }
}
