package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	//Constructor
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactImg;

		
	//Getters
	public WebElement getCreateContactImg() 
	{
		return createContactImg;
	}
	
	//Business Methods
	public void clickCreateContact()
	{
		createContactImg.click();
	}
	
	public String createContactGetText()
	{
		return createContactImg.getAttribute("title");
	}
	
	

}
