/**
 * 
 */
package com.ovnicode.anivoo.online.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ovnicode.anivoo.online.controller.OnlineGameController;
import com.ovnicode.anivoo.online.utils.BrokerExchange;

/**
 * @author ASUS
 *
 */
public class Table implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private List<NetPlayer> players;
	private OnlineGameController gameController;
	private BrokerExchange exchange;
	
	public Table(String id) {
		this.id = id;
		players = new ArrayList<>();
		exchange = new BrokerExchange(this);
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setController(OnlineGameController ogc) {
		this.gameController = ogc;
	}
	
	public int addPlayer(NetPlayer player) {
		this.players.add(player);
		return players.size() - 1;
	}
	
	public void removePlayer(int index) {
		players.remove(index);
		reAssignPlayerIndex();
	}
	
	private void reAssignPlayerIndex() {
		int i = 1;
		for(NetPlayer player: players) {
			player.setTableIndex(i);
			i++;
		}
	}
	
	public List<NetPlayer> getPlayers(){
		return this.players;
	}

	public void processGame() {
		this.gameController.run();
	}
	
	public BrokerExchange getExchange() {
		return this.exchange;
	}
}
