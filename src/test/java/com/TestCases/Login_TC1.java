package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Base.BaseClass;

public class Login_TC1 extends BaseClass {


	@Test(description="Login test with Valid emial and valid password")
	public void LoginTest() {
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		WebElement Email=driver.findElement(By.name("email"));
		WebElement Password=driver.findElement(By.name("password"));
		WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		boolean EmailField= Email.isEnabled();
		if(EmailField==true)
		{
			Email.sendKeys("maill22@mail.com");
		}
		else {
			System.out.println("Email filed desabled");
		}

		boolean passwordField= Password.isEnabled();
		if(passwordField==true)
		{
			Password.sendKeys("123456");
		}
		else {
			System.out.println("Password filed desabled");
		}

		boolean LoginButton=LoginBtn.isDisplayed();
		if(LoginButton==true)
		{
			LoginBtn.click();
		}	 
		else {
			System.out.println("Login Burron not display");
		}

		String ExpectedTitle="My Account";
		String ActualTile=driver.getTitle();

		if(ExpectedTitle.equals(ActualTile))
		{
			String Result="Login with valid credentails is Test Pass";
			System.out.println(Result);

		}

		else
		{
			String Result="Login with valid credentails is Test failed";
			System.out.println(Result);

		}


	}
}
