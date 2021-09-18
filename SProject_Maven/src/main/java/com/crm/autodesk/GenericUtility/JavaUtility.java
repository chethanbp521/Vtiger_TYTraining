package com.crm.autodesk.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This method contains generic Java methods
 * @author Chethan
 *
 */
public class JavaUtility 
{
	/**
	 * This method generates random number below 1000
	 */
	public int getRandomNum()
	{
		Random rndm = new Random();
		int randomNum = rndm.nextInt(1000);
		return randomNum;
	}
	
	public String getDateandTime()
	{
		Date d = new Date();
		String date = d.toString().replaceAll(":", "-");
		return date;
	}

}
