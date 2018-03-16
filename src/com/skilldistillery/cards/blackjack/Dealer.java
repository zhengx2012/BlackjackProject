package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;

public class Dealer {
	private Deck deck;

	public Dealer() {
		
	}
	
	public Card dealHand() {
		return deck.dealCard();
	}
	
}


