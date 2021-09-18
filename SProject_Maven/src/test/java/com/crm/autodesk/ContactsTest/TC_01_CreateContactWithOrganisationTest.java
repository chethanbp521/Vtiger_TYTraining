package com.crm.autodesk.ContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.ExcelFileUtility;
import com.crm.autodesk.GenericUtility.JSONFileUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtilties;


public class TC_01_CreateContactWithOrganisationTest 
{
	WebDriver driver;
	@Test
	public void createContactWithOrganisation() throws Throwable
	{
		//Read Necessary Data
		JSONFileUtility jsonLib = new JSONFileUtility();
		ExcelFileUtility exLib = new ExcelFileUtility();
		WebDriverUtilties wLib = new WebDriverUtilties();
		
		String URL = jsonLib.readDataJSON("url");
		String BROWSER = jsonLib.readDataJSON("browser");
		String USERNAME = jsonLib.readDataJSON("username");
		String PASSWORD = jsonLib.readDataJSON("password");

		String contactName = exLib.getExcelData("Sheet1", 1, 2);
		String orgName = exLib.getExcelData("Sheet1", 1, 3);
		
		//Launch Browser
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
		
		wLib.waitForPageLoad(driver);
		wLib.maximize(driver);
		driver.get(URL);
		
		//Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Create Contact Link
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Create New Contact
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//Switch to Child Window
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("C")).click();
		
		//Switch to Parent Window
		wLib.switchToWindow(driver, "Marketing");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		//Logout of the Application
		WebElement elem = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, elem);
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		
		//Close the Browser
		driver.close();
	}

}
