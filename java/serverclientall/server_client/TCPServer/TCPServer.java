import java.io.*; 
import java.net.*; 

class TCPServer { 
    
  public static void main(String argv[]) throws Exception 
    { 
	  String test = "abc acb aa bb a a a";
	  test =  test.replaceAll("a", "p");
	  System.out.println(test);
	  
	  
	  ServerSocket s = null;
	 
		try {
		    s = new ServerSocket(10000);
		
		} catch(IOException e) {
		    System.out.println(e);
		    System.exit(1);
		}

		while (true) {
		    Socket incoming = null;
		    
		    try {
			incoming = s.accept();
			
		    } catch(IOException e) {
			System.out.println(e);
			continue;
		    }

		    new socketHandler(incoming).start();

		}
    } 
} 
