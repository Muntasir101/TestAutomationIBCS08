package com.TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestCase1 {
	WebDriver driver;

	@BeforeTest
	public void Browser_setup() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		driver=new FirefoxDriver();
	}

	@Test(description="Login with valid email and valid password")
	public void LoginAction() {
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		WebElement Email= driver.findElement(By.name("email"));
		WebElement Password= driver.findElement(By.name("password"));
		WebElement LoginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

		Email.sendKeys("mail22@mail.com");
		Password.sendKeys("123456");
		LoginBtn.click();
	}

	@AfterTest
	public void TestClose() {
		driver.quit();
	}
}
