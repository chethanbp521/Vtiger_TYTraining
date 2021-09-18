package com.crm.autodesk.OrganisationsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.ExcelFileUtility;
import com.crm.autodesk.GenericUtility.JSONFileUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtilties;

public class TC_02_CreateOrganisationWithIndustry 
{
	WebDriver driver;

	@Test
	public void createOrganisationWithRandomNumber() throws Throwable
	{
		//Read Necessary Data
		JSONFileUtility jsonLib = new JSONFileUtility();
		ExcelFileUtility exLib = new ExcelFileUtility();
		WebDriverUtilties wLib = new WebDriverUtilties();
		JavaUtility jLib = new JavaUtility();
		
		String URL = jsonLib.readDataJSON("url");
		String BROWSER = jsonLib.readDataJSON("browser");
		String USERNAME = jsonLib.readDataJSON("username");
		String PASSWORD = jsonLib.readDataJSON("password");
		
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
		
		//Click on Organizations
		driver.findElement(By.linkText("Organizations")).click();
		
		//Click on Create Organisations Link
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Create New Organisation with Industry
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName+jLib.getRandomNum());
		WebElement ele = driver.findElement(By.name("industry"));
		wLib.select(ele, jsonLib.readDataJSON("industry"));
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		Thread.sleep(5000);
		
		//Logout of the Application
		WebElement elem = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, elem);
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
				
		//Close the Browser
		driver.close();
}
}
