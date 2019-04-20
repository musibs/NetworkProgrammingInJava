package com.codefountain.networking.java.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public final class NetworkUtils {

	private NetworkUtils() {
		
	}
	
	public static void closeSocket(Socket socket) {
		if(Objects.nonNull(socket)) {
			try {
				socket.close();
			} catch (IOException e) {
				throw new SocketHandlingException(e.getMessage(), e.getCause()); 
			}
		}
	}
	
	public static void closeServerSocket(ServerSocket serverSocket) {
		if(Objects.nonNull(serverSocket)) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				throw new SocketHandlingException(e.getMessage(), e.getCause()); 
			}
		}
	}
}
