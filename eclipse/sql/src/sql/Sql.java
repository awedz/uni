package sql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;


public class Sql {

	private static Connection connect; 
	
	public static void delete_statement(){
		
		String sqldelete = "delete from student where h between ? and ? and name = ?";
		
		
		
		try {
			PreparedStatement pst = connect.prepareStatement(sqldelete);
			
			pst.setString(1, "180");
			pst.setString(2, "190");
			pst.setString(3, "effi");
			
			pst.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public static void update_statement(String name){
		
String sqlupdate = "UPDATE student SET name=?  WHERE id =? ";
		
		try {
			PreparedStatement pst = connect.prepareStatement(sqlupdate);
			
			pst.setString(1, name);
			pst.setString(2, "3344");
		//	pst.setString(3, "66127762");
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insert_statement(String s1 , String s2,String s3,String s4,String s5,String s6 ){
		
		String sqlInsert = "insert into test_inc.student (idhr,hr_name,hr_phone,hr_age,hr_address,hr_mail) values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = connect.prepareStatement(sqlInsert);
			pst.setString(1, s1);
			pst.setString(2, s2);
			pst.setString(3, s3);
			pst.setString(4, s4);
			pst.setString(5, s5);
			pst.setString(6, s6);
			
		
			pst.execute();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static void select_query()
	{
		
		try {// PreparedStatement - takes the java code select and replace it with sql code
			PreparedStatement statement = connect.prepareStatement("select * from Student order by group ");
			
			ResultSet result = statement.executeQuery();// execute the statement
			
			while(result.next())// take the rows in the result set
			{
				//getString(i) - take the col number i 
				System.out.println(result.getString(1) + result.getString(2) + result.getString(3)   );
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void connection()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");// connect to the driver jar file mysql connector 
			System.out.println("Works");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ConectingToSQL ()
	{
		
		connection();
		String host = "jdbc:mysql://localhost:3306/javaProject";
		String username = "root";//user name
		String password = "1q2w3e4rasd";// password of the sqlworkbanch
		
		try {
			 connect = (Connection) DriverManager.getConnection(host, username, password);
		System.out.println("work");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}