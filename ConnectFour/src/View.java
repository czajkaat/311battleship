package projectjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

	final int width=7;
    final int height=6;
    char[][] board;
    int moves;
    
    //this must be taken out before turning in
    public View(){
        board=new char[width][height];
        moves=0;
    }
    
    //don't actually need this main method, take out before end
    public static void main(String args[])throws IOException{
    	System.out.println("Yes");
    	View c4=new View();
    	c4.drawTextBoard();
    }
    
    public int getMove(int column) {
		
    	return column;
    }
    
    //The following method draws the board for the text
    public void drawTextBoard() {
    	for(int row=0; row<height; row++) {
    		for(int column=0; column<width; column++) {
    			if(board[column][row] == 0) {
                    System.out.print("[ ] ");
    			}
    			else {
    				System.out.print(board[column][row]+"  ");
    			}
    		}
    		System.out.println();
    	}
    	
    	for(int i=1; i<width+1; i++) {
    		System.out.print(" " + i + "  ");
    	}
    	System.out.println();
    }
	
}
