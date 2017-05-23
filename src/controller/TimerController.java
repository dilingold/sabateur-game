package controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;
import model.EventObserver;

import java.util.Observable;
import java.util.Observer;

public class TimerController implements Observer {

    private EventObserver weatherUpdate ;
    private static final Integer SetTimer = 5; // Have this in options perhaps?
    private static boolean status = false;
    private static IntegerProperty STARTTIME = new SimpleIntegerProperty(SetTimer);

    private static EventObserver observable = new EventObserver(null);
    private static TimerController observer = new TimerController();

    @Override
    public void update(Observable observable, Object arg)
    {
        weatherUpdate = (EventObserver) observable;
        System.out.println("Timer Has Changed Status to "+weatherUpdate.getTimerStatus());
    }

    public void TimerListener() {

        observable.addObserver(observer);
        observable.setTimerStatus(true);
        observable.setTimerStatus(false);
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