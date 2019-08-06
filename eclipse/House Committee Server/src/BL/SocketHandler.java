package BL;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import DAL.Sql;
import Message.*;

public class SocketHandler extends Thread {
	Socket incoming;
	Sql s;
	ObjectInputStream objectInputStream;
	ObjectOutputStream outToClient;

	public SocketHandler(Socket _in, Sql s) throws IOException {
		incoming = _in;
		System.out.println(_in);
		this.s = s;

		objectInputStream = new ObjectInputStream(incoming.getInputStream());
		outToClient = new ObjectOutputStream(incoming.getOutputStream());

	}

	public void run() {
		try {
			while (incoming.isConnected()) {
				Message msg = (Message) objectInputStream.readObject();
				switch (msg.reqType) {
				case GetCommitteeTenantPayments://done
					outToClient.writeObject(s.GetCommitteeTenantPayments());
					break;
				case GetCommitteeTotalPayments://done
					outToClient.writeObject(s.GetCommitteeTotalPayments());
					break;
				case GetTenantPymants://done
					GetTenantPymantsMessage qryMsg = (GetTenantPymantsMessage) msg;
					outToClient.writeObject(s.GetTenantPymants(qryMsg.getClientID()));
					break;
				case InsertTenantPayment:
					// int apartmentNum,int monthNum,int amount)
					InsertUpdateTenantPaymentMessage insMsg = (InsertUpdateTenantPaymentMessage) msg;
					outToClient.writeObject(s.Insert_UpdateTenentPayment(insMsg.getClientID(), insMsg.getmonthNum(), insMsg.getamount()));
					break;
				case Login:
					// String UserName, String Password, ClientType table
					LoginMessage lginMsg = (LoginMessage) msg;
					System.out.println(lginMsg.UserName + "is logging in");
					int clientId = s.ValidateUser(lginMsg.UserName, lginMsg.Pswd, lginMsg.clientType);
					outToClient.writeObject(clientId);
					break;
				case NewPassword:
					// String UserName, String Password, ClientType table
					LoginMessage newPswd = (LoginMessage) msg;
					s.UpdatePassword(newPswd.UserName, newPswd.Pswd,newPswd.clientType);
					outToClient.writeObject(0);
					break;
				default:
					outToClient.writeObject(0);
					break;
				}
			}
		incoming.close();
		} catch (IOException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {

		}

	}

}
