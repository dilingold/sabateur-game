package controller;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;
import model.Player;
import view.GameView;

public class TimerController {

    private GameView gameView;
    private static final Integer SetTimer = 5; // Have this in options perhaps?
    private static IntegerProperty STARTTIME = new SimpleIntegerProperty(SetTimer);
    protected static Timeline timeline = new Timeline();

    public TimerController(GameView gameView) {
        this.gameView = gameView;
    }

    public void startTimer(javafx.scene.control.Label timeLabel) {
        timeLabel.textProperty().bind(STARTTIME.asString());
        STARTTIME.set(SetTimer);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(SetTimer+1), event -> {
                    System.out.println("Timer Ended: " + timeLabel.textProperty().getValue());
                    timeline.stop();
                    gameView.nextTurn();
                }, new KeyValue(STARTTIME, 0))
        );
        timeline.setCycleCount(1);
        timeline.playFromStart();
    }

    public void updateTime() {
        timeline.stop();
        STARTTIME.set(SetTimer);
        timeline.playFromStart();
    }
    public void stopTime() {
        timeline.stop();
        //timeline.setCycleCount(0);
        System.out.println("play again screen said stop");

    }

    public void resumeTime() {
        timeline.play();
    }

    public Animation.Status getTime() {

        System.out.println(timeline.getCurrentTime());
        System.out.println(timeline.getStatus());
        return timeline.getStatus();
    }
}
