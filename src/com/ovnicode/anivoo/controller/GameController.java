/**
 * 
 */
package com.ovnicode.anivoo.controller;

import java.util.ArrayList;

import com.ovnicode.anivoo.controller.logic.interfaces.GameLogic;
import com.ovnicode.anivoo.model.Deck;
import com.ovnicode.anivoo.model.PlayedCard;
import com.ovnicode.anivoo.model.Player;
import com.ovnicode.anivoo.model.PlayingCard;
import com.ovnicode.anivoo.model.Round;
import com.ovnicode.anivoo.view.interfaces.GameViewable;

/**
 * @author tonys
 *
 */

public class GameController {

	enum GameState {
		ADDING_PLAYERS, CARDS_DEALT, DISPLAY_WINNER;
	}

	private Deck deck;
	private GameViewable view;
	GameLogic gameLogic;
	private GameState gameState;
	private Round lastRound;
	private ArrayList<Player> players;
	private ArrayList<Round> rounds;

	public GameController(GameViewable view, Deck deck, GameLogic logic) {
		gameState = GameState.ADDING_PLAYERS;
		this.players = new ArrayList<>();
		this.rounds = new ArrayList<>();
		this.deck = deck;
		this.gameLogic = logic;
		this.view = view;
		this.view.setController(this);
	}

	public void addPlayer(String playerName) {
		if (gameState == GameState.ADDING_PLAYERS) {
			players.add(new Player(playerName));
			view.showPlayerName(players.size() - 1, playerName);
			if(players.size() == gameLogic.getMaximumPlayersForAGame()) {
				view.promptFullTable();
			}
		}
	}

	public void startGame() {
		if (gameState != GameState.CARDS_DEALT) {
			deck.shuffle();
			int playerIndex = 0;
			for (Player player : players) {
				for (int i = 0; i < 5; i++) {
					player.addCardToHand(deck.removeTopCard());
				}
				view.showFaceDownPlayerHand(playerIndex++, player.getName(), player.getHand());
			}
			gameState = GameState.CARDS_DEALT;
		}
	}

	public void makePlayersDropCards() {
		for (int roundCounter = 0; roundCounter < 5; roundCounter++) {

			final int proposerIndex = gameLogic.determineProposerIndex(rounds,lastRound);
			final Round round = new Round(proposerIndex);
			int playerIndex = proposerIndex;
			for (int i = 0; i < players.size(); i++) {
				if (playerIndex == players.size()) {
					playerIndex = 0;
				}
				Player player = players.get(playerIndex);
				String diplayedPlayerName = i ==0 ? player.getName()+"*" : player.getName();
				final int cardPlayedIndex = view.promptPlayerWhoHasToPlay(playerIndex, diplayedPlayerName,
						player.getHand());
				PlayingCard pc = player.playACard(cardPlayedIndex);
				round.addPlayedCard(new PlayedCard(pc.getRank(), pc.getSuit(), playerIndex, player.getName()));
				view.showPlayedCard(pc.getRank().value(), pc.getSuit().value(), playerIndex, player.getName());
				playerIndex++;
			}
			rounds.add(round);
			lastRound = round;
			if (rounds.size() == 5) {
				final int winnerIndex = gameLogic.whoWonTheRound(lastRound);
				final Player winner = players.get(winnerIndex);
				view.displayWinner(winnerIndex, winner.getName());
				gameState = GameState.DISPLAY_WINNER;
			}
		}
	}


	public void rebuildDeck() {
		// collect cards from players hand
	}

	public void restartGame() {
		players.clear();
		this.gameState = GameState.ADDING_PLAYERS;
	}

	public void exitGame() {
		System.exit(0);
	}

	public void run() {
		while (true) {
			switch (gameState) {
			case ADDING_PLAYERS:
				view.promptForPlayerName();
				break;
			case CARDS_DEALT:
				view.promptStartPlaying();// prompt for play a card
				break;
			case DISPLAY_WINNER:
				view.promptForNewGame();// prompt for new game
				break;
			default:
				break;
			}
		}
	}
}
