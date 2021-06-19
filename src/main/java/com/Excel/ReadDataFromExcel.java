package com.Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1: Create object for FileInputStream with excel file path
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Testdata-Excel\\ReadData.xlsx");

		//Step 2: Create Workbook object by using Workbookfactory class
		//Workbook
		Workbook wb=WorkbookFactory.create(fis);

		//Step 3: Create Sheet object from workbook object(wb), we have to pass the sheet name as parameter
		//Excel sheet
		Sheet sht=wb.getSheet("Sheet1");

		//Step 4: Create Row object from sheet object. We have to pass Row number as parameter
		//Excel Row
		Row rw=sht.getRow(3);

		//Step 5: Create Cell object from Row object. We have to pass Cell number as parameter
		//Excel Cell
		Cell cel=rw.getCell(0);

		//Read Row,Column(1,0)
		String Email1=cel.getStringCellValue();
		System.out.println(Email1);

	}

}
