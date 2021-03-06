
public class Controller {

	public static void main(String args[]) {
		// Determine which view to use
		int viewChoice = 0;
		if (args[0].equals("1")) {
			System.out.println("Text View");
			viewChoice = 1;
		} else if (args[0].equals("2")) {
			System.out.println("GUI View");
			viewChoice = 2;
		}
		
		// Call on View to start up game with viewChoice
		View display = new View();
		
		// Initiate variables in Model class
		Model game = new Model();
		game.newGame();
		char turn = game.turn();
		display.setBoard(game.returnBoard());
		
		// Display the current board
		if (viewChoice == 2) {
			display.drawWindow();
		}
		
		// Game Loops until winner is determined
		while(game.gameState() == 'e') {
			display.setBoard(game.returnBoard());
			
			// Display the current board
			if (viewChoice == 1) {
				display.drawTextBoard();
				
			} else {
				display.repaint();
			}
			
			
			// Get user input
			int column = -1;
			if (viewChoice == 1) {
				column = display.getMove() - 1;
			} else {
				while(display.getColumnChoice() == -1) {
					System.out.println();
					column = display.getColumnChoice();
				}
			}
			
			
			// Update game board
			if (!game.playPiece(column)) {
				// Display error
			}
			
			display.resetColumnChoice();
		}
		
		// Display winner
		display.setBoard(game.returnBoard());
		if (viewChoice == 1) {
			display.drawTextBoard();
			
		} else {
			display.repaint();
		}
		char winner = game.gameState();
		
		display.displayWinner(winner);
	}
}
