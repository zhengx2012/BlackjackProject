package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;

public class Hand {
	public List<Card> hand;

	public Hand(List<Card> hand) {
		super();
		this.hand = hand;
	}
	
	public void addCard(Card card) { 
		hand.add(card);
		
	}
	
	public Hand getCardsInHand() {
		return null;
	}
	
	public int getValueOfHand() {
		return 0;
		
	}

}
