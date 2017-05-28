package controller;

import java.util.Stack;

public class GameStateOriginator {
    static int turn = 0;
    static int currentPlayerIndex = 0;
    private static int numberOfRegressions = 0;
    static Stack<String> priorStates = new Stack<String>();
    static String lastStateID = new String("-");

    // save state:
    // asks GameStateMemento to get most recent states of objects
    // and sends them to the caretaker for saving.
    public static void saveState() {
        currentPlayerIndex = GameEngine.getCurrentPlayerIndex();
        String stateID = generateStateID();
        lastStateID = stateID;
        priorStates.push(stateID);
        GameStateCaretaker.saveBoardState(stateID, GameStateMemento.getBoardMemento());
        GameStateCaretaker.savePlayerState(stateID, GameStateMemento.getPlayersMemento());
        GameStateCaretaker.saveHandListState(stateID, GameStateMemento.getHandlistMemento());
        GameStateCaretaker.saveDeckState(stateID, GameStateMemento.getDeckMemento());

    }

    // loads state:
    // gets the desired prior state from caretaker
    // and sends it to memento, who update the relevant classes
    public void loadState(int turnsReverted) {
        int oldTurn = (GameEngine.getTurn() - turnsReverted);
        GameStateMemento.setTurn(oldTurn);
        String oldStateID = generateStateID(turnsReverted);
        GameStateMemento.setDeckMemento(GameStateCaretaker.getDeckState(oldStateID));
        GameStateMemento.setPlayersMemento(GameStateCaretaker.getPlayerState(oldStateID));
        GameStateMemento.setHandMemento(GameStateCaretaker.getHandListState(oldStateID));
        GameStateMemento.setBoardMemento(GameStateCaretaker.getBoardState(oldStateID));
        GameStateMemento.refreshView();
        numberOfRegressions++;

    }
    //load specific state:
    //takes a turn, player and number of regressions, loads
    //state that matches these conditions.
    public static void loadState(int turn, int player, int regressions){
        String stateID = Integer.toString(turn) + ";" + Integer.toString(player) + ";"
                + Integer.toString(regressions);
        GameStateMemento.setTurn(turn);
        GameStateMemento.setDeckMemento(GameStateCaretaker.getDeckState(stateID));
        GameStateMemento.setPlayersMemento(GameStateCaretaker.getPlayerState(stateID));
        GameStateMemento.setHandMemento(GameStateCaretaker.getHandListState(stateID));
        GameStateMemento.setBoardMemento(GameStateCaretaker.getBoardState(stateID));
        GameStateMemento.refreshView();
        numberOfRegressions++;
    }
    

    // generates relevant ID based off current turn, which player's going, and
    // how many times undo turn has been used.
    private static String generateStateID() {
        String stateID = Integer.toString(GameEngine.getTurn()) + ";" + Integer.toString(currentPlayerIndex) + ";"
                + Integer.toString(numberOfRegressions);
        System.out.println("State generated: " + stateID);
        return stateID;
    }

    // generate state id for loading:
    // takes in number of turns to go back, and takes states off the prior state
    // stack until correct state is found, then returns that state's ID.
    private static String generateStateID(int turnsReverted) {
        int numberPlayers = GameEngine.getPlayerSize();
        for (int i = 0; i < ((turnsReverted * numberPlayers) - 1); i++) {

            String statediscarded = priorStates.pop();
            // System.out.println("State discarded: " + statediscarded);
        }
        String stateID = priorStates.pop();
        System.out.println("State to load generated: " + stateID);
        return stateID;
    }

    public static String getLastStateID() {
        return lastStateID;
    }
}
