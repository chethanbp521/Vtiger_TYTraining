package com.crm.autodesk.ContactsTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.CreateContactPage;
import com.crm.autodesk.objectRepository.HomePage;

public class CreateContactWithMultipleData extends BaseClass
{
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eLib.getExcelData("Sheet2");
	}
	
	@Test(dataProvider = "getData")
	public void createContactwithMultiple(String LastName, String LeadSource)
	{
		//Click on Contact Link
		HomePage homePg = new HomePage(driver);
		homePg.clickContactsLink();
				
		//Click Create new Contact
		ContactsPage contPg = new ContactsPage(driver);
		contPg.clickCreateContact();
				
		//Create Contact with Lead Source
		CreateContactPage createContPg = new CreateContactPage(driver);
		createContPg.createContact(LastName);
		createContPg.selectLeadSource(LeadSource);
		createContPg.clickSaveButton();
	}

}
