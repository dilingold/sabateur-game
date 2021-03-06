package controller;

import model.Player;
import view.MainView;
public class GameEngine {

	private MainView mainView;
	private static PlayerController players;
	private static int currentPlayerIndex;
	private static int turn;
	private static GameStateOriginator gameStateOriginator;

	public static void main(String[] args) {

		new GameEngine();

	}

	public GameEngine() {
	    gameStateOriginator = new GameStateOriginator();

		DeckFactory deck = new DeckFactory();
		deck.addAllCards();
		deck.Shuffle();

		players = PlayerController.getInstance();
		currentPlayerIndex = 0;
		mainView = new MainView();
		mainView.launchApp(this);

	}



	public static int getCurrentPlayerIndex() {

		return currentPlayerIndex;

	}
	
	public static void setCurrentPlayerIndex(int index) {
		
		currentPlayerIndex = index;
		
	}

	public Player nextPlayer() {

		if (currentPlayerIndex == players.getPlayerList().size()-1) {
		    turn++;
			currentPlayerIndex = 0;
		}
		else {
		    currentPlayerIndex++;
		}
		//save game state for this part of this turn
		GameStateOriginator.saveState();
		return getCurrentPlayer();

	}

	public Player getCurrentPlayer() {

		return players.getPlayerByPosition(currentPlayerIndex);

	}
	public Player getPrevPlay() {

		return players.getPlayerByPosition(currentPlayerIndex);

	}
	public static int getPlayerSize(){
	    return PlayerController.getPlayersSize();
	}
	
	
	public static Player getNextPlayer() {

		if (currentPlayerIndex == getPlayerSize()-1) {
		    

			return players.getPlayerByPosition(0);

		}

		else return players.getPlayerByPosition(currentPlayerIndex+1);

	}
	
	public static int getTurn(){
	    return turn;
	}

    public static void setTurn(int oldTurn) {
        turn = oldTurn;
    }
    public static GameStateOriginator getGameStates(){
        return gameStateOriginator;
    }


}

