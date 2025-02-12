package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumDriver;

public class HomePage extends PageObjectManager {
//	public static WebDriver driver;

//	public HomePage(WebDriver driver) {
//		this.driver = SeleniumDriver.getDriver();
//	}

	By shareicon = By.xpath("//*[@id=\"top-header-menu\"]/div[2]/div[2]/div/i");
	By logout = By.xpath("//*[@id=\"top-header-menu\"]/div[2]/div[2]/div/div/a[9]/span");
	By headertext = By.xpath("//*[@id=\"top-header-menu\"]/div[2]/span[1]");

	public void clickonsharebtn() {
		WebElement elements = driver.findElement(shareicon);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elements);
	}

	public void clickonlogoutbtn() {
		WebElement elementss = driver.findElement(logout);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementss);
	}

	public  Boolean headertxt() {
		return driver.findElement(headertext).isDisplayed();
	}

}
