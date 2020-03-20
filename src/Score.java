
public class Score {
	
	//Converts String rank into an integer
	public int valueCard(Card playerCard) {
		if(playerCard.rank == "J" || playerCard.rank == "Q" || playerCard.rank == "K") {
			return 10; 
		} else {
			return Integer.parseInt(playerCard.rank); 
		}
	}
	
	//Converts the score of the individual hand to its equivalent score integer
	public int scoreHand(int valueSum) {
		int handScore = 0; 
		if(valueSum > 21) {
			handScore = 0; 
		} else if(valueSum == 21) {
			handScore = 7; 
		} else if(valueSum == 20) {
			handScore = 5;
		} else if(valueSum == 19) {
			handScore = 4;
		} else if(valueSum == 18) {
			handScore = 3;
		} else if(valueSum == 17) {
			handScore = 2;
		} else {
			handScore = 1; 
		}
		return handScore; 
	}
	
	//Calculates the total score of collective individuals hands by rows and columns
	public int scoreTotal(Card[][] playerBoard) {
		int totalScore = 0; 
		int valueSum = 0; 
		
		for(int i = 0; i < 2; i++) {
			int aceCounter = 0; 
			for(int j = 0; j < 5; j++) {
				if(valueCard(playerBoard[i][j]) == 1) {
					aceCounter++; 
				}
				valueSum += valueCard(playerBoard[i][j]); 
			}
			while(valueSum < 21 && aceCounter > 0) { 
				if(valueSum + 10 <= 21) {
					valueSum += 10; 
				}
				aceCounter--; 
			}
			totalScore += scoreHand(valueSum); 
			valueSum = 0;
		}
		
		for(int i = 2; i < 4; i++) {
			int aceCounter = 0; 
			for(int j = 1; j < 4; j++) {
				if(valueCard(playerBoard[i][j]) == 1) {
					aceCounter++; 
				}
				valueSum += valueCard(playerBoard[i][j]); 
			}
			while(valueSum > 21 && aceCounter > 0) {
				if(valueSum + 10 <= 21) {
					valueSum += 10; 
				}
				aceCounter--; 
			}
			totalScore += scoreHand(valueSum); 
			valueSum = 0;
		}
		
		for(int j = 1; j < 4; j++) {
			int aceCounter = 0; 
			for(int i = 0; i < 4; i++) {
				if(valueCard(playerBoard[i][j]) == 1) {
					aceCounter++; 
				}
				valueSum += valueCard(playerBoard[i][j]); 
			}
			while(valueSum > 21 && aceCounter > 0) {
				if(valueSum + 10 <= 21) {
					valueSum += 10;
				}
				aceCounter--; 
			}
			totalScore += scoreHand(valueSum); 
			valueSum = 0;
		}
		
		if(checkBlackJack(playerBoard[0][0], playerBoard[1][0])) {
			totalScore += 10; 
		} else {
			for(int i = 0; i < 2; i++) {
				valueSum += valueCard(playerBoard[i][0]); 
			}
			totalScore += scoreHand(valueSum); 
			valueSum = 0;
		}	
		
		if(checkBlackJack(playerBoard[0][4], playerBoard[1][4])) {
			totalScore += 10; 
		} else {
			for(int i = 0; i < 2; i++) {
				valueSum += valueCard(playerBoard[i][4]); 
			}
			totalScore += scoreHand(valueSum); 
		}
		
		return totalScore; 
	}
	
	//Checks if the vertical hand in column 0 and column 1 translates to a blackjack
	public boolean checkBlackJack(Card card1, Card card2) {
		if(card1.rank == "J" || card1.rank == "Q" || card1.rank == "K" || card1.rank == "10") {
			if(card2.rank == "1") {
				return true; 
			}
		} else if(card2.rank == "J" || card2.rank == "Q" || card2.rank == "K" || card2.rank == "10") {
			if(card1.rank == "1") {
				return true; 
			}
		}
		return false; 
	}
}
