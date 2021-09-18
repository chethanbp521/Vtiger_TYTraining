package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtilties;

public class ContactsInfoPage extends WebDriverUtilties
{
	WebDriver driver;
	//Constructor
	public ContactsInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	@FindBy(id = "mouseArea_Last Name")
	private WebElement contactName;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement signOutLink;


	//Getters
	public WebElement getContactHeader() 
	{
		return contactHeader;
	}

	public WebElement getContactName() 
	{
		return contactName;
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
	public String contactHeader()
	{
		return contactHeader.getText();
	}
	
	public String contactName()
	{
		return contactName.getText();
	}
	
	public void signOut(WebDriver driver)
	{
		mouseHover(driver, administratorImg);
		signOutLink.click();
	}
	
	

}
