package ics4ustart;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Driver{

	private static final CellState[][] Cell = null;

	public static void main(String[] args) throws InterruptedException {
		// Setup constants for the Board
		final int ROWS = 7; // change
		final int COLS = 7;

		// create the board
		Board board = new Board(ROWS, COLS);
		board.display();

		boolean done = false;
		String value = "";

		int column = 0;

		CellState currentPlayer = CellState.P1;

		while (!done) {
			if (currentPlayer == CellState.P1) {
				System.out.println("Player one turn");
			}
			else {
				System.out.println("Player two turn");
			}
				
				// get a valid column and assign the row variable
				int row = 0;
				while (row <= 0) {
					column = getColumn();
					row = board.piece(currentPlayer, column);
					if (row < 0) {
						System.out.println("Column is full");
					}
				}
				board.display();

				// Horizontal Winner
				if (board.HorizontalWinner(row, column)) {
					System.out.println("Player " + currentPlayer + " is a winner!");
					done = true;
				}
				// Vertical Winner
				if (board.VerticalWinner(column, currentPlayer)) {
					System.out.println("Player " + currentPlayer + " is a winner!");
					done = true;
				}
				// Diagonal Winner
				board.DiagonalWinner(column, row);
				
				if (currentPlayer == CellState.P1) {
					currentPlayer = CellState.P2;
				}
				else {
					currentPlayer = CellState.P1;
					
				}
		}
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
