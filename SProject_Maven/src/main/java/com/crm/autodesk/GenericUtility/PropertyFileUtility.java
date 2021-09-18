package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains methods to read Data from Property File
 * @author Chethan
 *
 */
public class PropertyFileUtility 
{
	/**
	 * This method reads data from Property File
	 * @throws Throwable 
	 */
	public String getPropertyFileData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.PropertyFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		
		return value;
	}
}
