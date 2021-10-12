/**
 * 
 */
package com.ovnicode.anivoo.model;

import java.util.List;

/**
 * @author tonys
 *
 */
public class Player {

	protected String name;
	protected Hand hand;
	protected boolean banished;
	
	public Player(String playerName) {
		this.name = playerName;
		hand = new Hand();
		this.banished = false;
	}

	public boolean isBanished() {
		return banished;
	}

	public void setBanished(boolean banished) {
		this.banished = banished;
	}

	public String getName() {
		return name;
	}
	
	public void addCardToHand(PlayingCard card) {
		hand.addCard(card);
	}
	
	public PlayingCard playACard(int index) {
		return hand.playACard(index);
	}
	
	public List<PlayingCard> getHand() {
		return hand.getCards();
	}
}
