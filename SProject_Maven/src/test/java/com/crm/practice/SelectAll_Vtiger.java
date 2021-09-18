package com.crm.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.JSONFileUtility;

public class SelectAll_Vtiger 
{
	WebDriver driver;
	@Test
	public void selectAllTest() throws Throwable
	{
		//Create JSONFileUtility object to import data
		JSONFileUtility jsonlib = new JSONFileUtility();
		String URL = jsonlib.readDataJSON("url");
		String USERNAME = jsonlib.readDataJSON("username");
		String PASSWORD = jsonlib.readDataJSON("password");
		String browser = jsonlib.readDataJSON("browser");
		
		//Open browser based on JSON File
		if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
		//Enter URL from JSON
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Enter UserName from JSON
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//Enter Password from JSON
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//Click on Login Button
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Organisations tab
		driver.findElement(By.linkText("Organizations")).click();
		
		//Store the list of checkboxes
		List<WebElement> checklist = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		
		//Click on 5th(starts from 0) checkbox
		
		checklist.get(4).click();
		
		//Get Organisation name
		List<WebElement> orglist = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
		
		for (WebElement orgEle : orglist) 
		{
			String orgName = orgEle.getText();
			System.out.println(orgName);
		}
		//Delete 3th(3+2) checkbox & alert ok
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[8]/a[text()='del']")).click();
		driver.switchTo().alert().accept();
		
		//Click on all the checkboxes one by one
		for(WebElement chkEle:checklist) 
		{
			chkEle.click();
		}
		//Click/Deselect on last checkbox
		checklist.get(checklist.size()-1).click();
		
	}
	

}
