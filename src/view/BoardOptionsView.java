package view;

import java.util.ArrayList;
import java.util.List;

import controller.BoardOptionsListener;
import controller.PlayerCountListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BoardOptionsView {
	
	private Stage stage;
	private Spinner<Integer> numRowsSpinner;
	private Spinner<Integer> numColsSpinner;
	private List<HBox> treasurePositionLayouts;
	private List<Spinner<Integer>> treasureRowSpinners;
	private List<Spinner<Integer>> treasureColSpinners;
	
	public BoardOptionsView(Stage stage) {
		
		this.stage = stage;
		treasureRowSpinners = new ArrayList<Spinner<Integer>>();
		treasureColSpinners = new ArrayList<Spinner<Integer>>();
		
	}
	
	public void displayView() {
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 85));
		root.setPrefSize(860, 600);
		
		stage.setTitle("G2 Sabateur");
		
		createContent.Title title = new createContent.Title("S A B A T E U R");

		createContent.subTitle boardSizeSubTitle= new createContent.subTitle("Select Board Size");
		
		createContent.MenuText numRowsText = new createContent.MenuText("Rows");
		createContent.MenuText numColumnsText = new createContent.MenuText("Columns");
		
		numRowsSpinner = new Spinner<>(5, 10, 5, 1);
		numRowsSpinner.setPrefWidth(60);
		
		numColsSpinner = new Spinner<>(5, 10, 5, 1);
		numColsSpinner.setPrefWidth(60);
		
		HBox boardSizeHbox = new createContent.HMenuBox();
		boardSizeHbox.setSpacing(10);
		boardSizeHbox.getChildren().add(numRowsText);
		boardSizeHbox.getChildren().add(numRowsSpinner);
		boardSizeHbox.getChildren().add(numColumnsText);
		boardSizeHbox.getChildren().add(numColsSpinner);
		
		createContent.MenuBox boardSizeVbox = new createContent.MenuBox();
		boardSizeVbox.setSpacing(10);
		boardSizeVbox.getChildren().add(boardSizeSubTitle);
		boardSizeVbox.getChildren().add(boardSizeHbox);
		
		createContent.subTitle treasureSubTitle = new createContent.subTitle("Set Treasure Sites");
		
		createContent.MenuText numTreasuresText = new createContent.MenuText("How many treasures? (3-6)");
		
		Spinner<Integer> numTreasuresSpinner = new Spinner<>(3, 6, 3, 1);
		numTreasuresSpinner.setPrefWidth(60);
		
		HBox numTreasuresHBox = new createContent.HMenuBox();
		numTreasuresHBox.setSpacing(10);
		numTreasuresHBox.getChildren().add(numTreasuresText);
		numTreasuresHBox.getChildren().add(numTreasuresSpinner);
		
		createContent.MenuBox treasureVBox = new createContent.MenuBox();
		treasureVBox.setSpacing(10);
		treasureVBox.getChildren().add(treasureSubTitle);
		treasureVBox.getChildren().add(numTreasuresHBox);
		
		createContent.MenuBox treasurePositionVBox = new createContent.MenuBox();
		treasurePositionVBox.setSpacing(5);
		treasurePositionLayouts = treasurePositionLayouts(3);
		treasurePositionVBox.getChildren().addAll(treasurePositionLayouts);
		
		numTreasuresSpinner.setOnMouseClicked(event -> {
			
			treasurePositionVBox.getChildren().removeAll(treasurePositionLayouts);
			treasurePositionLayouts = treasurePositionLayouts(numTreasuresSpinner.getValue());
			treasurePositionVBox.getChildren().addAll(treasurePositionLayouts);
			
		});
		
		createContent.MenuItem setPlayersBtn = new createContent.MenuItem("SET PLAYERS");
		setPlayersBtn.setOnMouseClicked(event -> {
			
			PlayerCountListener playerCountListener = new PlayerCountListener();
			playerCountListener.changeScene(stage);
			
			int[] treasureRows = new int[numTreasuresSpinner.getValue()];
			int i = 0;
			for (Spinner spinner : treasureRowSpinners) {
				
				treasureRows[i] = (int) spinner.getValue();
				i++;
				
			}
			int[] treasureCols = new int[numTreasuresSpinner.getValue()];
			i = 0;
			for (Spinner spinner : treasureColSpinners) {
				
				treasureCols[i] = (int) spinner.getValue();
				i++;
				
			}
			new BoardOptionsListener().setBoardValues(numRowsSpinner.getValue(), 
					numColsSpinner.getValue(), treasureRows, treasureCols);
			
		});
		
		createContent.MenuItem backBtn = new createContent.MenuItem("BACK");
		backBtn.setOnMouseClicked(event -> {
			
			new WelcomeView(stage).displayView();
			
		});
		
		HBox hbButtons = new HBox();
		hbButtons.getChildren().add(backBtn);
		hbButtons.getChildren().add(setPlayersBtn);
		hbButtons.setPadding(new Insets(0, 0, 0, 0));
		hbButtons.setAlignment(Pos.CENTER_LEFT);
		hbButtons.setSpacing(50);
		
		root.add(title, 0, 0, 1, 1);
		root.add(boardSizeVbox, 0, 2);
		root.add(treasureVBox, 0, 5);
		root.add(treasurePositionVBox, 0, 6);
		root.add(hbButtons, 0, 8, 3, 1);
		
		Scene scene = new Scene(root, MainView.SCENE_WIDTH, MainView.SCENE_HEIGHT);
		stage.setScene(scene);
		
		scene.getStylesheets().add(PlayerCountView.class.getResource("style.css").toExternalForm());
		
	}
	
	public List<HBox> treasurePositionLayouts(int num) {
		
		List<HBox> treasurePositions = new ArrayList<HBox>();
		List<Spinner<Integer>> rows = new ArrayList<Spinner<Integer>>();
		List<Spinner<Integer>> cols = new ArrayList<Spinner<Integer>>();
		
		for (int i = 0; i < num; i++) {
			
			HBox treasurePositionHBox = new HBox();
			createContent.MenuText treasureNumberText = new createContent.MenuText("Treasure " + (i+1) + ": ");
			createContent.MenuText treasureRowText = new createContent.MenuText("Row");
			createContent.MenuText treasureColumnText = new createContent.MenuText("Column");
			
			Spinner<Integer> rowSpinner = new Spinner<>(0, 7, 0, 1);
			rowSpinner.setPrefWidth(60);
			
			rows.add(rowSpinner);
			
			Spinner<Integer> colSpinner = new Spinner<>(0, 7, i, 1);
			colSpinner.setPrefWidth(60);
			
			cols.add(colSpinner);
			
			treasurePositionHBox.setSpacing(10);
			treasurePositionHBox.getChildren().add(treasureNumberText);
			treasurePositionHBox.getChildren().add(treasureRowText);
			treasurePositionHBox.getChildren().add(rowSpinner);
			treasurePositionHBox.getChildren().add(treasureColumnText);
			treasurePositionHBox.getChildren().add(colSpinner);
			
			treasurePositions.add(treasurePositionHBox);
			
		}
		
		treasureRowSpinners = rows;
		treasureColSpinners = cols;
		
		return treasurePositions;
		
	}

}
