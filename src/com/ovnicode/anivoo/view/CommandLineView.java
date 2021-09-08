/**
 * 
 */
package com.ovnicode.anivoo.view;

import java.util.List;
import java.util.Scanner;

import com.ovnicode.anivoo.controller.GameController;
import com.ovnicode.anivoo.model.PlayingCard;
import com.ovnicode.anivoo.view.interfaces.GameViewable;

/**
 * @author tonys
 *
 */
public class CommandLineView implements GameViewable {

	private GameController gameController;
	private Scanner keyboard = new Scanner(System.in);

	public void setController(GameController gc) {
		this.gameController = gc;
	}

	public void showPlayerName(int playerIndex, String playerName) {
		System.out.println("[" + playerIndex + "][" + playerName + "]");
	}

	public void showFaceDownPlayerHand(int playerIndex, String playerName, List<PlayingCard> cards) {
		System.out.print("[" + playerIndex + "][" + playerName + "]  - Cards ");
		for (int i = 0; i < cards.size(); i++) {
			System.out.print("[] ");
		}
		System.out.print("\n");
	}

	public void promptForPlayerName() {
		System.out.println("Enter player name");
		String name = keyboard.nextLine();
		if (name.isEmpty()) {
			gameController.startGame();
		} else {
			gameController.addPlayer(name);
		}
	}

	public void displayWinner(int playerIndex, String name) {
		System.out.println("******************************************");
		System.out.println("The winner is [" + playerIndex + "][" + name + "]");
		System.out.println("******************************************");
	}

	public void promptForNewGame() {
		System.out.println("Press R to restart, Q to exit or any button to deal again");
		keyboard.nextLine();
		String input = keyboard.nextLine();

		if (input.equalsIgnoreCase("Q")) {
			gameController.exitGame();
		}

		if (input.equalsIgnoreCase("R")) {
			gameController.restartGame();
		} else {
			gameController.startGame();
		}
	}

	public void promptStartPlaying() {
		System.out.println("Start the game ?");
		keyboard.nextLine();
		gameController.makePlayersDropCards();
	}

	public int promptPlayerWhoHasToPlay(int playerIndex, String playerName, List<PlayingCard> hand) {
		System.out.println("[" + playerIndex + "-" + playerName + "] should play");
		int cardIndex = 0;
		for (PlayingCard pc : hand) {
			System.out.print("[" + cardIndex + "][" + pc.getRank().value() + "-" + pc.getSuit().value() + "]");
			cardIndex++;
		}
		int cardPlayedIndex = keyboard.nextInt();
		return cardPlayedIndex;
	}

	public void showPlayedCard(int cardRank, String cardSuit, int playerIndex, String name) {
		System.out.println("[" + playerIndex + "][" + name + "] played [" + cardRank + "-" + cardSuit + "]");

	}

	@Override
	public void promptFullTable() {
		System.out.println("Table full !");
		gameController.startGame();
	}
}
