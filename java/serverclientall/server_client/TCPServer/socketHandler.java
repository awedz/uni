import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.*;

public class socketHandler extends Thread {
	Socket incoming;
	String[] animals = {"cat","dog"};
	socketHandler(Socket _in)
	{
		this.incoming = _in;
	}
	
	public void run()
	{
		String clientSentence; 
	    String capitalizedSentence; 
	    String retString;
		try
		{
	    
           BufferedReader inFromClient = new BufferedReader(new InputStreamReader(incoming.getInputStream())); 
           ObjectOutputStream  outToClient = new ObjectOutputStream (incoming.getOutputStream() );
          
		while(true) {
				clientSentence = inFromClient.readLine(); 
				clientSentence = clientSentence.toLowerCase();
	            for (String animal : animals) {
					 clientSentence = clientSentence.replaceAll("\\b"+animal+"\\b", "x");
	            }
	            System.out.println("new string " + clientSentence);
	            outToClient.writeBytes(clientSentence + "\n");
	           
	            if(clientSentence.toLowerCase().equals("bye"))
	            {
	        	    incoming.close();
	        	    break;
	            }
	         }
		 }
		 catch(IOException e)
		 {
			
		 }

	 }
}
