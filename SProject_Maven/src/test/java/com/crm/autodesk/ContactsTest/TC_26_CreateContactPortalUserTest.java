package com.crm.autodesk.ContactsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.CreateContactPage;
import com.crm.autodesk.objectRepository.HomePage;

/*@Listeners(com.crm.autodesk.GenericUtility.Listeners.class)*/
public class TC_26_CreateContactPortalUserTest extends BaseClass
{
	@Test (groups = "SmokeSuite", retryAnalyzer = com.crm.autodesk.GenericUtility.RetryAnalyzer.class)
	public void createContactPortalUser() throws Throwable
	{
		String CONTACT = eLib.getExcelData("Sheet1", 2, 2);
		
		//Click on Contact Link
		HomePage homePg = new HomePage(driver);
		homePg.clickContactsLink();
		
		//Click Create new Contact
		ContactsPage contPg = new ContactsPage(driver);
		contPg.clickCreateContact();
		
		//Create Contact and verify Portal User is enabled or not
		CreateContactPage createContPg = new CreateContactPage(driver);
		createContPg.createContact(CONTACT);
		
		//Assert.assertTrue(false);
		Assert.assertTrue(createContPg.verifyPortalChkBox());
		System.out.println("Portal Check Box is Enabled");
		createContPg.clickSaveButton();
		
	}

}
