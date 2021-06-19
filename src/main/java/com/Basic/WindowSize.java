package com.Basic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Width 1200
 * Height 800
 */

public class WindowSize {

	public static void main(String[] args) {
		WebDriver driver;
		
		//For Firefox launch
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		Dimension WindowMaximizeSize=driver.manage().window().getSize();
		
		System.out.println(WindowMaximizeSize);
		
		//set specific window size
		driver.manage().window().setSize(new Dimension(900,500));
		
		Dimension WindowSetSize=driver.manage().window().getSize();
		int Width=WindowSetSize.getWidth();
		int Height=WindowSetSize.getHeight();
		
		System.out.println("New window Width:"+Width);
		System.out.println("New window Height:"+Height);
		
		//driver.close();
		
		
	}

}
