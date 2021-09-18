package com.crm.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteExecution 
{
	@Test
	public void remoteExecutionTest() throws WebDriverException, MalformedURLException
	{
		URL url = new URL("http://15.207.55.233:4444/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		
		driver.get("https://google.com");
		
		driver.quit();
	}

}
