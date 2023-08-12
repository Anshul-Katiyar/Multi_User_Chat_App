package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.brainmentors.chatapp.utils.ConfigReader;


public class Server {
	ServerSocket serverSocket ;
	ArrayList<ServerWorker> workers = new ArrayList<>();
	public Server() throws IOException{
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
	      serverSocket = new ServerSocket(PORT);
	      System.out.println("Server started and waiting for the Clients to join....");
	      handleClientRequest();
	      
	}
	
	public void handleClientRequest() throws IOException {
		while(true) {
		Socket clientSocket = serverSocket.accept();
	      //per client per thread
	      ServerWorker serverWorker = new ServerWorker(clientSocket,this);
	      workers.add(serverWorker);
	      serverWorker.start(); 
		}
		
	}
	
	/*Single Client*/
	/*
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
      serverSocket = new ServerSocket(PORT);
      System.out.println("Server Started and waiting for Client...");
      Socket socket = serverSocket.accept();    //Hand Shaking
      System.out.println("Client Joins the Server...");
      InputStream in = socket.getInputStream();
      byte arr[] = in.readAllBytes();
      String str = new String(arr);
      System.out.println("Message recieved from Client "+str);
      in.close();
      socket.close();
	}
	*/
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Server server=new Server();
	} 

}
