/**
 * 
 */
package com.ovnicode.anivoo.online.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.ovnicode.anivoo.online.utils.TableUtils;


/**
 * @author N9-T
 *
 */
public class MultithreadServer extends Thread{

	private int numberOfConnectedClients;
	private List<ClientConnetion> clients = new ArrayList<>();
	
	public static void main(String[] agrs) {
		new MultithreadServer().start();
	}
	
	@Override
	public void run() {
		System.out.println("Server up and running...");
		TableUtils.EXISTING_TABLES.add(TableUtils.getNewTable());
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(1234);
			while(true) {
				Socket clientSocket = serverSocket.accept();
				++numberOfConnectedClients;
				ClientConnetion clientConnection = new ClientConnetion(clientSocket, numberOfConnectedClients);
				clients.add(clientConnection);
				clientConnection.start();				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
