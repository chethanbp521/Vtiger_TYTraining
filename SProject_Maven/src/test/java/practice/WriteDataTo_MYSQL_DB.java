package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WriteDataTo_MYSQL_DB 
{
	public static void main(String[] args) throws Throwable 
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
		
		Statement stat = con.createStatement();
		String query = "insert into students_info (regno, firstname, middlename, lastname) values('9', 'ram','gowda', 'hassan')";
		
		int res = stat.executeUpdate(query);
		if(res == 1)
		{
			System.out.println("User is Created");
		}
		else
		{
			System.out.println("User is not Created");
		}
		
		con.close();
		
	}

}
