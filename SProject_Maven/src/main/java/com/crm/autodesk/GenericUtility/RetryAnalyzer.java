package com.crm.autodesk.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int count = 0;
	int retrycount = 3;

	public boolean retry(ITestResult result) 
	{
		while(count<retrycount)
		{
			count++;
			return true;
		}
	return false;
	}	

}
