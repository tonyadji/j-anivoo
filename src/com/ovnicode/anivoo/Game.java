package com.ovnicode.anivoo;

import com.ovnicode.anivoo.controller.GameController;
import com.ovnicode.anivoo.controller.logic.FapfapGameLogic;
import com.ovnicode.anivoo.model.Deck;
import com.ovnicode.anivoo.view.CommandLineView;

public class Game {

	public static void main(String[] args) {
		GameController gc = new GameController(new CommandLineView(),new Deck(), new FapfapGameLogic());
		gc.run();

	}

}
