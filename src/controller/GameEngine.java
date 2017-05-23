package controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.*;
import javafx.util.Duration;
import model.PlayerD;
import view.GameView;
import view.MainView;

import java.awt.*;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class GameEngine {

	private MainView mainView;
	private GameView gameView;
	private static PlayerController players;
	private static int currentPlayerIndex;
	private static final Integer SetTimer = 5; // Have this in options perhaps?

	//run game
	public static void main(String[] args) {

		new GameEngine();

	}

	public GameEngine() {

		DeckBuilder deckBuilder = new DeckBuilder();
		deckBuilder.addAllCards();
		deckBuilder.Shuffle();

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


	//set the next player's turn
	public PlayerD nextPlayer() {

		if (currentPlayerIndex == players.getPlayerList().size()-1) {

			currentPlayerIndex = 0;

		}

		else currentPlayerIndex++;

		return getCurrentPlayer();

	}

	public PlayerD getCurrentPlayer() {

		return players.getPlayerByPosition(currentPlayerIndex);

	}
	public PlayerD getPrevPlay() {

		return players.getPlayerByPosition(currentPlayerIndex);

	}
	
	public static PlayerD getNextPlayer() {

		if (currentPlayerIndex == players.getPlayerList().size()-1) {

			return players.getPlayerByPosition(0);

		}

		else return players.getPlayerByPosition(currentPlayerIndex+1);

	}

	public static Timeline updateTime(javafx.scene.control.Label timeLabel, PlayerD currentPlayer) {
		IntegerProperty STARTTIME = new SimpleIntegerProperty(SetTimer);
		timeLabel.textProperty().bind(STARTTIME.asString());
		STARTTIME.set(SetTimer);
		Timeline timeline = new Timeline();

		timeline.getKeyFrames().add(
						new KeyFrame(Duration.seconds(SetTimer+1),
										new KeyValue(STARTTIME, 0))
		);
		//timeline.setCycleCount( Timeline.INDEFINITE );
		timeline.playFromStart();
		return timeline;
	}


}

