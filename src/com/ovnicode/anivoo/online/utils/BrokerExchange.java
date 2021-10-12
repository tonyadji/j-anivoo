/**
 * 
 */
package com.ovnicode.anivoo.online.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.ovnicode.anivoo.online.model.NetPlayer;
import com.ovnicode.anivoo.online.model.Table;

/**
 * @author ASUS
 *
 */
public class BrokerExchange {

	private Table table;

	public BrokerExchange(Table table) {
		this.table = table;
	}

	public void sendMessageToAll(String message) {
		for (NetPlayer player : table.getPlayers()) {
			try {
				final PrintWriter pw = new PrintWriter(player.getConnection().getSocket().getOutputStream(), true);
				pw.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendMessageTo(String message, int index) {
		for (NetPlayer player : table.getPlayers()) {
			if (player.getTableIndex() == index) {
				try {
					final PrintWriter pw = new PrintWriter(player.getConnection().getSocket().getOutputStream(), true);
					pw.println(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getMessage(NetPlayer player) {
		try {
			InputStreamReader isr = new InputStreamReader(player.getConnection().getSocket().getInputStream());
			BufferedReader bufReader = new BufferedReader(isr);
			String input = bufReader.readLine();
			return input;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getMessage(int playerIndex) {
		if(playerIndex<table.getPlayers().size()) {
			return getMessage(table.getPlayers().get(playerIndex));
		}
		return null;
	}

}
