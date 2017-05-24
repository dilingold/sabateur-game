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

import java.util.Observable;
import java.util.Observer;

//listens for when the user selects the play game button from the AddPlayerView
//displays the GameView
public class PlayGameListener implements Observer{

	private static EventObserver observable = new EventObserver(null);
	private EventObserver timerUpdate ;

	private static final Integer SetTimer = 5; // Have this in options perhaps?
	private static boolean status = false;
	private static IntegerProperty STARTTIME = new SimpleIntegerProperty(SetTimer);
	
	public void changeScene(Stage stage) {

		PlayerController players = PlayerController.getInstance();
		//GameView gameView = new GameView(stage);
		GameView observer = new GameView(stage);
		observable.addObserver(observer);
		//observable.setTimerStatus(true);
		observer.displayView(players.playerCount(), players.getPlayerList());

	}
	@Override
	public void update(Observable observable, Object arg)
	{
		timerUpdate = (EventObserver) observable;
		System.out.println("PlayGameListener Has Changed Status to "+timerUpdate.getTimerStatus());
		System.out.println("Next Turn!!!");
	}

	public static Timeline startTimer(javafx.scene.control.Label timeLabel) {

		timeLabel.textProperty().bind(STARTTIME.asString());
		STARTTIME.set(SetTimer);
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.seconds(SetTimer+1), event -> {
					System.out.println("Timer Ended: " + timeLabel.textProperty().getValue());
					observable.setTimerStatus(true);
				}, new KeyValue(STARTTIME, 0))
		);
		//timeline.setCycleCount( Timeline.INDEFINITE );
		timeline.playFromStart();
		return timeline;
	}

	public static void updateTime(Timeline timeline) {
		timeline.stop();
		STARTTIME.set(SetTimer);
		timeline.playFromStart();
	}

}
