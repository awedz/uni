import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

public class socketHandler extends Thread {
	
	Socket incoming;
	ArrayList<arrays>  arr_array;
	private String clientSentence;
	int team;
	
	socketHandler(Socket _in , ArrayList<arrays>  arr_array , int team)
	{
		this.incoming=_in;
		this.arr_array = arr_array;
		this.team = team;
		
	}
	
	public void run()
	{
		 
	   
		try
		{
	    
           BufferedReader inFromClient = 
              new BufferedReader(new
              InputStreamReader(incoming.getInputStream())); 
          
          
          
		while(true) {
			
			
	           clientSentence = inFromClient.readLine(); // Receive from client
	          
	           if(clientSentence.toLowerCase().equals("bye"))// if the client send bye 
	           {										// we close the connection
	        	   
	        	   System.out.println(incoming + " is now disconnect");
	        	   
	        	   incoming.close();
	        	  
	        	   break;
	           }
	           
	          in(clientSentence , incoming , arr_array , team);// save the client Sentence
	           
	           clientSentence="";
	          
	          
	        }
		
		}
		catch(IOException e)
		{
			
		}

	}

	public static synchronized  void in(String clientSentence , Socket incoming , ArrayList<arrays>  arr_array , int team ){
		
		
		arr_array.add(new arrays(clientSentence , incoming , team)); // all the users can see it because it is static
         
		    
         
	}
	
}
