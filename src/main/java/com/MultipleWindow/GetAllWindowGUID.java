package com.MultipleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetAllWindowGUID {

	public static void main(String[] args) {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");		
		ChromeOptions obj=new ChromeOptions();		
		obj.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});		
		driver=new ChromeDriver(obj);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		String ParentGUID=driver.getWindowHandle();
		System.out.println("Parent GUID: "+ParentGUID);
		
		WebElement NewWindowBtn=driver.findElement(By.linkText("Click Here"));
		NewWindowBtn.click();
		
		//Get all GUID of the Browser
		Set<String> allGUID=driver.getWindowHandles();
		System.out.println(allGUID);
		
		//Count total open Window
		System.out.println("Total Window: "+allGUID.size());
		
		

	}

}
