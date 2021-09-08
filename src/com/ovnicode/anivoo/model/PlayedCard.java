/**
 * 
 */
package com.ovnicode.anivoo.model;

/**
 * @author tonys
 *
 */
public class PlayedCard {

	private Rank cardRank;
	private Suit cardSuit;
	private int playerIndex;
	private String playerName;
	
	public PlayedCard(Rank rank, Suit suit, int index, String name) {
		this.cardRank = rank;
		this.cardSuit = suit;
		this.playerIndex = index;
		this.playerName = name;
	}

	public Rank getCardRank() {
		return cardRank;
	}

	public Suit getCardSuit() {
		return cardSuit;
	}

	public int getPlayerIndex() {
		return playerIndex;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	
}
