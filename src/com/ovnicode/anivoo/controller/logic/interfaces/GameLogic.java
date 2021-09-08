package com.ovnicode.anivoo.controller.logic.interfaces;

import java.util.List;

import com.ovnicode.anivoo.model.Round;

/**
 * @author tonys
 *
 */
public interface GameLogic {

	public int determineProposerIndex(List<Round> rounds, Round lastRound);

	public int whoWonTheRound(Round round);
	
	public int getMaximumPlayersForAGame();
}
