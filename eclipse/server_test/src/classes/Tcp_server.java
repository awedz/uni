package classes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Tcp_server {
	private String _sentance;
	private String _modifiedSentance;
	
	private Scanner _inFromUser;
	private Socket _clientSocket;
	private DataOutputStream _outToServer;
	Tcp_server() throws UnknownHostException, IOException{
		_inFromUser =  new Scanner (System.in) ;
		_clientSocket = new Socket("localhost", 10000);
	}
	
	public void Listen()
	{
		
	}
	public void Speak()
	{
		while(true)
		{
			System.out.println("plz insert something");
			_sentance = _inFromUser.next(); 
      
			_outToServer.writeBytes(_sentance + '\n'); 

			_modifiedSentance = _inFromUser. 
			
			System.out.println("FROM SERVER: " + _modifiedSentance);
			
			if(sentence.toLowerCase().equals("bye"))
				break;
		}
		
	}
}
