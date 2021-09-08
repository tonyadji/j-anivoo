/**
 * 
 */
package com.ovnicode.anivoo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonys
 *
 */
public class Hand {

	private ArrayList<PlayingCard> cards;
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(PlayingCard pc) {
		cards.add(pc);
	}
		
	public PlayingCard playACard(int index) {
		return cards.remove(index);
	}
	
	public List<PlayingCard> getCards(){
		return cards;
	}
}
