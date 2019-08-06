package DAL;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import Message.*;

public class Dal {

	Object res = null;
	Socket clientSocket;

	private ObjectOutputStream _outToServer = null;
	private ObjectInputStream _inFromServer = null;

	public Dal() throws UnknownHostException, IOException {
		_Init();
	}

	
	private void _Init() throws UnknownHostException, IOException {
		clientSocket = new Socket("localhost", 10000);
		OpenConnection();
	}
	
	public void CloseConnection() throws IOException
	{
		_outToServer.close();
		_inFromServer.close();
	}
	public void OpenConnection() throws IOException
	{
		_outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		_inFromServer = new ObjectInputStream(clientSocket.getInputStream());
	}
	
	public Object SendToServer(Message M) throws ClassNotFoundException, IOException {

		try {
			_outToServer.writeObject(M);
			res = _inFromServer.readObject();

		} catch (ConnectException e) {
			System.out.println(" 404 C'ant connect to the Server");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("unknown happend");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("io happend ");
			e.printStackTrace();
		}
		return res;
	}
}
