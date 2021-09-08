/**
 * 
 */
package com.ovnicode.anivoo.model;

/**
 * @author tonys
 *
 */
public class PlayingCard {

	private Rank rank;
	private Suit suit;
	
	public PlayingCard(Rank r, Suit s) {
		rank = r;
		suit = s;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

}
