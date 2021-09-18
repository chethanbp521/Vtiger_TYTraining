package com.crm.autodesk.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;

public class BaseClass 
{
	public WebDriverUtilties wLib = new WebDriverUtilties();
	public JavaUtility jLib = new JavaUtility();
	public JSONFileUtility jsonLib = new JSONFileUtility();
	public DatabaseUtility dbLib = new DatabaseUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;
	
	@BeforeSuite (groups = {"RegressionSuite","SmokeSuite"})
	public void openConnection() throws Throwable
	{
		//dbLib.connectToDB();
		System.out.println("---Connect to Database---");
	}
	//@Parameters("browser")
	@BeforeClass (groups = {"RegressionSuite","SmokeSuite"})
	public void launchBrowser() throws Throwable
	{
		String BROWSER = jsonLib.readDataJSON("browser");
		String URL = jsonLib.readDataJSON("url");
		
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		wLib.maximize(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		//Listener static
		staticdriver = driver;
		System.out.println("---Launch Browser---");
	}
	/**
	 * Browser Launch for Compatiblity Testing
	 * @param BROWSER
	 * @throws Throwable
	 */
	/*public void launchBrowser(String BROWSER) throws Throwable
	{
		String URL = jsonLib.readDataJSON("url");
			
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		wLib.maximize(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		System.out.println("---Launch Browser---");
	}*/
	
	@BeforeMethod (groups = {"RegressionSuite","SmokeSuite"})
	public void loginToApp() throws Throwable
	{
		String USERNAME = jsonLib.readDataJSON("username");
		String PASSWORD = jsonLib.readDataJSON("password");
		
		LoginPage logPg = new LoginPage(driver);
		logPg.login(USERNAME, PASSWORD);
		System.out.println("---Login to App---");
	}
	
	@AfterMethod (groups = {"RegressionSuite","SmokeSuite"})
	public void logoutFromApp()
	{
		HomePage homePg = new HomePage(driver);
		homePg.signOut(driver);
		System.out.println("---Logout from App---");
	}
	
	@AfterClass (groups = {"RegressionSuite","SmokeSuite"})
	public void closeBrowser()
	{
		driver.close();
		System.out.println("---Close Browser---");
	}
	
	@AfterSuite (groups = {"RegressionSuite","SmokeSuite"})
	public void closeConnection() throws Throwable
	{
		//dbLib.closeDB();
		System.out.println("---Close Connection to Database---");
	}
	
	
	public String getScreenshot(String name) throws IOException
	{
		JavaUtility jLib = new JavaUtility();
		File srcfile = ((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"/Screenshots/"+name+jLib.getDateandTime()+".png";
		File finaldest = new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		
		return destfile;
	}

}
