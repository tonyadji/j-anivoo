/**
 * 
 */
package com.ovnicode.anivoo.view.interfaces;

import java.util.List;

import com.ovnicode.anivoo.controller.GameController;
import com.ovnicode.anivoo.model.PlayingCard;

/**
 * @author tonys
 *
 */
public interface GameViewable {

	public void setController(GameController gc);
	
	public void showPlayerName(int playerIndex, String playerName);

	public void showFaceDownPlayerHand(int playerIndex, String playerName, List<PlayingCard> cards);

	public void promptForPlayerName();

	public void displayWinner(int playerIndex, String name);

	public void promptForNewGame();

	public void promptStartPlaying();

	public int promptPlayerWhoHasToPlay(int playerIndex, String playerName, List<PlayingCard> hand);

	public void showPlayedCard(int cardRank, String cardSuit, int playerIndex, String name);

	public void promptFullTable();
}
