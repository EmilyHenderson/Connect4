package ics4ustart;
import java.util.Scanner;

import hutchison.grant.Board;
import hutchison.grant.ColorState;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Graphics extends Application {
	
	private static final double BUTTON_HEIGHT = 80;
	private static final double BUTTON_WIDTH = 80;
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
	}
	@Override
	public void start(Stage PrimaryStage) throws Exception {
		
		PrimaryStage.setWidth(500);
		PrimaryStage.setHeight(500);
		PrimaryStage.setTitle("Connect Four");
		
		// Setup constants for the Board
		final int ROWS = 7; 
		final int COLS = 7;

				// create the board
		Board board = new Board(ROWS, COLS);
		board.display();
				
		int column = 0;
		

		CellState currentPlayer = CellState.P1;
		
		
		//Layout 1
		Label label1 = new Label("Welcome to connect four, Would you like to play?");
		VBox layout1 = new VBox();
		Button buttonMain = new Button();
		buttonMain.setText("Play Game");
		buttonMain.setStyle("-fx-base: #0000ff;");
		layout1.getChildren().addAll(label1, buttonMain);
		
		//Layout 2
		VBox layout2 = new VBox();
		NewButton[] selectors = new NewButton[7];
		HBox selectBox = new HBox();
		selectBox.setPadding(new Insets(20, 20, 20, 20));
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		Button[][] slots = new Button[7][7];
		
		
		// setup slots
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				slots[i][j] = new Button();
				slots[i][j].setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
				slots[i][j].setStyle("-fx-base: #000000;");
			}
		}
		
		// GRID PANE
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				grid.add(slots[i][j], j, i);
			}
		}
		
		layout2.getChildren().add(selectBox);
		layout2.getChildren().add(grid);
		Scene scene2 = new Scene(layout2);
		
		// add all of the column selector buttons
		for (int i=0; i < 7; i++) {
			selectors[i] = new NewButton(i);
			selectors[i].setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
			selectBox.getChildren().add(selectors[i]);
			
		}
		
		// Setup Button actions
		for (int i=0; i < 7; i++) {
			
			selectors[i].setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(((NewButton) event.getSource()).getCol());

			}
		});
		
			// test 
			selectors[0].setOnAction( new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					for(int i=0; i< board.getRows(); i++) {
						for(int j=0; j<board.getCols(); j++) {
							if(slots[i][j] == ColourState.BlACK && currentPlayer == CellState.P1) {
								return slots[i][j] = ColourState.RED;
							}
						}
						if(slots[i][j] == ColourState.BlACK && currentPlayer == CellState.P2) {
							return slots[i][j] = ColourState.BLUE;
						}
					}
				}
			});
			
			
		}
		
		// Main Button
		buttonMain.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				PrimaryStage.setScene(scene2);
			}
		}
		);
	
		/**private void updateBoard(board, slots) {
			for (int i = 0; i < board.getRows(); i++) {
				for (int j = 0; j < board.getCols(); j++) {
					switch (board.getColor(i, j)) {
					case RED:
						slots[i][j].setStyle("-fx-base: #ff0000;");
						break;
					case BLUE:
						slots[i][j].setStyle("-fx-base: #0000ff;");
						break;
					case YELLOW:
						slots[i][j].setStyle("-fx-base: #ffff00;");
						break;
					case GREEN:
						slots[i][j].setStyle("-fx-base: #00ff00;");
						break;
					}
				}
			}
		}*/
		
		Scene Scene1 = new Scene(layout1, 200, 200);
		PrimaryStage.setScene(Scene1);
		PrimaryStage.show();
	}
	
	private static int getColumn() {
		boolean valid = false;
		int column = 0;
		Scanner in = new Scanner(System.in);

		System.out.print("Which Column (1-7):");
		column = Integer.parseInt(in.nextLine().trim());
		return column;

	}


}
