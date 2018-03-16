package com.skilldistillery.cards.common;

import java.util.Arrays;

public class Card {
	private Suit suit;
	private Rank rank;
	
	private int getValue() {
		return rank.getValue();
	}
	
	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card ");
		builder.append(rank);
		builder.append(" of ");
		builder.append(suit);
		builder.append(".");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	
}
