import java.util.Scanner;
import java.util.ArrayList;

public class BlackjackSolitaire {
	Deck deck;
	Player player; 
	Board board;
	ArrayList<Integer> inputNums;
	
	//Initializes an instance of the BlackjackSolitaire class
	public BlackjackSolitaire() {
		inputNums = new ArrayList<Integer>(); 
	}
	
	//Error check on whether the user's input is an integer from 1 to 20 and whether the chosen position is preoccupied
	public boolean checkUserInput(int position) {
		if(position < 1 || position > 20) {
			System.out.println("Input Error: Your input is outside of the range. Please re-enter a position number from 1 to 20");
			return true;		
		} else if(inputNums.contains(position)) {
			System.out.println("Input Error: Your input represents a preoccupied position number");
			return true;
		} else {
			return false; 
		}
	}
	
	//Initializes the game and continuously prompts for user input until all 16 positions are filled 
	public void play() {
		player = new Player(); 
		Scanner userInput = new Scanner(System.in); 
		System.out.println("What is your name?"); 
		player.name = userInput.nextLine();
		System.out.println("Welcome to Blackjack Solitaire, " + player.name + "!");
		System.out.println(); 
		
		board = new Board(); 
		board.display(); 
		
		deck = new Deck();
		deck.createDeck();
		deck.shuffleDeck();
		
		while(board.checkGameStatus()) {
			System.out.println(); 
			Card dealCard = deck.selectDealCard(); 
			System.out.println("Here is your deal card: " + dealCard.cardValue); 
			System.out.println("Enter the open position number to make a move: ");
			player.position = userInput.nextInt();
			while(checkUserInput(player.position)) {
				System.out.println("Enter the open position number to make a move: ");
				player.position = userInput.nextInt();
			} 
			inputNums.add(player.position); 
			board.updateBoard(player.position, dealCard); 
			System.out.println(); 
			board.updateDisplay();
		}
		
		System.out.println("Thank you for playing, " + player.name + " and be sure to visit us again."); 
		
		userInput.close(); 
	}
}
