/**
 * 
 */
package com.ovnicode.anivoo.model;

/**
 * @author tonys
 *
 */
public enum Suit {

	DIAMONDS("Zing"),
	HEARTS("Koubi"),
	SPADES("Black"),
	CLUBS("Tchaka");
	
	String suit;
	
	private Suit(String value) {
		suit = value;
	}
	
	public String value() {
		return suit;
	}
}
