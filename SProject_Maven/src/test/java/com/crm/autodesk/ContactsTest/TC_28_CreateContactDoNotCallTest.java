package com.crm.autodesk.ContactsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.objectRepository.ContactsInfoPage;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.CreateContactPage;
import com.crm.autodesk.objectRepository.HomePage;

public class TC_28_CreateContactDoNotCallTest extends BaseClass
{	
	@Test (groups = "RegressionSuite")
	public void createContactDoNotCall() throws Throwable
	{
		String CONTACT = eLib.getExcelData("Sheet1", 2, 2);
		
		//Click on Contact Link
		HomePage homePg = new HomePage(driver);
		homePg.clickContactsLink();
		
		//Click Create new Contact
		ContactsPage contPg = new ContactsPage(driver);
		contPg.clickCreateContact();
		
		//Create Contact with 'Do Not Call' Enabled
		CreateContactPage createContPg = new CreateContactPage(driver);
		createContPg.createContact(CONTACT);
		createContPg.clickDoNotCallChkBox();
		createContPg.clickSaveButton();
		
		//Verify Contact is created
		ContactsInfoPage conInfoPg = new ContactsInfoPage(driver);
		String actualTitle = conInfoPg.contactHeader();
		String expectedTitle = "Contact Information";
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		System.out.println("Contact created with Message : "+conInfoPg.contactHeader());
		
		String actualName = conInfoPg.contactName();
		String expectedName = CONTACT;
		Assert.assertTrue(actualName.contains(expectedName));
		System.out.println("Contact created with Name : "+conInfoPg.contactName());
		
	}

}
