package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;

public class Dealer {
	private Deck deck;
	private Hand hand;

	public Dealer() {
		deck = new Deck();
		hand = new Hand();
	}

	public void hit() {
		deck.dealCard();
	}
	
	public Hand getHand() {
		return hand;
	}

}
