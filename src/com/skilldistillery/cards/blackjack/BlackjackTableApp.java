package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.*;

public class BlackjackTableApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		runGame(kb);
		kb.close();
	}

	private static void runGame(Scanner kb) {
		Deck newDeck = new Deck();
		Player player = new Player();
		Hand playerHand = player.getHand();
		Dealer dealer = new Dealer();
		Hand dealerHand = dealer.getHand();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~Welcome to the Blackjack Table~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		playerHand.addCard(newDeck.dealCard());
		playerHand.addCard(newDeck.dealCard());
		System.out.println("Your " + playerHand);

		dealerHand.addCard(newDeck.dealCard());
		dealerHand.addCard(newDeck.dealCard());
		System.out.println("The dealer's " + dealerHand);
		
		winner(playerHand, dealerHand);
		hitStay(playerHand, newDeck, kb);
		dealerHitStay(dealerHand, newDeck);

	}

	public static void hitStay(Hand playerHand, Deck newDeck, Scanner kb) {

		if (playerHand.getValueOfHand() < 21) {
			System.out.println("\nWhat would you like to do?" + " \n1. Hit" + " \n2. Stay");
			int hitOrStay;

			hitOrStay = kb.nextInt();
			if (hitOrStay == 1) {
				playerHand.addCard(newDeck.dealCard());
				System.out.println("Your " + playerHand);
				hitStay(playerHand, newDeck, kb);

			}

			else if (hitOrStay == 2) {
				System.out.println("\nYour final hand is: " + playerHand);
			}
		}
		bust(playerHand);
	}

	public static void dealerHitStay(Hand dealerHand, Deck newDeck) {
		while (dealerHand.getValueOfHand() < 17) {
			dealerHand.addCard(newDeck.dealCard());
		}
		bust(dealerHand);
		System.out.println("The dealer's " + dealerHand);
	}

	private static void bust(Hand hand) {
		if (hand.getValueOfHand() > 21) {
			System.out.println("\nYou have busted! The " + hand);
		}

	}

	private static void winner(Hand playerHand, Hand dealerHand) {
		if (playerHand.getValueOfHand() == 21) {
			System.out.println("\nCongratulations you have won!");
		}
		if (dealerHand.getValueOfHand() == 21) {
			System.out.println("\nThe dealer won!");
		}

	}
}
