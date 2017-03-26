package controller;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
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
import view.WelcomeView;

public class createContent {
    public static class Title extends GridPane {
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

    public static class subTitle extends GridPane {
        public subTitle(String name) {
            // This is the main heading title box
            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 20));

            setAlignment(Pos.CENTER);
            getChildren().add(text);
        }
    }

    public static class MenuBox extends VBox {
        public MenuBox(createContent.MenuItem... items) {
            getChildren().add(createSeparator());

            // Dynamically add separator after each menu item
            for (createContent.MenuItem item : items) {
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

    public static class MenuItem extends StackPane {
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
