package practice;

import com.crm.autodesk.GenericUtility.ExcelFileUtility;

public class Demo 
{
	public static void main(String[] args) throws Throwable {
		
	ExcelFileUtility elib = new ExcelFileUtility();
	String CONTACT = elib.getExcelData("Sheet1", 2, 2);
	System.out.println(CONTACT);
	}
	
}
