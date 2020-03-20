
public class Card {
	String rank;
	String suit; 
	String cardValue; 
	int displayNum;
	
	//initializes a new instance of the Card class 
	public Card(int displayNum, String rank, String suit) {
		this.displayNum = displayNum; 
		this.rank = rank;
		this.suit = suit;
		cardValue = rank + suit; 
	}
}
