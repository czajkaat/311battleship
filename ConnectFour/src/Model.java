import java.util.Arrays;

public class Model {
	char[][] board;
	int turn; 
	
	
	public Model() {
		board = new char[7][6];
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
