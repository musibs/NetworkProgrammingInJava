package com.codefountain.networking.java;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * A Client application writes data into server and 
 * takes the response back from server
 * 
 * @author Somnath Musib
 *
 */
public class Client {

	private static final byte[] BUFFER = new byte[8192];
	private static final int CLIENT_PORT = 1233;
	private static final String CLIENT_HOST = "localhost";
	
	public static void main(String[] args) {
	
		Socket socket = null;
		
		try {
			socket = new Socket(CLIENT_HOST, CLIENT_PORT);
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataOutputStream.write("Hello Server".getBytes());
			dataOutputStream.flush();
			socket.getInputStream().read(BUFFER);
			System.out.println(new String(BUFFER));
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
