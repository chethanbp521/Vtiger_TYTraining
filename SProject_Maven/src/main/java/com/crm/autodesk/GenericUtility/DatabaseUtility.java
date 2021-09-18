package com.crm.autodesk.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains methods to read data from Database
 * @author Chethan
 *
 */
public class DatabaseUtility 
{
	Connection con = null;
	Driver driverRef;
	
	/**
	 * Establish connection with MYSQL Database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
	}
	
	/**
	 * Closes connection with the Database
	 * @throws Throwable 
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	public String getDataFromDB(String query, int Columnindex) throws Throwable
	{
		String value = null;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			value = result.getString(Columnindex);
		}
		return value;
	}

}
