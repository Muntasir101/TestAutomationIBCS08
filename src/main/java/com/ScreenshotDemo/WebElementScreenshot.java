package com.ScreenshotDemo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");		
		driver=new FirefoxDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		//Locate image Element to Capture
		WebElement ScearchBox=driver.findElement(By.name("search"));
		
		//Capture page Screenshot
		File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Using Selenium point class to get X and Y coordinate of image
		Point point=ScearchBox.getLocation();
		
		int Xcoordinate=point.getX();
		int Ycoordinate=point.getY();
		
		//Using Selenium getSize() to get Height and Width of Element 
		int imageWidth=ScearchBox.getSize().getWidth();
		int imageHeight=ScearchBox.getSize().getHeight();
		
		//Read full image screenshot 
		BufferedImage img=ImageIO.read(SrcFile);
		
		//cut image using X,Y coordinate and Height,Width
		BufferedImage FinalImage=img.getSubimage(Xcoordinate, Ycoordinate, imageWidth, imageHeight);
		
		ImageIO.write(FinalImage, "PNG", SrcFile);
		
		//Save image in drive
		FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir")+"\\ScreenShots\\ElementScreenshot.png"));
		
		driver.close();
		
		

	}

}
