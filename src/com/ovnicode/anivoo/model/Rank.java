/**
 * 
 */
package com.ovnicode.anivoo.model;

/**
 * @author tonys
 *
 */
public enum Rank {

	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10);
	
	int rank;
	
	private Rank(int value) {
		rank = value;
	}
	
	public int value() {
		return rank;
	}
}
