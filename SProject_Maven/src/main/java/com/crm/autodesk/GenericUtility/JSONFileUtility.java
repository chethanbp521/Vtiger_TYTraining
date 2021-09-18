package com.crm.autodesk.GenericUtility;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

/**
 * 
 * @author Chethan
 *
 */
public class JSONFileUtility 
{
	/**
	 * this method reads data from JSON file
	 * @throws Throwable 
	 */

	public String readDataJSON(String key) throws Throwable
	{
		//read data from json file
		FileReader file = new FileReader("./commonData.json");
		
		//convert json file to java object
		JSONParser jsonObj = new JSONParser();
		Object jObj = jsonObj.parse(file);
		
		//typecast java object to hashmap
		HashMap map = (HashMap)jObj;
		String value = map.get(key).toString();
		
		//return value
		return value;
	}
}
