package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class ReadDataFrom_Oracle_DB 
{
	public static void main(String[] args) throws Throwable  
	{
		//Register/Load the Oracle Database
		OracleDriver driverRef = new OracleDriver();
		DriverManager.registerDriver(driverRef);
		
		//Connect to the database
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
		
		//Create SQL Statement
		Statement stat = con.createStatement();
		String query = "select * from EMP";
		
		//Execute Statement/Query
		ResultSet res = stat.executeQuery(query);
		
		//Print the Result
		while(res.next())
		{
			System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t \t" + res.getInt(4));
		}
		
		//Close the Connection
		con.close();
	}

}
