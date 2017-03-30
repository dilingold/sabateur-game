package view;

import java.awt.Color;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Board;
import model.Board.*;
import javafx.stage.Stage;

public class MainView extends Application {
	
	public static int SCENE_WIDTH = 860;
	public static int SCENE_HEIGHT = 600;

	public static void main(String[] args) {
		
		launch(args);

	}
	
	@Override
	public void start(Stage stage) {
		
		WelcomeView welcomeView = new WelcomeView(stage);
		welcomeView.displayView();
		
		stage.show();
		//Board aBoard = new Board.getInstance();
		Board.getInstance().initBoard();
		//aBoard.initBoard();

		Board.getInstance().getGameBoard();
		//System.out.println(aBoard.getGameBoard()[0][0]);

		//Board.getInstance().setGameBoard(1, 1, 5);

		Board.getInstance().printBoard();




	}

}

