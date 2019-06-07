package ics4ustart;

import java.util.Random;

public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;
	
	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public boolean isValid(int x, int y) {
		return (x >= 0 && x < rows) && (y >= 0 && y < cols);
	}
	/**
	 * places piece on board
	 * @param player
	 * @param col
	 * @return
	 */
	public int piece(CellState player, int col) {
		col = col - 1;
		for (int i = getRows() - 1; i >= 0; i--) {
			if (board[i][col].getState() == CellState.EMPTY) {
				board[i][col].setState(player);
				return i + 1; // return the row
			}

		}
		return 0; // invalid row

	}
	/**
	 * checks for horizontal winner
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean HorizontalWinner(int row, int col) {
		int counter = 1;
		// adjust col and row
		col = col - 1;
		row = row - 1;

		int c = col;

		// look right
		while (c < cols - 1 && board[row][c].getState() == board[row][c + 1].getState()) {
			counter++;
			c++;
		}

		// look left
		while (c > 0 && board[row][c].getState() == board[row][c - 1].getState()) {
			counter++;
			c--;
		}

		return (counter == 4);
	}
	/**
	 * checks for diagonal winner up
	 * @param col
	 * @param row
	 * @param player
	 * @return
	 */
	public boolean diagonalwinnerUp(int col, int row, CellState player) {
		int counter = 1;
		// adjust col and row
		col = col - 1;
		row = row - 1;
		int c = col;
		int r = row;
		
		while (c < (cols - 1) && (r>0) && board[r][c].getState() == board[r - 1][c + 1].getState()) {
			counter++;
			c++;
			r--;
		}
		r = row;
		c = col;
		while (c > 0 && r < (rows-1) && board[r][c].getState() == board[r + 1][c - 1].getState()) {
			counter++;
			c--;
			r++;

		}

		return (counter == 4);
	}
	/**
	 * checks for diagonal winner down NOT WORKING
	 * @param col
	 * @param row
	 * @param player
	 * @return
	 */
	public boolean diagonalwinnerDown(int col, int row, CellState player) {
	/*	int counter = 1;
		// adjust col and row
		col = col - 1;
		row = row - 1;
		int c = col;
		int r = row;
		// check right
		while (c > 0 && r < (rows-1) && board[r][c].getState() == board[r - 1][c + 1].getState()) {
			counter++;
			c++;
			r--;
		}
		r = row;
		c = col;
		while (c < (cols-1) && r >0 && board[r][c].getState() == board[r + 1][c - 1].getState()) {
			counter++;
			c--;
			r++;

		}

		return (counter == 4);*/
		return false;
	}
	/**
	 * checks for Vertical Winner
	 * @param col
	 * @param player
	 * @return
	 */
	public boolean VerticalWinner(int col, CellState player) {
		int counter = 0;
		// adjust col
		col = col - 1;

		for (int i = 0; i < getCols(); i++) {

			if (board[i][col].getState() == player) {
				counter++; // found player at this location
			} else {
				counter = 0; // found different player or empty cell
			}

		}
		return (counter == 4);

	}



	void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
}
