package BL;

import Message.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import DAL.Dal;
import Enums.ClientType;
import Enums.ReqType;
public class Bl {
	Dal a;
	
	public Bl() throws UnknownHostException, IOException
	{
		a = new Dal();
	}
	
	public int ValidateUser(Message m) throws ClassNotFoundException, IOException
	{
		int res  = (int)a.SendToServer(m);
		return res;
	}
	
	public void UpdatePassword(Message m) throws ClassNotFoundException, IOException
	{
		a.SendToServer(m);
	}
	public String[][] GetTenantYearDetails(Message msg) throws ClassNotFoundException, IOException
	{
		ArrayList<String[]> arr = (ArrayList<String[]>)a.SendToServer(msg);
		String[][] str = new String [arr.size()][arr.get(1).length];
		
		for(int i = 0; i< arr.size();i++)
		{
			for(int x=0;x<arr.get(1).length;x++)
			{
				str[i][x] = arr.get(i)[x];
			}
		}
		return str;
	}
	public String[][] GetCommitteeYearDetails() throws ClassNotFoundException, IOException
	{
		HashMap<String, String> arr = (HashMap<String, String>)a.SendToServer(new Message(ClientType.Committee,ReqType.GetCommitteeTotalPayments));
		String[][] str = new String [12][2];
		for(String key :arr.keySet())
		{
			str[Integer.parseInt(key)-1][0]=key;
			str[Integer.parseInt(key)-1][1]=arr.get(key);
		}
		for(int i = 0;i<12;i++)
		{
			if(str[i][1]== null)
			{
				str[i][0]="" + (i+1);
				str[i][1] = "-";
			}
		}
		return str;
	}
	public String[][] GetCommitteeMonthDetails() throws ClassNotFoundException, IOException
	{
		HashMap<String, ArrayList<String[]>> arr = (HashMap<String, ArrayList<String[]>>)a.SendToServer(new Message(ClientType.Committee,ReqType.GetCommitteeTenantPayments));
		
		String[][] str = new String[arr.keySet().size()][13];

		ArrayList<String> testList;
		int strIndex = 0;
		for (String key : arr.keySet()) {
			for(String[] data : arr.get(key))
			{
				str[strIndex][Integer.parseInt(data[0])] = data[1];
			}
			str[strIndex][0]=key;
			for(String[] row:str)
			{
				int i = 0;
				for (String date : row) {
					if (date == null) {
						row[i] = "-";
					}
					i++;
				}
			}
			strIndex++;
		}
		
		
		return str;
	}
	public void InsertPayment(Message m) throws ClassNotFoundException, IOException
	{
		InsertUpdateTenantPaymentMessage msg = (InsertUpdateTenantPaymentMessage)m;
		a.SendToServer(msg);
	}
	
	
}
