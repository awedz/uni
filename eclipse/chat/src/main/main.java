package main;

import java.util.*;
import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		InetAddress addr = InetAddress.getByName("127.0.1.1");
		//ServerSocket server = null;
		ServerSocket server = null;
		DataOutputStream outToServer  = null;
		BufferedReader inFromServer = null;
		try {
			server = new ServerSocket(4000,1,addr);
			System.out.println("listening on port 4000");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
			System.exit(1);
		}
		while(true)
		{
			Socket client = null;
			System.out.println( server.getInetAddress().getHostAddress());
			try {
				client = server.accept();
				outToServer = new DataOutputStream(client.getOutputStream());
				inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
				outToServer.writeBytes("connected");
				System.out.println("conncted " + client.getInetAddress());
				while(true)
				{
					System.out.println(inFromServer.readLine());
				}
			}
			catch(IOException e)
			{
				System.out.println(e);
				continue;
			}
			finally {
				server.close();
			}
		}
	}
}
