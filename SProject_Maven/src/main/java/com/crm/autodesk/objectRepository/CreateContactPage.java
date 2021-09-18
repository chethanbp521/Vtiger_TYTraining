package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtilties;

public class CreateContactPage extends WebDriverUtilties 
{
	WebDriver driver;
	
	//Constructor
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "emailoptout")
	private WebElement emailOptoutChkbox;
	
	@FindBy(name = "donotcall")
	private WebElement doNotCallChkbox;
	
	@FindBy(name = "reference")
	private WebElement referenceChkbox;
	
	@FindBy(name = "notify_owner")
	private WebElement notifyOwnerChkbox;
	
	@FindBy(name = "portal")
	private WebElement portalUserChkbox;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;

	
	//Getters
	public WebElement getLastNameEdt() 
	{
		return lastNameEdt;
	}

	public WebElement getEmailOptoutChkbox() 
	{
		return emailOptoutChkbox;
	}

	public WebElement getDoNotCallChkbox() 
	{
		return doNotCallChkbox;
	}

	public WebElement getReferenceChkbox() 
	{
		return referenceChkbox;
	}

	public WebElement getNotifyOwnerChkbox() 
	{
		return notifyOwnerChkbox;
	}

	public WebElement getPortalUserChkbox() 
	{
		return portalUserChkbox;
	}
	
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
	//Business Methods
	public void createContact(String name)
	{
		lastNameEdt.sendKeys(name);
	}
	
	public void clickSaveButton()
	{
		saveBtn.click();
	}
	
	public boolean verifyPortalChkBox()
	{
		return portalUserChkbox.isEnabled();
		
	}
	
	public void clickEmailOptoutChkBox()
	{
		emailOptoutChkbox.click();
	}
	
	public void clickDoNotCallChkBox()
	{
		doNotCallChkbox.click();
	}
	
	public void clickReferenceChkBox()
	{
		referenceChkbox.click();
	}
	
	public void clickNotifyOwnerChkBox()
	{
		notifyOwnerChkbox.click();
	}
	
	public void selectLeadSource(String LeadSource)
	{
		select(leadSourceDropDown, LeadSource);
	}

}
