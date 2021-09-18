package com.crm.practice;

import java.time.LocalDateTime;

import com.crm.autodesk.GenericUtility.JSONFileUtility;

public class DemoFileReader 
{
	public static void main(String[] args) throws Throwable
	{
		//Create object for JSONFileUtility Generic class
		JSONFileUtility jsonlib = new JSONFileUtility();
		
		String URL = jsonlib.readDataJSON("url");
		System.out.println("url: " + URL);
		
		String USERNAME = jsonlib.readDataJSON("username");
		System.out.println("username: " + USERNAME);
		
	}

}
