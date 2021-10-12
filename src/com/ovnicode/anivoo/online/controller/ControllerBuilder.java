/**
 * 
 */
package com.ovnicode.anivoo.online.controller;

import com.ovnicode.anivoo.controller.logic.FapfapGameLogic;
import com.ovnicode.anivoo.model.Deck;
import com.ovnicode.anivoo.online.model.Table;
import com.ovnicode.anivoo.online.view.SocketView;

/**
 * @author ASUS
 *
 */
public class ControllerBuilder {

	public static OnlineGameController getOnlineGamecController(Table table) {
		return new OnlineGameController(new SocketView(table.getExchange()),new Deck(), new FapfapGameLogic(),table);
	}
}
