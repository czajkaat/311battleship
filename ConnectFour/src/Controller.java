
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
		char[][] gameBoard = game.getBoard();
		int turn = 1;
		// Game Loops until winner is determined
		while(!game.hasWinner())) {
			display.board = 
			
			// Display the current board
			if (viewChoice == 1) {
				display.drawTextBoard();
			}
			
			// Display which player's turn
			if (turn % 2 == 0) {
				// Player 2's turn
				
			} else {
				//Player 1's turn
				
			}
			
			// Get user input
			
			
			// Update game board
			
		}
		
		// Display winner
		
	}
}
