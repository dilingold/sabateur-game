package view;

import controller.AddPlayerListener;
import controller.ExitListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WelcomeView {
	
	Stage stage;
	
	public WelcomeView(Stage stage) {
		
		this.stage = stage;
		
	}
	
	public void displayView() {
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 85));
		root.setPrefSize(860, 600);
		
		//root.setGridLinesVisible(true);

		try (InputStream is = Files.newInputStream(Paths.get("assets/images/above-adventure-aerial-air.jpg"))) {
			ImageView img = new ImageView(new Image(is));

		}
		catch (IOException e) {
			System.out.println("Couldnt Load Image");
		}


		stage.setTitle("G2 Sabateur");


		WelcomeView.Title title = new WelcomeView.Title("S A B A T E U R");
		title.setId("title-text");

		WelcomeView.MenuItem startGame = new WelcomeView.MenuItem("START GAME");
		startGame.setOnMouseClicked(event -> {
			System.out.println();
		});

		WelcomeView.MenuItem itemExit = new WelcomeView.MenuItem("EXIT");
		//itemExit.setOnMouseClicked(event -> System.exit(0));

		WelcomeView.MenuBox vbox = new WelcomeView.MenuBox(
				startGame,
				new WelcomeView.MenuItem("LOAD GAME"),
				new WelcomeView.MenuItem("LEADERBOARD"),
				itemExit
		);

		root.add(title, 0, 0, 1, 1);
		root.add(vbox,0, 2);

		startGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				AddPlayerListener addPlayerListener = new AddPlayerListener();
				addPlayerListener.changeScene(stage);
			}
		});

		itemExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				ExitListener exitListener = new ExitListener();
				exitListener.closeWindow(stage);
			}
		});
		
		Scene scene = new Scene(root, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);
		stage.setScene(scene);
		scene.getStylesheets().add(MainView.class.getResource("style.css").toExternalForm());
				
	}

	private static class Title extends GridPane {
		public Title(String name) {
			// This is the main heading title box
			Rectangle bg = new Rectangle(250, 60);
			bg.setStroke(Color.WHITE);
			bg.setStrokeWidth(2);
			bg.setFill(null);

			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 50));

			setHalignment(text, HPos.CENTER);
			getChildren().addAll(bg, text);
		}
	}

	private static class MenuBox extends VBox {
		public MenuBox(WelcomeView.MenuItem... items) {
			getChildren().add(createSeparator());

			// Dynamically add separator after each menu item
			for (WelcomeView.MenuItem item : items) {
				getChildren().addAll(item, createSeparator());
				setAlignment(Pos.CENTER);
			}
		}
		private Line createSeparator() {
			Line sep = new Line();
			sep.setEndX(200);
			sep.setStroke(Color.DARKGRAY);
			return sep;
		}
	}

	private static class MenuItem extends StackPane {
		public MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] {
					new Stop(0, Color.DARKVIOLET),
					new Stop(0.1, Color.BLACK),
					new Stop(0.9, Color.BLACK),
					new Stop(1, Color.DARKVIOLET)
			});

			Rectangle bg = new Rectangle(200, 30);
			bg.setOpacity(0.4);

			// Name that appears on the menu Item
			Text text = new Text(name);
			text.setFill(Color.DARKGRAY);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 22));

			// Text is centered
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);

			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
			});

			setOnMouseExited(event -> {
				bg.setFill(Color.BLACK);
				text.setFill(Color.DARKGRAY);
			});

			setOnMousePressed(event -> {
				bg.setFill(Color.DARKVIOLET);
			});

			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});

		}
	}

}
