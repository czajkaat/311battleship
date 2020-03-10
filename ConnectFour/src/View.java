
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
import javax.swing.JButton;


public class View extends JFrame{

	final int width=7;
    final int height=6;
    char[][] board;
    int moves;
    JPanel boardPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
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
    	this.setSize(718, 900);
    	this.setTitle("Connect 4 Game");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	charArray = board;    	
    	addComps();
    	this.setVisible(true);
    }
    
    //This method adds the components to the window, in order to paint the board.
    public void addComps() {
    	connectComponent cc = new connectComponent ();
    	cc.setPreferredSize(new Dimension(500,625));
    	cc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	buttonPanel.setPreferredSize(new Dimension(750, 100));
    	labelPanel.setLayout(new GridLayout(3,1));
    	labelPanel.setPreferredSize(new Dimension(600, 100));
    	c4Label.setHorizontalAlignment(SwingConstants.CENTER);
    	nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	labelPanel.add(c4Label);
    	labelPanel.add(nameLabel);
    	cc.add(boardPanel);
    	compButton();
    	this.add(cc, BorderLayout.NORTH);
    	this.add(buttonPanel, BorderLayout.CENTER);
    	this.add(labelPanel, BorderLayout.SOUTH);
    }
    
    public void compButton() {
    	
    	for (int i = 1; i<width+1; i++) {
    		JButton b = new JButton("Column " + i);
    		b.setPreferredSize(new Dimension(95, 25));
    		buttonPanel.add(b);
    	}
    	
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
    		int row2=height-1;
    		for(int row=0; row<height; row++) {
        		for(int column=0; column<width; column++) {
        			
        			g.setColor(Color.BLACK); 
        			g.drawRect(x, y, 100, 100);
            		x = 100*column;
            		y = 100*row;
            		g.setColor(Color.WHITE);
           			g.fillRect(x+1, y+1, 99, 99);
        			
        			if(board[column][row2] == 'x') {
        				g.setColor(Color.RED);
        				g.fillOval(x, y, 100, 100);
        			}
        			else if(board[column][row2] == 'o') {
        				g.setColor(Color.YELLOW);
        				g.fillOval(x, y, 100, 100);
        			}
        		}
        		row2--;
        		
    		}
    		
    	}
    }
    
    
}

