package com.codefountain.networking.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.codefountain.networking.java.utils.NetworkUtils;



/**
 * Server application to process client requests
 * 
 * @author Somnath Musib
 *
 */
public class Server {
	
	private static final byte[] BUFFER = new byte[8192];
	private static final int SERVER_PORT = 1233;
	private static final int CORE_THREAD_POOL_SIZE = 1;
	private static ScheduledExecutorService executorService = null;
	
	public static void main(String[] args) {
		
		executorService = Executors.newScheduledThreadPool(CORE_THREAD_POOL_SIZE);
		executorService.scheduleAtFixedRate(new ServerRunner(), 0, 5, TimeUnit.SECONDS);
	}
	
	
	private static class ServerRunner implements Runnable{

		@Override
		public void run() {

			ServerSocket serverSocket = null;
			
			try {
				serverSocket = new ServerSocket(SERVER_PORT);
				System.out.println("Server started at "+LocalTime.now());
				Socket client = serverSocket.accept();
				DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
				dataInputStream.read(BUFFER);
				System.out.println(new String(BUFFER));
				DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
				dataOutputStream.write("Request Processed".getBytes());
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				NetworkUtils.closeServerSocket(serverSocket);
				executorService.scheduleAtFixedRate(new ServerRunner(), 0, 5, TimeUnit.SECONDS);
			}
		}
		
	}
	
}
