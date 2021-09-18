package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtilties;

public class HomePage extends WebDriverUtilties
{
	WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;

	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement signOutLink;
		
	//Getters
	public WebElement getContactsLink() 
	{
		return contactsLink;
	}
	
	public WebElement getAdministratorImg() 
	{
		return administratorImg;
	}
	
	public WebElement getSignOutLink() 
	{
		return signOutLink;
	}

	//Business Methods
	public void clickContactsLink()
	{
		contactsLink.click();
	}
	
	public void signOut(WebDriver driver)
	{
		mouseHover(driver, administratorImg);
		signOutLink.click();
	}

}
