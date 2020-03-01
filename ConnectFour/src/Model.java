import java.util.Arrays;

public class Model {
	final int width = 7;
	final int height = 6;
	char[][] board;
	int turn; 
	
	
	public Model() {
		board = new char[width][height];
		turn = 0; 
	}
	
	public void clearBoard() {
		for(char[] row:board)
			Arrays.fill(row, 'e');
	}
	
	public void newGame() {
		clearBoard();
		turn = 0;
	}
	
	public char turn() {
		char player;
		if(turn % 2 == 0)
			player = 'x';
		else
			player = 'o';
		
		return player;
	}
	
	public char gameState() {
		char player = turn();
		//Row Win
		for(int row = 0;row < 6 ;row++) {
			for(int column = 0;column < 4; column++) {
				if(board[column][row] != 'e') {
					if(board[column][row] == board[column+1][row])
						if(board[column][row] == board[column+2][row])
							if(board[column][row] == board[column+3][row])
								return player;
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
								return player;
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
								return player;
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
								return player;
				}
			}
		}
		
		if(turn == 42) {
			return 'c';
		}
		
		return 'e';
	}
	
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
	
	private void playHere(int column, int row) {
		char player = turn();
		
		board[column][row] = player;
	}
	
	public char[][] returnBoard() {
		return board.clone();
	}

}
