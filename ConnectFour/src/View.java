package projectjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

	final int width=7;
    final int height=6;
    char[][] board;
    
    
    public static void main(String args[])throws IOException{
    	System.out.println("Yes");
    }
    
    public void drawTextBoard() {
    	for(int i=0; i<board.length; i++) {
    		for(int j=0; j<board[0].length; j++) {
    			if(board[i][j] == 0) {
                    System.out.print("[ ] ");
    			}
    			else {
    				System.out.print(board[i][j]+"  ");
    			}
    		}
    		System.out.println();
    	}
    }
	
}
