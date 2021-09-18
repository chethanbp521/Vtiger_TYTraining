package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains methods to read and write data from Excel Sheet
 * @author Chethan
 *
 */
public class ExcelFileUtility 
{
	/**
	 * this method will read data from Excel sheet with row number and cell number
	 * @param sheetName 
	 * @param rowNum 
	 * @param cellNum 
	 * @return 
	 * @throws Throwable 
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws  Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = format.formatCellValue(cell);
		
		return value;
	}
	
	public Object[][] getExcelData(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	

}
