package controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.EventObserver;
import view.GameView;

//listens for when the user selects the play game button from the AddPlayerView
//displays the GameView
public class PlayGameListener {

	private static EventObserver observable = new EventObserver(true);
	private static final Integer SetTimer = 30; // Have this in options perhaps?
	private static IntegerProperty STARTTIME = new SimpleIntegerProperty(SetTimer);
	protected static Timeline timeline = new Timeline();

	public void changeScene(Stage stage) {
		try {
			observable.deleteObservers();
		} catch (Exception e){

		}
		PlayerController players = PlayerController.getInstance();
		//GameView gameView = new GameView(stage);
		GameView observer = new GameView(stage);
		observable.addObserver(observer);
		//observable.setTimerStatus(true);
		observer.displayView(players.playerCount(), players.getPlayerList());

	}

	public static void startTimer(javafx.scene.control.Label timeLabel) {
		if(observable.getTimerStatus() == true) {
			timeLabel.textProperty().bind(STARTTIME.asString());
			STARTTIME.set(SetTimer);
			timeline.getKeyFrames().add(
					new KeyFrame(Duration.seconds(SetTimer+1), event -> {
						System.out.println("Timer Ended: " + timeLabel.textProperty().getValue());
						observable.setTimerStatus(true);
					}, new KeyValue(STARTTIME, 0))
			);
			timeline.setCycleCount(1);
			timeline.playFromStart();
		}
	}

	public static void updateTime() {
		timeline.stop();
		STARTTIME.set(SetTimer);
		timeline.playFromStart();
	}
	public static void stopTime() {
		timeline.stop();
		timeline.setCycleCount(0);
		observable.setTimerStatus(false);
		System.out.println("play again screen said stop");

	}

}
