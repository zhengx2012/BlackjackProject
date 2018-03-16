package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;

public class BlackjackTableApp {

	public static void main(String[] args) {
		Player player = new Player();
		Hand playerHand = player.getHand();
		Dealer dealer = new Dealer();
		Hand dealerHand = dealer.getHand();
		
		runGame();
	}

	private static void runGame() {
		// TODO Auto-generated method stub
		
	}

}
