package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lenskart 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.lenskart.com/");
		driver.findElement(By.xpath("//input[@class='search_input-bar autoSuggest']")).click();
		List<WebElement> elem = driver.findElements(By.xpath("//div[@class='trending']"));
		for (WebElement B : elem) 
		{
			System.out.println(B.getText());
		}
		driver.findElement(By.linkText("Aviator")).click();
	}
}
