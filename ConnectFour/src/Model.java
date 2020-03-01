import java.util.Arrays;

/**
 * @author smort
 *
 */
public class Model {
	final int width = 7;
	final int height = 6;
	char[][] board;
	int turn; 
	
	
	/**Constructor
	 * Initializes board, fills it with 'e's and sets turn to 0
	 * 
	 */
	public Model() {
		board = new char[width][height];
		clearBoard();
		turn = 0; 
	}
	
	/**
	 * Sets all board positions to 'e' 
	 */
	public void clearBoard() {
		for(char[] row:board)
			Arrays.fill(row, 'e');
	}
	
	/** Sets the board to empty and resets turn counter.
	 * 
	 */
	public void newGame() {
		clearBoard();
		turn = 0;
	}
	
	/**Gives the current player turn
	 * @return the char of the current player
	 * 'x' = player 1 (goes first)
	 * 'o' = player 2
	 */
	public char turn() {
		char player;
		if(turn % 2 == 0)
			player = 'x';
		else
			player = 'o';
		
		return player;
	}
	
	/**gameState gives the current state or winner of the current board
	 * @return current game state. 'e' if in progress, 'c' for a game with no winners
	 * 			'x' for a player 1 win, 'o' for a player 2 win
	 */
	public char gameState() {
		//Row Win
		for(int row = 0;row < 6 ;row++) {
			for(int column = 0;column < 4; column++) {
				if(board[column][row] != 'e') {
					if(board[column][row] == board[column+1][row])
						if(board[column][row] == board[column+2][row])
							if(board[column][row] == board[column+3][row])
								return board[column][row];
				}
			}
		}
		//Column Win
		for(int column = 0;column < 7 ;column++) {
			for(int row = 0;row < 3; row++) {
				if(board[column][row] != 'e') {
					if(board[column][row] == board[column][row+1])
						if(board[column][row] == board[column][row+2])
							if(board[column][row] == board[column][row+3])
								return board[column][row];
				}
			}
		}
		//Diagonal Right Win
		for(int column = 0;column <4; column++) {
			for(int row = 0;row <3; row++) {
				if(board[column][row] != 'e') {
					if(board[column][row] == board[column+1][row+1])
						if(board[column][row] == board[column+2][row+2])
							if(board[column][row] == board[column+3][row+3])
								return board[column][row];
				}
			}
		}
		//Diagonal Left Win
		for(int column = 3;column < 7; column++) {
			for(int row = 0;row < 3; row++) {
				if(board[column][row] != 'e') {
					if(board[column][row] == board[column-1][row+1])
						if(board[column][row] == board[column-2][row+2])
							if(board[column][row] == board[column-3][row+3])
								return board[column][row];
				}
			}
		}
		
		if(turn == 42) {
			return 'c';
		}
		
		return 'e';
	}
	
	/**Plays the next piece at the given position
	 * @param column is where the next piece will be played
	 * @return true if the move is possible, false if the given column is full
	 */
	public boolean playPiece(int column) {
		if(column<0 || column >6)
			return false;
		for(int row = 0;row < 6;row++) {
			if(board[column][row]=='e') {
				playHere(column, row);
				turn++;
				return true;
			}
		}
		
		return false; 
	}
	
	/**Plays a piece at a specific x,y position. 
	 * @param column
	 * @param row
	 */
	private void playHere(int column, int row) {
		char player = turn();
		
		board[column][row] = player;
	}
	
	/**Returns a clone of the current game board
	 * @return char[][] copy of the current board (width,height)
	 */
	public char[][] returnBoard() {
		return board.clone();
	}

}
