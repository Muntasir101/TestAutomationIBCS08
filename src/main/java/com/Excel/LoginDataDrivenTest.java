package com.Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginDataDrivenTest {

	WebDriver driver;
	Workbook wb;
	Sheet sht;
	
	@BeforeTest
	public void Browser_setup() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		driver=new FirefoxDriver();
	}

	@Test
	public void login() throws InterruptedException, EncryptedDocumentException, IOException {

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		Thread.sleep(3000);
		
		/*
		 * Start Excel implementation
		 */
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Testdata-Excel\\RealImplementation.xlsx");
		wb=WorkbookFactory.create(fis);
		sht=wb.getSheet("data");
		
		/*
		 * Getting Email and password
		 */
		Row Email_rw=sht.getRow(1);
		
		Cell Email_cel=Email_rw.getCell(0);
		
		String Email=Email_cel.getStringCellValue();
		
		/*
		 * Getting Password
		 */
		@SuppressWarnings("unused")
		Row Password_rw=sht.getRow(1);
	//	Cell String_Password_cel=Password_rw.getCell(1);
		Cell Numeric_Password_cel=sht.getRow(1).getCell(1);

		//If password String value
	//	String Password_String=String_Password_cel.getStringCellValue();
		
		//If numeric
		DataFormatter formatter=new DataFormatter();
		String Password_Numeric=formatter.formatCellValue(Numeric_Password_cel);
		
		//real Implementation
		WebElement email= driver.findElement(By.name("email"));
		WebElement password= driver.findElement(By.name("password"));
		WebElement loginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

		email.sendKeys(Email);
		password.sendKeys(Password_Numeric);
		loginBtn.click();
		
		/*
		 * Message to be written in the excel
		 * Implement login for pass or fail
		 */
		
		FileOutputStream fout=new FileOutputStream(System.getProperty("user.dir")+"\\Testdata-Excel\\RealImplementation.xlsx");
		
		String ExpectedTitle="My Account";
		String ActualTile=driver.getTitle();
		
		if(ExpectedTitle.equals(ActualTile))
		{
			String Result="Test Pass";
			sht.getRow(1).createCell(3).setCellValue(Result);
			System.out.println("Test pass Result write to Excel Success.");
		}
		
		else
		{
			String Result="Test failed";
			sht.getRow(1).createCell(3).setCellValue(Result);
			System.out.println("Test Fail Result write to Excel Success.");
		}
		
		wb.write(fout);
		fout.close();
		
		driver.close();
	}


}
