package ics4ustart;

import javafx.scene.control.Button;

public class NewButton extends Button {

	private int col;
	
	public NewButton (int c){
		super();

		col = c;
	}

	public int getCol(){
		return col;
	}
	
	@Override
	public String toString(){
		return String.valueOf(String.valueOf(getCol()));
	}
}
