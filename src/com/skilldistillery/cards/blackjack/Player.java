package com.skilldistillery.cards.blackjack;

public class Player {
	public Hand hand;
	public String name;

	public Player(Hand hand, String name) {
		super();
		this.hand = hand;
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}


 