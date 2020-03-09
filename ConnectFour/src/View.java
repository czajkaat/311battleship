package testyboi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class View extends JFrame{

	final int width=7;
    final int height=6;
    char[][] board;
    int moves;
    JPanel p = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JLabel c4Label = new JLabel("Connect 4");
    JLabel nameLabel = new JLabel("By: Chris Santos, Sean Morton, Adrian Czajka");
    char[][] charArray;
    
    //This method gets the board from the other two classes
    public char[][] getBoard() {
    	return board;
    }
    
    //This method sets the board.
    public void setBoard(char[][] b) {
    	board = b;
    }
    
    //This method creates the window.
    public void drawWindow() {
    	this.setSize(800, 800);
    	this.setTitle("Connect 4 Game");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	charArray = board;    	
    	addComps();
    	this.setVisible(true);
    }
    
    //This method adds the components to the window, in order to paint the board.
    public void addComps() {
    	connectComponent cc = new connectComponent ();
    	cc.setPreferredSize(new Dimension(600,700));
    	cc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	labelPanel.setLayout(new GridLayout(2,1));
    	labelPanel.setPreferredSize(new Dimension(700, 100));
    	c4Label.setHorizontalAlignment(SwingConstants.CENTER);
    	nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	labelPanel.add(c4Label);
    	labelPanel.add(nameLabel);
    	cc.add(boardPanel);
    	this.add(cc, BorderLayout.NORTH);
    	this.add(labelPanel, BorderLayout.SOUTH);
    }
    
    
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
    
	//This method simply displays the winner.
    public void displayWinner(char c) {
    	if(c == 'c') {
    		System.out.println("Cats Game");
    	} else {
    		System.out.println( c + " Wins!!");
    	}
    }
    
    //Class to assist with painting the GUI for the connect4 board
    public class connectComponent extends JComponent{
    	int x;
    	int y;
  
    	public void paint (Graphics g) {
    		for(int row=height-1; row>=0; row--) {
        		for(int column=0; column<width; column++) {
        			if(board[column][row] == 'e' || board[column][row] == 'o' ||board[column][row] == 'x') {
        				g.setColor(Color.BLACK);
        				g.drawRect(x, y, 100, 100);
            			x = 100*column + 30;
            			y = 100*row + 30;
            			g.setColor(Color.WHITE);
            			g.fillRect(x+1, y+1, 99, 99);
        			}
        			
        			if(board[column][row] == 'x') {
        				g.setColor(Color.RED);
        				g.fillOval(x, y, 100, 100);
        			}
        			else if(board[column][row] == 'o') {
        				g.setColor(Color.YELLOW);
        				g.fillOval(x, y, 100, 100);
        			}
        		}
    		}
    	}
    }
    
}

