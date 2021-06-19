package com.Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		//Blank Workbook
		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//Create blank sheet
		XSSFSheet sheet=workbook.createSheet("TestData");
		
		//Data Insert
		Map<String,Object[]> data=new TreeMap<String , Object[]>();
		
		data.put("1", new Object[] {"Test case ID", "Email", "password"});
		data.put("2", new Object[] {"TC_001", "Email1@mail.com", "123456"});
		data.put("3", new Object[] {"TC_002", "Email2@mail.com", "USA"});
		data.put("4", new Object[] {"TC_003", "Email3@mail.com", "UK"});
		
		//Iterate over data and write to sheet
		Set<String> keyset=data.keySet();
		
		
		int rownum=0;
		
		for(String key:keyset)
		{
			Row row=sheet.createRow(rownum++);
			Object[] objArr=data.get(key);
			int cellnum=0;
			
			for(Object obj:objArr)
			{
				Cell cell=row.createCell(cellnum++);
				if(obj instanceof String)
					cell.setCellValue((String)obj);
				
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
				
			}
		}
		
		//Create file
		FileOutputStream fout=new FileOutputStream(System.getProperty("user.dir")+"\\Testdata-Excel\\MyCreateData.xlsx");

		workbook.write(fout);
		
		fout.close();
		
		System.out.println("Successfully data created on Excel");
	}

}
