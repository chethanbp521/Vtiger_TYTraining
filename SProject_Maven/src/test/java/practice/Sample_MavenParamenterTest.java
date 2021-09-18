package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Sample_MavenParamenterTest {

	@Test
	public void sampleTest()
	{
		System.out.println("EXECUTE TEST");
		String Url = System.getProperty("url");
		String UserName = System.getProperty("username");
		String Password = System.getProperty("password");
		
		System.out.println(Url);
		System.out.println(UserName);
		System.out.println(Password);
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		
		driver.close();
	}
}
