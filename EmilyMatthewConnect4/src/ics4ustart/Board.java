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
	
	public int getRows(){
		return rows;
	}
	
	public int getCols(){
		return cols;
	}
	

	public boolean isValid(int x, int y){
		return (x>=0 && x < rows) && (y>=0 && y < cols);
	}
	
	
	public void piece(CellState player, int col) {
		col = col -1;
		for(int i=getRows()-1; i>=0; i--) {
			if(board[i][col].getState()==CellState.EMPTY) {
				board[i][col].setState(player);
				return;
			}
			
		}
		
	}
	
		
	public boolean DiagonalWinner(int col, CellState player) {
		int counter = 0;
		//adjust col
		col = col-1;
		for(int i=0; i<getRows(); i++) {
			for(int c=0; c<getCols(); c++) {
				
				if(board[i][c].getState()==player) {
					counter++;
				}
				else {
					counter=0;
				}
			}
		}
		return (counter==4);
	}
	
	public boolean VerticalWinner(int col, CellState player) {
		int counter = 0;
		// adjust col
		col = col-1;
		
		for(int i=0; i<getCols(); i++) {
			
				if(board[i][col].getState()==player) {
					counter++; // found player at this location
				}
				else {
					counter=0; // found different player or empty cell
				}
				
			}
		return (counter==4);
	
	}
	public void HorizontalWinner(int col, int row) {
		int counter1 = 0;
		int counter2 = 0;
		for(int i=0; i<getCols()-1; i++) {
			for(int c=0; c<getRows()-1; c++) {
				if(board[i][c].getState()==CellState.P1) {
					counter1 +=1;
				}
				if(board[i][c].getState()==CellState.P2) {
					counter2 +=1;
				}
				if(counter1 >=4) {
					System.out.println("Player one Wins!");
					return;
				}
				if(counter2 >=4) {
					System.out.println("Player two Wins!");
					return;
				}
			}
		}
		
	}
	

	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
}
