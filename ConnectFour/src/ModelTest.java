import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModelTest {
	
	Model empty;
	Model notEmpty;

	@BeforeEach
	void setUp() throws Exception {
		empty = new Model();
		notEmpty = new Model();
		notEmpty.board[0][0] = 'x';
		notEmpty.turn++;
	}

	@Test
	void testClearBoard() {
		boolean equal = true;
		for(int row=5; row>=0; row--) {
    		for(int column=0; column<7; column++) {
    			if (empty.board[column][row] != notEmpty.board[column][row]) {
    				equal = false; break;
    			}
    		}
		}
		
		assertFalse(equal);
		notEmpty.clearBoard();
		equal = true;
		
		for(int row=5; row>=0; row--) {
    		for(int column=0; column<7; column++) {
    			if (empty.board[column][row] != notEmpty.board[column][row]) {
    				// Should never reach
    				equal = false; break;
    			}
    		}
		}
		assertTrue(equal);
	}
	
	@Test
	void testNewGame() {
		assertFalse(notEmpty.turn == 0);
		notEmpty.newGame();
		assertTrue(notEmpty.turn == 0);
	}
	
	@Test
	void testTurn() {
		assertTrue(empty.turn() == 'x');
		assertTrue(notEmpty.turn() == 'o');
	}
	
	@Test
	void testReturnBoard() {
		char[][] ret = notEmpty.returnBoard();
		for(int row=5; row>=0; row--) {
    		for(int column=0; column<7; column++) {
    			assertTrue(ret[column][row] == notEmpty.board[column][row]);
    		}
		}
	}
	
	@Test
	void testPlayPiece() {
		// Test play piece with valid args
		assertTrue(empty.playPiece(0));
		assertTrue(empty.board[0][0] == 'x');
		assertTrue(empty.playPiece(6));
		assertTrue(empty.board[6][0] == 'o');
		assertTrue(empty.playPiece(0));
		assertTrue(empty.board[0][1] == 'x');
		assertTrue(empty.playPiece(6));
		assertTrue(empty.board[6][1] == 'o');
		
		// Test play piece with illegal args
		assertFalse(empty.playPiece(7));
		assertFalse(empty.playPiece(-1));
		empty.playPiece(0);
		empty.playPiece(0);
		empty.playPiece(0);
		empty.playPiece(0);
		assertFalse(empty.playPiece(0));
	}
	
	@Test
	void testGameStateNoWin() {
		assertTrue(empty.gameState() == 'e');
		empty.turn = 42;
		assertTrue(empty.gameState() == 'c');
		
		empty.turn = 0;
		
		// Testing Column Border Cases
		empty.board[0][0] = 'x';
		empty.board[0][1] = 'x';
		assertTrue(empty.gameState() == 'e');
		empty.board[0][2] = 'x';
		assertTrue(empty.gameState() == 'e');
		empty.clearBoard();
		
		// Testing Row Border Cases
		empty.board[0][0] = 'x';
		empty.board[1][0] = 'x';
		assertTrue(empty.gameState() == 'e');
		empty.board[2][0] = 'x';
		assertTrue(empty.gameState() == 'e');
		empty.clearBoard();
		
		// Testing Left Diag Border Cases
		empty.board[6][0] = 'x';
		empty.board[5][1] = 'x';
		assertTrue(empty.gameState() == 'e');
		empty.board[4][2] = 'x';
		assertTrue(empty.gameState() == 'e');
		empty.clearBoard();
		
		// Testing Right Diag Border Cases
		empty.board[0][0] = 'x';
		empty.board[1][1] = 'x';
		assertTrue(empty.gameState() == 'e');
		empty.board[2][2] = 'x';
		assertTrue(empty.gameState() == 'e');
		empty.clearBoard();
		
	}
	
	@Test
	void testGameStateColumnWin() {
		for(int row=5; row>=3; row--) {
    		for(int column=0; column<7; column++) {
    			empty.board[column][row] = 'x';
    			empty.board[column][row-1] = 'x';
    			empty.board[column][row-2] = 'x';
    			empty.board[column][row-3] = 'x';
    			
    			assertTrue(empty.gameState() == 'x');
    			
    			empty.clearBoard();
    		}
		}
	}
	
	@Test
	void testGameStateRowWin() {
		for(int row=5; row>=0; row--) {
    		for(int column=0; column<4; column++) {
    			empty.board[column][row] = 'x';
    			empty.board[column+1][row] = 'x';
    			empty.board[column+2][row] = 'x';
    			empty.board[column+3][row] = 'x';
    			
    			assertTrue(empty.gameState() == 'x');
    			
    			empty.clearBoard();
    		}
		}
	}
	
	@Test
	void testGameStateLeftDiagWin() {
		for(int row=5; row>=3; row--) {
    		for(int column=0; column<4; column++) {
    			empty.board[column][row] = 'x';
    			empty.board[column+1][row-1] = 'x';
    			empty.board[column+2][row-2] = 'x';
    			empty.board[column+3][row-3] = 'x';
    			
    			assertTrue(empty.gameState() == 'x');
    			
    			empty.clearBoard();
    		}
		}
	}
	
	@Test
	void testGameStateRightDiagWin() {
		for(int row=5; row>=3; row--) {
    		for(int column=6; column>=4; column--) {
    			empty.board[column][row] = 'x';
    			empty.board[column-1][row-1] = 'x';
    			empty.board[column-2][row-2] = 'x';
    			empty.board[column-3][row-3] = 'x';
    			
    			assertTrue(empty.gameState() == 'x');
    			
    			empty.clearBoard();
    		}
		}
	}

}
