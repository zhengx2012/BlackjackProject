package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.*;

public class BlackjackTableApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~ Welcome to the Blackjack Table ~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		runGame(kb);
		kb.close();
	}

	private static void runGame(Scanner kb) {
		// Creates new deck and hand for the player and dealer
		Deck newDeck = new Deck();
		Player player = new Player();
		Hand playerHand = player.getHand();
		Dealer dealer = new Dealer();
		Hand dealerHand = dealer.getHand();

		// Player will get two cards added to their hand as they enter the game
		playerHand.addCard(newDeck.dealCard());
		playerHand.addCard(newDeck.dealCard());
		System.out.println("\nYour " + playerHand);
		System.out.println("\tYou have " + playerHand.getValueOfHand());

		// Dealer will get two cards as well
		// Need to only show one hand
		dealerHand.addCard(newDeck.dealCard());
		dealerHand.addCard(newDeck.dealCard());
		System.out.println("\nThe dealer's " + dealerHand);
		System.out.println("\tThe dealer has " + dealerHand.getValueOfHand());

		// If either the play or the dealer gets 21 at the start of the game, its an
		// automatic win
		if (AutoWin(playerHand, dealerHand) == true) {
			runGame(kb);
		}

		// Player can choose to hit or stay
		hitStay(playerHand, dealerHand, newDeck, kb);
		// Dealer is automatically going to hit if he is under 17
//		dealerHitStay(dealerHand, newDeck, kb);
		// Need to create a method to end the hand and start new one if player or dealer
		// wins

		winner(playerHand, dealerHand, kb);

	}

	public static void hitStay(Hand playerHand, Hand dealerHand, Deck newDeck, Scanner kb) {

		int hitOrStay = 0;
		// Dont need a do while loop because you have a recursive statement in the first
		// if statement
		if (playerHand.getValueOfHand() < 21) {
			System.out.println("\nWhat would you like to do?" + " \n1. Hit" + " \n2. Stay");
			if (playerHand.getValueOfHand() < 21) {
				hitOrStay = kb.nextInt();
				if (hitOrStay == 1) {
					playerHand.addCard(newDeck.dealCard());
					System.out.println("Your " + playerHand);
					hitStay(playerHand, dealerHand, newDeck, kb);

					playerBust(playerHand, kb);
				}

				else if (hitOrStay == 2) {
					System.out.println("\nYour final hand is: " + playerHand);
					winner(playerHand, dealerHand, kb);
				}

				else {
					hitStay(playerHand, dealerHand, newDeck, kb);
				}
			}
			while (dealerHand.getValueOfHand() < 17) {
				dealerHand.addCard(newDeck.dealCard());
			}
			dealerBust(dealerHand);
			System.out.println("The dealer's " + dealerHand);
			runGame(kb);
		}
	}

//	public static void dealerHitStay(Hand dealerHand, Deck newDeck, Scanner kb) {
//		while (dealerHand.getValueOfHand() < 17) {
//			dealerHand.addCard(newDeck.dealCard());
//		}
//		dealerBust(dealerHand);
//		System.out.println("The dealer's " + dealerHand);
//		runGame(kb);
//	}

	private static void playerBust(Hand playerHand, Scanner kb) {
		if (playerHand.getValueOfHand() > 21) {
			System.out.println("\nYou Busted!");
			runGame(kb);
		}

	}

	private static void dealerBust(Hand dealerHand) {
		if (dealerHand.getValueOfHand() > 21) {
			System.out.println("\nThe Dealer Busted!");
		}

	}

	private static boolean AutoWin(Hand playerHand, Hand dealerHand) {
		if (playerHand.getValueOfHand() == 21) {
			System.out.println("\nCongratulations you have won with 21!");
			return true;
		} else if (dealerHand.getValueOfHand() == 21) {
			System.out.println("\nThe dealer won!");
			return true;
		}
		return false;
	}

	private static void winner(Hand playerHand, Hand dealerHand, Scanner kb) {
		if ((dealerHand.getValueOfHand() > playerHand.getValueOfHand()) || (dealerHand.getValueOfHand() == 21)) {
			System.out.println("\nThe dealer has won!");
			System.out.println("\tThe dealer has " + dealerHand.getValueOfHand());
			runGame(kb);
		}

		else if ((playerHand.getValueOfHand() > dealerHand.getValueOfHand()) || (playerHand.getValueOfHand() == 21)) {
			System.out.println("\nYou have won!");
			System.out.println("\tYou have " + dealerHand.getValueOfHand());
			runGame(kb);
		}

	}
}
