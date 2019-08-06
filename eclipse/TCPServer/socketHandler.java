import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class socketHandler extends Thread {
	Socket incoming;
	Sql sql; 
	
	socketHandler(Socket _in, Sql sql)
	{
		this.incoming=_in;
		this.sql = sql;
	}
	
	public void run()
	{
	int sum =0; 
		try
		{
	    sql.sel
//           BufferedReader inFromClient = 
//              new BufferedReader(new
//              InputStreamReader(incoming.getInputStream()));
			
		   ObjectInputStream  inFromClient = 
		            new ObjectInputStream (incoming.getInputStream()); 
          
//           ObjectOutputStream  outToClient = 
//        		   new ObjectOutputStream (incoming.getOutputStream() );
          
		   DataOutputStream outToClient = 
		          new DataOutputStream(incoming.getOutputStream());
		   
		while(true) {
			
		for(int i=0 ; i< 5 ; i++){
	       Object obj = inFromClient.readObject(); // get Object from client
			if( obj instanceof Lecture)
			{
				Lecture l = (Lecture) obj;
				sum += l.getSalary();
			}
			}
			//send String to client
	        	outToClient.writeBytes( (sum / 5 )+ "\n");
	        
	           
	        }
		}
		catch(IOException | ClassNotFoundException e)
		{
			
		}

	}
}
