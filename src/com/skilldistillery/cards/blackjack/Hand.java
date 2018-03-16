package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.*;

public class Hand {

	public List<Card> hand;

	public Hand() {
		hand = new ArrayList<>();

	}

	public void addCard(Card card) {
		hand.add(card);

	}

	public List<Card> getCardsInHand() {
		return hand;
	}

	public int getValueOfHand() {
		int counter = 0;
		for (Card card : hand) {
			counter += card.getValue();
		}
		return counter;

	}

	public boolean clearHand() {
		if (hand.size() != 0) {
			hand = new ArrayList<Card>();
			return true;
		}
		return false;

	}

	public boolean recieveCards(List<Card> cards) {
		if (cards.size() == 0) {
			return false;
		}
		for (Card card : cards) {
			hand.add(card);
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("hand is ");
		builder.append(hand);
		return builder.toString();
	}

}
