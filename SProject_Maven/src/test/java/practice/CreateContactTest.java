package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateContactTest 
{
	@Test
	public void contactTest() throws InterruptedException
	{
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		String browser = System.getProperty("browserName");
		WebDriver driver = null;
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
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		WebElement ele = driver.findElement(By.name("salutationtype"));
		Select s = new Select(ele);
		s.selectByValue("Mr.");
		
		driver.findElement(By.name("firstname")).sendKeys("FirstName");
		driver.findElement(By.name("lastname")).sendKeys("LastName");
		driver.findElement(By.name("account_name")).sendKeys("Org");
		driver.findElement(By.id("mobile")).sendKeys("9876543210");
		driver.findElement(By.name("emailoptout")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
