
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class View {

	final int width=7;
    final int height=6;
    char[][] board;
    int moves;
    
    
    
    
    //This method gets the user input for which column they choose to place their peice
    public int getMove() {
    	Scanner in = new Scanner(System.in);
		int column = in.nextInt();
		System.out.println("Pick a row 1-7: " + column);
    	return column;
    }
    
    //The following method draws the board for the text
    public void drawTextBoard() {
    	for(int row=height-1; row>=0; row--) {
    		for(int column=0; column<width; column++) {
    			if(board[column][row] == 'e') {
                    System.out.print("[ ] ");
    			}
    			else {
    				System.out.print("[" + board[column][row]+"] ");
    			}
    		}
    		System.out.println();
    	}
    	
    	for(int i=1; i<width+1; i++) {
    		System.out.print(" " + i + "  ");
    	}
    	System.out.println();
    }
	
    public void displayWinner(char c) {
    	if(c == 'c') {
    		System.out.println("Cats Game");
    	} else {
    		System.out.println( c + " Wins!!");
    	}
    }
}