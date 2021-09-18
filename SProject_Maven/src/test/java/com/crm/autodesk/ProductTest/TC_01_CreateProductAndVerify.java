package com.crm.autodesk.ProductTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.ExcelFileUtility;
import com.crm.autodesk.GenericUtility.JSONFileUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtilties;

public class TC_01_CreateProductAndVerify 
{
	WebDriver driver;
	@Test
	public void createProductAndVerify() throws Throwable
	{
		//Read Necessary Data
		JSONFileUtility jsonLib = new JSONFileUtility();
		ExcelFileUtility exLib = new ExcelFileUtility();
		WebDriverUtilties wLib = new WebDriverUtilties();
		
		String URL = jsonLib.readDataJSON("url");
		String BROWSER = jsonLib.readDataJSON("browser");
		String USERNAME = jsonLib.readDataJSON("username");
		String PASSWORD = jsonLib.readDataJSON("password");

		String product = exLib.getExcelData("Sheet1", 1, 5);
		String productcode = exLib.getExcelData("Sheet1", 1, 6);
		
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
		
		//Click on Products
		driver.findElement(By.linkText("Products")).click();
		
		//Click on Create Product Link
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//Create Product with Part Number
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.id("productcode")).sendKeys(productcode);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		//Copy Product Number
		WebElement exp = driver.findElement(By.xpath("//td[contains(text(),'PR')]"));
		String expected = exp.getText();
		
		//Click on Products
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.name("search_text")).sendKeys(productcode);
		WebElement ele = driver.findElement(By.id("bas_searchfield"));
		wLib.select(ele, "Part Number");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		
		Thread.sleep(2000);
		
		//Verify by Product Name
		List<WebElement> prEle = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
		for (WebElement ele1 : prEle) 
		{
			String actual = ele1.getText();
		
			if(expected.contains(actual))
			{
				System.out.println("Product is created successfully: Pass");
				break;
			}
			
		}
		//Logout of the Application
		WebElement elem = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, elem);
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
						
		//Close the Browser
		driver.close();

}
}
