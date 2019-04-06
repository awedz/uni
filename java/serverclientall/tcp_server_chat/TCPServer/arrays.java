import java.net.Socket;
import java.util.ArrayList;


public class arrays {

	private String note ; 
	private Socket incoming;
	private int team ;
	
	arrays(String note , Socket incoming , int team )
	{
		this.note = note;
		this.incoming = incoming;
		this.team = team ; 
		
	}

	public String getNote() {
		return note;
	}

	

	public Socket getIncoming() {
		return incoming;
	}

	

	public int getTeam() {
		return team;
	}

	
	
	
	

	
	
}
