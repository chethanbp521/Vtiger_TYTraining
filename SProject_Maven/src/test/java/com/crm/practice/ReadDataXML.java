package com.crm.practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataXML 
{
	@Test
	public void readDataXML(XmlTest xmlobj)
	{
		System.out.println(xmlobj.getParameter("browser"));
		System.out.println(xmlobj.getParameter("url"));
		System.out.println(xmlobj.getParameter("username"));
	}

}
