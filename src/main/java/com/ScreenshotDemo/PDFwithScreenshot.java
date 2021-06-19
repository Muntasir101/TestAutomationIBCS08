package com.ScreenshotDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFwithScreenshot {

	public static void main(String[] args) throws InterruptedException, DocumentException, MalformedURLException, IOException {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		driver=new FirefoxDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);

		//Take Screenshot
		byte[] input=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		Document document=new Document();
		
		String output=System.getProperty("user.dir")+"\\CustomPDF\\NewTest2.pdf";
		
		FileOutputStream fos=new FileOutputStream(output);
		
		//pdf writer
		PdfWriter writer=PdfWriter.getInstance(document, fos);
		
		//Open pdf for writing
		writer.open();
		document.open();
		
		//Process content into an image
		Image img=Image.getInstance(input);
		
		img.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
		
		//Add image to PDF
		document.add(img);
		document.add(new Paragraph(" "));
		
		//close the files and save to local driver
		document.close();
		writer.close();
		
		driver.close();
		
		

	}

}
