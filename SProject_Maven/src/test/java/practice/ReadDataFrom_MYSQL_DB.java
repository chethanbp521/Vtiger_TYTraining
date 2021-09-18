package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_DB 
{
	public static void main(String[] args) throws Throwable  
	{
		//Register/Load the MYSQL Database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Connect to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
		
		//Create SQL Statement
		Statement stat = con.createStatement();
		String query = "select * from students_info";
		
		//Execute Statement/Query
		ResultSet res = stat.executeQuery(query);
		
		//Print the Result
		while(res.next())
		{
			System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3)
			+ "\t" + res.getString(4));
		}
		
		//Close the Connection
		con.close();
	}

}
