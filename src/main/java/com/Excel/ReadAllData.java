package com.Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ReadAllData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1: Create object for FileInputStream with excel file path
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Testdata-Excel\\ReadData.xlsx");

		//Step 2: Create Workbook object by using Workbookfactory class
		//Workbook
		Workbook wb=WorkbookFactory.create(fis);

		//Step 3: Create Sheet object from workbook object(wb), we have to pass the sheet name as parameter
		//Excel sheet
		Sheet sht=wb.getSheet("data");
		
		//Iterate through row one by one
		Iterator <Row> rowIterator=sht.iterator();
		
		while(rowIterator.hasNext())
		{
			Row row=rowIterator.next();
			
			//For each row iterate through all columns 
			Iterator<Cell> cellIterator=row.cellIterator();
			
			while(cellIterator.hasNext())
			{
				Cell cel=cellIterator.next();
				System.out.println('\n'+cel.getStringCellValue());
			}
		}
		
		fis.close();
	}

}
