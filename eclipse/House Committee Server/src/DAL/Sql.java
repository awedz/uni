package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;

import Enums.ClientType;
import Message.LoginMessage;
import Message.Message;

public class Sql {

	private static Connection connect;

	/**
	 * ValidateUser select the id of a user from database if exists
	 * 
	 * @param UserName - username
	 * @param Password - password
	 * @param table    - table name from ClientType enum as table name
	 * @return resultset from data base with id selected
	 * @throws SQLException
	 */
	public int ValidateUser(String UserName, String Password, ClientType table) throws SQLException {
		String baseQuery = "select ID from " + table.name() + " where UserName = ? and UserPassword = ?";
		ConectingToSQL();
		ResultSet queryRes = null;
		int res = 0;
		try {
			PreparedStatement pst = connect.prepareStatement(baseQuery);
			// pst.setString(1, table.name().toString());
			pst.setString(1, UserName);
			pst.setString(2, Password);
			queryRes = pst.executeQuery();
			if (queryRes.next())
				res = queryRes.getInt("ID");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.close();
		}

		return res;
	}

	/**
	 * UpdatePassword - updates user password
	 * 
	 * @param UserName
	 * @param Password
	 * @param table       - name of table from ClientType enum
	 * @param newPassword
	 * @throws SQLException
	 */
	public void UpdatePassword(String UserName, String newPassword, ClientType table) throws SQLException {
		String baseQuery = "update " + table.name() + " set UserPassword = ? where UserName = ?";
		ConectingToSQL();
		int res = 0;
		try {
			PreparedStatement pst = connect.prepareStatement(baseQuery);
			// pst.setString(1, table.name());
			pst.setString(1, newPassword);
			pst.setString(2, UserName);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.close();
		}
	}

	/**
	 * GetTenantPymants gets a sum of total payment a tenant has done
	 * 
	 * @param userID
	 * @return ArrayList<String[]> contains of string arrays - {month,amount payed}
	 * @throws SQLException
	 */
	public ArrayList<String[]> GetTenantPymants(int userID) throws SQLException {
		String baseQuery = "select MonthNum,AmountPayed From Payments where ApartmentNumber = (select ApartmentNumber from Tenants where ID = ?)";
		ConectingToSQL();
		ResultSet queryRes = null;
		ArrayList<String[]> res = new ArrayList<String[]>();
		try {
			PreparedStatement pst = connect.prepareStatement(baseQuery);
			pst.setInt(1, userID);
			queryRes = pst.executeQuery();
			int monthcol = queryRes.findColumn("MonthNum");// key
			int amountcol = queryRes.findColumn("AmountPayed");// value
			while (queryRes.next()) {
				String month = queryRes.getString(monthcol);
				String amount = queryRes.getString(amountcol);
				res.add(new String[] { month, amount });

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.close();
		}
		return res;
	}

	/**
	 * GetCommitteeTotalPayments gets a sum of total payment all the tenants has
	 * done
	 * 
	 * @return Map<String,String> type object where MonthNum is key and MonthSum is
	 *         value
	 * @throws SQLException
	 */
	public Map<String, String> GetCommitteeTotalPayments() throws SQLException {
		String query = " select MonthNum,sum(AmountPayed) as MonthSum from Payments where MonthNum in (select MonthNum from Payments) group by MonthNum";
		ConectingToSQL();
		ResultSet queryRes = null;
		Map<String, String> res = new HashMap<String, String>();
		try {
			PreparedStatement pst = connect.prepareStatement(query);
			queryRes = pst.executeQuery();
			int key = queryRes.findColumn("MonthNum");// key
			int value = queryRes.findColumn("MonthSum");// value
			while (queryRes.next()) {
				String monthnum = queryRes.getString(key);
				String monthsum = queryRes.getString(value);
				res.put(monthnum, monthsum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.close();
		}
		return res;
	}

	/**
	 * gets month payments from tenants
	 * 
	 * @return Map<String,String[]> key - apartment number value - amount payed per
	 *         month
	 * @throws SQLException
	 */

	public Map<String, ArrayList<String[]>> GetCommitteeTenantPayments() throws SQLException {
		String query = "select ApartmentNumber,MonthNum,AmountPayed from Payments;";
		ConectingToSQL();
		ResultSet queryRes = null;
		Map<String, ArrayList<String[]>> res = new HashMap<String, ArrayList<String[]>>();

		try {
			PreparedStatement pst = connect.prepareStatement(query);
			queryRes = pst.executeQuery();
			int aNumber = queryRes.findColumn("ApartmentNumber");// key
			int mSum = queryRes.findColumn("AmountPayed");// value
			int mNum = queryRes.findColumn("MonthNum");// value
			while (queryRes.next()) {
				String ApartmentNumber = queryRes.getString(aNumber);
				String MonthSum = queryRes.getString(mSum);
				String MonthNum = queryRes.getString(mNum);
				if (!res.containsKey(ApartmentNumber)) {
					res.put(ApartmentNumber, new ArrayList<String[]>());
				}
				;
				res.get(ApartmentNumber).add(new String[] { MonthNum, MonthSum });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.close();
		}
		return res;
	}

	/**
	 * inserts new payment or updates existing payment if exists
	 * 
	 * @param apartmentNum - number of paying apartment
	 * @param monthNum     - month to pay for
	 * @param amount       - amount needed to pay
	 * @throws SQLException
	 */
	public int Insert_UpdateTenentPayment(int apartmentNum, int monthNum, int amount) throws SQLException {
		String query = "call sp_insert_update(?,?,?)";
		ConectingToSQL();

		try {
			PreparedStatement pst = connect.prepareStatement(query);
			pst.setInt(1, apartmentNum);
			pst.setInt(2, monthNum);
			pst.setInt(3, amount);
			pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			connect.close();
			return 1;
		}

	}

	public void connection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("connection work");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ConectingToSQL() {

		connection();
		String host = "jdbc:mysql://localhost:3306/house?serverTimezone=UTC";
		String username = "root";
		String password = "1q2w3e4rasd";

		try {
			connect = (Connection) DriverManager.getConnection(host, username, password);
			System.out.println("ConectingToSQL work");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
