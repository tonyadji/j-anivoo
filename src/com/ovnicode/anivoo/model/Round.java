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
public class Round {

	private int proposerIndex;
	private ArrayList<PlayedCard> playedCards;
	
	public Round(int index) {
		this.proposerIndex = index;
		playedCards = new ArrayList<>();
	}
	
	public void addPlayedCard(PlayedCard card) {
		playedCards.add(card);
	}

	public int getProposerIndex() {
		return proposerIndex;
	}

	public List<PlayedCard> getPlayedCards() {
		return playedCards;
	}
	
	
}
