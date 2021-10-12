/**
 * 
 */
package com.ovnicode.anivoo.online.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ASUS
 *
 */
public class Client {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",1234);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		InputStreamReader iStreamReader = new InputStreamReader(is);
		BufferedReader bufReader = new BufferedReader(iStreamReader);
		PrintWriter writer = new PrintWriter(os,true);
		//String serverResponse = bufReader.readLine();
		//System.out.println(serverResponse);
	}
}
