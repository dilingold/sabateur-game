package view;

import controller.PlayGameListener;
import controller.PlayerController;
import controller.RestartGame;
import controller.TimerController;
import javafx.animation.*;
import javafx.application.*;
import javafx.beans.property.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import view.GameView;

public class PauseView {
    private final double BLUR_AMOUNT = 10;

    private final Effect frostEffect =
            new BoxBlur(BLUR_AMOUNT, BLUR_AMOUNT, 3);

    private final ImageView background = new ImageView();
    private final StackPane layout = new StackPane();

    public void start(final Stage stage, Double X, Double Y, Double W, Double H) {
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
                    if (KeyCode.ESCAPE == event.getCode()) {
                        //resumeTime();
                        stage.close();
                        //Platform.exit();
                    }
                }
    );
        createContent.Title title = new createContent.Title("P A U S E D");

        createContent.MenuItem newGame = new createContent.MenuItem("NEW GAME");
        createContent.MenuItem loadGame = new createContent.MenuItem("LOAD GAME");
        createContent.MenuItem itemExit = new createContent.MenuItem("EXIT");

        createContent.MenuBox vbox = new createContent.MenuBox(
                newGame,
                itemExit
        );

        layout.getChildren().setAll(background, title, vbox);
        layout.setAlignment(title, Pos.BOTTOM_LEFT);
        //layout.setAlignment(title, Pos.CENTER);
        layout.setStyle("-fx-background-color: null");

        Scene scene = new Scene(
                layout,
                W, H,
                Color.TRANSPARENT
        );

        newGame.setOnMouseClicked(event -> {
            RestartGame restartGame = new RestartGame();

            restartGame.restartBoard();
            restartGame.restartDeck();
            restartGame.restartPlayer();

            GameView gameView = new GameView(stage);
            gameView.displayView(PlayerController.getInstance().playerCount(), PlayerController.getInstance().getPlayerList());
            stage.close();

        });

        itemExit.setOnMouseClicked(event -> {
            Platform.exit();
        });

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setX(X);
        stage.setY(Y);
        stage.setWidth(W);
        stage.setHeight(H);
        stage.show();

        background.setImage(copyBackground(stage));
        background.setEffect(frostEffect);
    }

    // copy a background node to be frozen over.
    private Image copyBackground(Stage stage) {
        final int X = (int) stage.getX();
        final int Y = (int) stage.getY();
        final int W = (int) stage.getWidth();
        final int H = (int) stage.getHeight();

        try {
            java.awt.Robot robot = new java.awt.Robot();
            java.awt.image.BufferedImage image = robot.createScreenCapture(new java.awt.Rectangle(X, Y, W, H));

            return SwingFXUtils.toFXImage(image, null);
        } catch (java.awt.AWTException e) {
            System.out.println("The robot of doom strikes!");
            e.printStackTrace();

            return null;
        }
    }

    // create some content to be displayed on top of the frozen glass panel.
    private Label createContent() {
        Label label = new Label("Create a new question for drop shadow effects.\n\nDrag to move\n\nDouble click to close");
        label.setPadding(new Insets(10));

        label.setStyle("-fx-font-size: 15px; -fx-text-fill: green;");
        //label.setMaxWidth(250);
        label.setWrapText(true);

        return label;
    }
}
