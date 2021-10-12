/**
 * 
 */
package com.ovnicode.anivoo.online.model;

import com.ovnicode.anivoo.model.Player;
import com.ovnicode.anivoo.online.server.ClientConnetion;

/**
 * @author ASUS
 *
 */
public class NetPlayer extends Player{

	private ClientConnetion connection;
	private Table table;
	private int tableIndex;
	
	public NetPlayer(String name, ClientConnetion connection) {
		super(name);
		this.connection = connection;
	}
	
	public ClientConnetion getConnection() {
		return this.connection;
	}
	
	public void joinTable(Table table) {
		this.table = table;
		this.tableIndex = table.addPlayer(this);
	}
	
	public void quitTable() {
		this.table.removePlayer(tableIndex);
	}
	
	public void setTableIndex(int index) {
		tableIndex = index;
	}
	
	public int getTableIndex() {
		return this.tableIndex;
	}
}
