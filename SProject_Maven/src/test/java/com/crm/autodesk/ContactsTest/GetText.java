package com.crm.autodesk.ContactsTest;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.HomePage;

public class GetText extends BaseClass
{
	@Test
	public void CreateContactwithGetText()
	{
		HomePage hp = new HomePage(driver);
		hp.clickContactsLink();
		
		ContactsPage conPg = new ContactsPage(driver);
		System.out.println(conPg.createContactGetText());
	}

}
