/**
 * 
 */
package com.ovnicode.anivoo.online.utils;

import java.util.ArrayList;
import java.util.List;

import com.ovnicode.anivoo.online.controller.ControllerBuilder;
import com.ovnicode.anivoo.online.controller.OnlineGameController;
import com.ovnicode.anivoo.online.model.NetPlayer;
import com.ovnicode.anivoo.online.model.Table;

/**
 * @author ASUS
 *
 */
public class TableUtils {

	private TableUtils() {
	}

	public static List<Table> EXISTING_TABLES = new ArrayList<>();

	public static Table getNewTable() {
		final Table  table = new Table("String");
		OnlineGameController ogc = ControllerBuilder.getOnlineGamecController(table);
		table.setController(ogc);
		return table;
	}

	public static String getTablesDetails() {
		StringBuffer details = new StringBuffer();
		EXISTING_TABLES.forEach(table -> details.append("[id: ").append(table.getId()).append(" - ")
				.append(table.getPlayers().size()).append(" players]"));
		return details.toString();
	}

	public static void addPlayer(String tableId, NetPlayer player) {
		//final Table table = EXISTING_TABLES.stream().filter(tab->tab.getId().equals(tableId)).collect(Collectors.toList()).get(0);
		for(Table table: EXISTING_TABLES) {
			if(table.getId().equals(tableId)) {
				player.joinTable(table);				
			}
		}		
	}
	
	public static void processGame(String tableId) {
		Table table = null;
		for(Table tab: EXISTING_TABLES) {
			if(tab.getId().equals(tableId)) {
				table = tab;
				break;
			}
		}
		if(table != null) table.processGame();
	}
}
