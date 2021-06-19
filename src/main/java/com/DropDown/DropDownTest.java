package com.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");

		ChromeOptions obj=new ChromeOptions();

		obj.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

		driver=new ChromeDriver(obj);

		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		WebElement Dropdown=driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
		
		Select drobj=new Select(Dropdown);
		
		Thread.sleep(5000);
		
		//SelectByValue()
		//drobj.selectByValue("2");
		
		
		//SelectByVaisible() Text
		//drobj.selectByVisibleText("Option 1");
		
		//SelectByIndex()
		drobj.selectByIndex(1);
		
	}

}
