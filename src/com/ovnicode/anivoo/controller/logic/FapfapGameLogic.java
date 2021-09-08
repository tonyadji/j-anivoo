/**
 * 
 */
package com.ovnicode.anivoo.controller.logic;

import java.util.List;

import com.ovnicode.anivoo.controller.logic.interfaces.GameLogic;
import com.ovnicode.anivoo.model.PlayedCard;
import com.ovnicode.anivoo.model.Rank;
import com.ovnicode.anivoo.model.Round;
import com.ovnicode.anivoo.model.Suit;

/**
 * @author tonys
 *
 */
public class FapfapGameLogic implements GameLogic {
	
	public int determineProposerIndex(List<Round> rounds, Round lastRound) {
		if (rounds.isEmpty()) {
			return 0;
		} else {
			return whoWonTheRound(lastRound);
		}
	}

	public int whoWonTheRound(Round round) {
		int roundWinnerIndex = round.getProposerIndex();
		Rank bestProposedRank = null;
		Suit proposedSuit = null;

		for (PlayedCard playedCard : round.getPlayedCards()) {
			if (playedCard.getPlayerIndex() == round.getProposerIndex()) {
				bestProposedRank = playedCard.getCardRank();
				proposedSuit = playedCard.getCardSuit();
				break;
			}
		}

		for (PlayedCard playedCard : round.getPlayedCards()) {
			if ((playedCard.getCardSuit() == proposedSuit)
					&& (playedCard.getCardRank().value() > bestProposedRank.value())) {
				roundWinnerIndex = playedCard.getPlayerIndex();
				bestProposedRank = playedCard.getCardRank();
			}
		}

		return roundWinnerIndex;
	}

	@Override
	public int getMaximumPlayersForAGame() {
		return 4;
	}
}
