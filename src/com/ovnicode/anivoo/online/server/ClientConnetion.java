package com.ovnicode.anivoo.online.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.ovnicode.anivoo.online.model.NetPlayer;
import com.ovnicode.anivoo.online.utils.TableUtils;

public class ClientConnetion extends Thread{

	private int clientId;
	private Socket socket;
	private String clientName;
	public ClientConnetion(Socket sock, int clientId) {
		this.socket = sock;
		this.clientId = clientId;
	}
	
	@Override
	public void run() {
		System.out.println("Client "+clientId+" connecté avec l'ip "+socket.getRemoteSocketAddress());
		InputStream inputStream;
		OutputStream outputStream;
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			InputStreamReader iStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufReader = new BufferedReader(iStreamReader);
			PrintWriter writer = new PrintWriter(outputStream,true);
			writer.println("You are now connected to Kooby ! Please type your name ");
			String name = bufReader.readLine();
			clientName = name;
			writer.println("Welcome "+name +" !");
			//créer le joueur
			final NetPlayer player = new NetPlayer(name, this);
			while(true) {
				//choisir la table
				writer.println("Choisir une table !");
				writer.println(TableUtils.getTablesDetails());
				final String tableId = bufReader.readLine();
				//si le nom de la table est vide on break
				if(tableId.isEmpty()) break;
				TableUtils.addPlayer(tableId,player);
				writer.println("Assis à la table "+tableId);
				writer.println(TableUtils.getTablesDetails());
				TableUtils.processGame(tableId);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getClientId() {
		return this.clientId;
	}
	
	public Socket getSocket() {
		return this.socket;
	}
}
