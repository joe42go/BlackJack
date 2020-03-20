
public class Board {
	
	Card[][] board; 
	
	//Initializes a new instance of the Board class, which is a 2D array of Card class objects
	//Assigns an incremental sequential number to the Card object starting at 1 
	public Board() {
		board = new Card[5][5]; 
		
		int counter = 1;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				board[i][j] = new Card(counter, null, null);
				counter++; 
			}
		}
		
		for(int i = 2; i < 4; i++) {
			for(int j = 1; j < 4; j++) {
				board[i][j] = new Card(counter, null, null);
				counter++; 
			}
		}
		
		for(int j = 0; j < 4; j++ ) {
			board[4][j] = new Card(counter, null, null);
			counter++; 
		}
	}
	
	//Displays the value of instance variable "displayNum" of each Card object in Board class 
	public void display() {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(board[i][j].displayNum + "    ");
			}
			System.out.println();
		}
		
		
		for(int i = 2; i < 4; i++) {
			System.out.print("     "); 
			for(int j = 1; j < 4; j++) {
				System.out.print(board[i][j].displayNum + "   ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.print("Display Cards: ");
		for(int j = 0; j < 4; j++ ) {
			System.out.print(board[4][j].displayNum + "   "); 
		}
		System.out.println(); 
	}
	
	//Update the rank and suit of the Card matching the position number chosen by the player 
	public void updateBoard(int position, Card dealCard) {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				if(board[i][j].displayNum == position) {
					board[i][j] = dealCard; 
				}
			}
		}
		
		for(int i = 2; i < 4; i++) {
			System.out.print("     "); 
			for(int j = 1; j < 4; j++) {
				if(board[i][j].displayNum == position) {
					board[i][j] = dealCard; 
				}
			}
		}

		for(int j = 0; j < 4; j++ ) {
			if(board[4][j].displayNum == position) {
				board[4][j] = dealCard; 
			}
		}
	}
	
	//Re-displays the Board class with the updated rank and suit values of the chosen card and re-displays Board
	public void updateDisplay() {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				if(board[i][j].displayNum == 0) {
					System.out.printf("%5s", board[i][j].cardValue);
				} else {
					System.out.printf("%5s", board[i][j].displayNum);
				}
			}
			System.out.println();
		}
		
		
		for(int i = 2; i < 4; i++) {
			System.out.print("        "); 
			for(int j = 1; j < 4; j++) {
				if(board[i][j].displayNum == 0) {
					System.out.print(board[i][j].cardValue + "   ");
				} else {
					System.out.print(board[i][j].displayNum + "   ");
				}
			}
			System.out.println(); 
		}
		
		System.out.println();
		System.out.print("Display Cards: ");
		for(int j = 0; j < 4; j++ ) {
			if(board[4][j].displayNum == 0) {
				System.out.print(board[4][j].cardValue + "   ");
			} else {
				System.out.print(board[4][j].displayNum + "   "); 
			}
		}
	}
	
	//Checks to see if all 16 positions have been occupied and if so, jumps to displaying the score
	public boolean checkGameStatus() {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				if(board[i][j].displayNum != 0) {
					return true;
				}
			}
		}
		
		for(int i = 2; i < 4; i++) {
			for(int j = 1; j < 4; j++) {
				if(board[i][j].displayNum != 0) {
					return true;
				}
			}
		}
		
		System.out.println(); 
		System.out.println("Calculating you score....");
		Score output = new Score(); 
		System.out.println("Your score is " + output.scoreTotal(board)); 
		return false; 
	}

}
