import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	ArrayList<Card> deck;  
	
	//Outputs an array list of Cards formed from two string arrays containing the rank and suit, respectively
	public ArrayList<Card> createDeck() {
		this.deck = new ArrayList<Card>(); 
		String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suits = {"C", "D", "H", "S"};
		for(int i = 0; i < suits.length; i++) {
			for(int j = 0; j < ranks.length; j++) {
				Card card = new Card(0, ranks[j], suits[i]);
				deck.add(card);
			}
		}
		return deck; 
	}
	
	//Uses Collections.shuffle method to randomly sort the array list of Cards 
	public ArrayList<Card> shuffleDeck() {
		Collections.shuffle(deck);
		return deck; 
	}
	
	//Pulls out the last instance of Card in the shuffled array list of Cards
	public Card selectDealCard() {
		return deck.remove(deck.size() - 1); 
	}
}


