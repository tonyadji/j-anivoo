package com.ovnicode.anivoo.online.view;

import java.util.List;

import com.ovnicode.anivoo.model.PlayingCard;
import com.ovnicode.anivoo.online.controller.OnlineGameController;
import com.ovnicode.anivoo.online.utils.BrokerExchange;
import com.ovnicode.anivoo.online.view.interfaces.OnlineGameViewable;

public class SocketView implements OnlineGameViewable {
	
	private OnlineGameController ogc;
	private BrokerExchange exchange;
	
	public SocketView(BrokerExchange exchange) {
		this.exchange = exchange;
	}

	@Override
	public void setController(OnlineGameController ogc) {
		this.ogc = ogc;
	}

	@Override
	public void showPlayerName(int playerIndex, String playerName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showFaceDownPlayerHand(int playerIndex, String playerName, List<PlayingCard> cards) {
		exchange.sendMessageToAll("[" + playerIndex + "][" + playerName + "]  - Cards ");
		for (int i = 0; i < cards.size(); i++) {
			exchange.sendMessageToAll("[] ");
		}
		exchange.sendMessageToAll("\n");
	}

	@Override
	public void promptReadyToPlay() {
		System.out.println("Ready to play ");
		if (true) {
			ogc.startGame();
		} 
	}

	@Override
	public void displayWinner(int playerIndex, String name) {
		exchange.sendMessageToAll("******************************************");
		exchange.sendMessageToAll("The winner is [" + playerIndex + "][" + name + "]");
		exchange.sendMessageToAll("******************************************");
	}

	@Override
	public void promptForNewGame() {
		exchange.sendMessageTo("Press R to restart, Q to exit",0);
		String input = exchange.getMessage(0);

		if (input.equalsIgnoreCase("Q")) {
			ogc.exitGame();
		}

		if (input.equalsIgnoreCase("R")) {
			ogc.restartGame();
		} 
	}

	@Override
	public void promptStartPlaying() {
		exchange.sendMessageToAll("Start playing...");
		ogc.makePlayersDropCards();

	}

	@Override
	public int promptPlayerWhoHasToPlay(int playerIndex, String playerName, List<PlayingCard> hand) {
		exchange.sendMessageToAll("[" + playerIndex + "-" + playerName + "] should play");
		int cardIndex = 0;
		for (PlayingCard pc : hand) {
			exchange.sendMessageTo("[" + cardIndex + "][" + pc.getRank().value() + "-" + pc.getSuit().value() + "]",playerIndex);
			cardIndex++;
		}
		int cardPlayedIndex = Integer.parseInt(exchange.getMessage(playerIndex)) ;
		return cardPlayedIndex;
	}

	@Override
	public void showPlayedCard(int cardRank, String cardSuit, int playerIndex, String name) {
		exchange.sendMessageToAll("[" + playerIndex + "][" + name + "] played [" + cardRank + "-" + cardSuit + "]");

	}

	@Override
	public void promptFullTable() {
		// TODO Auto-generated method stub

	}

}
