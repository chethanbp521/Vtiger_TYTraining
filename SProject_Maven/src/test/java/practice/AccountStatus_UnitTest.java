package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class AccountStatus_UnitTest 
{
	@Test
	public void testAccountType() throws SQLException 
	{
		Connection con = null;
		try
		{
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "root");
			
			Statement stat = con.createStatement();
			String query = "select * from account_info";
			
			ResultSet res = stat.executeQuery(query);
			while(res.next())
			{
				int accNum = res.getInt("acc_no");
				System.out.println(accNum);
				
				if(accNum == res.getInt("acc_no")  && res.getString("acc_type").equals("Gold"))
				{
					System.out.println("Account is Gold, Verified = 'Pass'");
					//break;
				}
				else
				{
					System.out.println("Account type is not Gold, Verified = 'Fail'");
				}
				
			}
			
		}
		catch (Exception e)
		{
			System.err.println("Account type is not Gold, Verified = 'Fail'");
		}
		finally
		{
			con.close();
		}
	}

}
