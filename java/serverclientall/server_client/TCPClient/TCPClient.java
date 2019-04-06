

/*
 * Java provides a mechanism, called object serialization where an object can be represented as a sequence of bytes that includes the object's data as well as information about the object's type and the types of data stored in the object.

After a serialized object has been written into a file, it can be read from the file and deserialized that is, the type information and bytes that represent the object and its data can be used to recreate the object in memory.

Most impressive is that the entire process is JVM independent, meaning an object can be serialized on one platform and deserialized on an entirely different platform.

Classes ObjectInputStream and ObjectOutputStream are high-level streams that contain the methods for serializing and deserializing an object.
 * 
 * pay attation that if the client sends you integer so in the server you will get integer 
 * and if it sends you string so you will get string . 
 * 
 * 
 */

import java.io.*; 
import java.net.*; 
import java.util.Scanner;



class TCPClient_with_serialized { 

    public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        String modifiedSentence; 
        Object get_from_server_object ; 
        Number num = 0 ; 
        
        Scanner inFromUser =  new Scanner (System.in) ;

        Socket clientSocket = new Socket("localhost", 10000); 

        DataOutputStream outToServer = 
          new DataOutputStream(clientSocket.getOutputStream()); 

        ObjectInputStream  inFromServer = 
          new ObjectInputStream (clientSocket.getInputStream()); 
		
		while(true)
		{
			
			System.out.println("plz insert something");
			sentence = inFromUser.next(); 
      
			outToServer.writeBytes(sentence + '\n'); 

			get_from_server_object = inFromServer.readObject(); 
			
		//	modifiedSentence = get_from_server_object; 
			
			System.out.println(get_from_server_object);
			
		//	System.out.println("FROM SERVER: " + modifiedSentence );
			
			if(sentence.toLowerCase().equals("bye"))
				break;
			
		}
        clientSocket.close(); 
                   
    } 
} 

