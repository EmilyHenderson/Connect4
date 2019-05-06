 package ics4ustart;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Driver {

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
			if(currentPlayer == CellState.P1) {
				System.out.println("Player one turn");
				column = getColumn();
				board.piece(currentPlayer, column);
				//Horizontal Winner
				if(board.DiagonalWinner(column, currentPlayer)) {
					System.out.println("Player " + currentPlayer + " is a winner!");
					done=true;
				}
				//Vertical Winner
				if (board.VerticalWinner(column,currentPlayer)) {
					System.out.println("Player " + currentPlayer + " is a winner!");
					done=true;
				}
				//Diagonal Winner
				board.HorizontalWinner(column, ROWS);
				board.display();
				currentPlayer = CellState.P2;
			}
			else {
				System.out.println("Player two turn");
				column = getColumn();
				board.piece(currentPlayer, column);
				//Horizontal Winner
				if(board.DiagonalWinner(column, currentPlayer)) {
					System.out.println("Player " + currentPlayer + " is a winner!");
					done=true;
				}
				//Vertical Winner;
				if (board.VerticalWinner(column,currentPlayer)) {
					System.out.println("Player " + currentPlayer + " is a winner!");
					done=true;
				}
				// Diagonal Winner
				board.HorizontalWinner(column, ROWS);
				board.display();
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
