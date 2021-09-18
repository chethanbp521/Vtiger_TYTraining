package com.crm.autodesk.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listeners implements ITestListener
{
	ExtentReports reports; //Attach the reporter
	ExtentTest test; //Make entries of test cases and logs

	public void onTestStart(ITestResult result) 
	{
		test = reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL, result.getName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		BaseClass baseclass = new BaseClass();
		try {
			String path = baseclass.getScreenshot(result.getName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, result.getMethod().getMethodName()+" Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{		
		JavaUtility jLib = new JavaUtility();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/ExtentReport "+jLib.getDateandTime()+".html");  
		reporter.config().setDocumentTitle("Test Yantra SDET 21");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("BuildNo", "5.1");
		reports.setSystemInfo("Env", "Test");
		reports.setSystemInfo("Platform", "Windows");
		reports.setSystemInfo("Browser", "Firefox");
	}

	public void onFinish(ITestContext context) 
	{
		reports.flush();
	}

}
