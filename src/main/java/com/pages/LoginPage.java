package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumDriver;

public class LoginPage extends PageObjectManager {
	
	By usrname = By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input");
	By pswrd = By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input");
	By clckbtn = By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]");
	
	public HomePage dologin()
	{
		driver.findElement(usrname).sendKeys("piyushgolu9199@gmail.com");
		driver.findElement(pswrd).sendKeys("Piyush@1995");
		WebElement element=driver.findElement(clckbtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage();
	}
	
	public String verifytext()
	{
		
		return driver.getCurrentUrl();
	}

}
