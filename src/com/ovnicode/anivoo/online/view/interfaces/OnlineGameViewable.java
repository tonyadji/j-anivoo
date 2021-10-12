/**
 * 
 */
package com.ovnicode.anivoo.online.view.interfaces;

import java.util.List;

import com.ovnicode.anivoo.model.PlayingCard;
import com.ovnicode.anivoo.online.controller.OnlineGameController;

/**
 * @author ASUS
 *
 */
public interface OnlineGameViewable {

public void setController(OnlineGameController ogc);
	
	public void showPlayerName(int playerIndex, String playerName);

	public void showFaceDownPlayerHand(int playerIndex, String playerName, List<PlayingCard> cards);

	public void promptReadyToPlay();

	public void displayWinner(int playerIndex, String name);

	public void promptForNewGame();

	public void promptStartPlaying();

	public int promptPlayerWhoHasToPlay(int playerIndex, String playerName, List<PlayingCard> hand);

	public void showPlayedCard(int cardRank, String cardSuit, int playerIndex, String name);

	public void promptFullTable();
}
