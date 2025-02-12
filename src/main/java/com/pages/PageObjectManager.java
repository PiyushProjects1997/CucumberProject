package com.pages;

import org.openqa.selenium.WebDriver;

import utilities.SeleniumDriver;

public class PageObjectManager {

	public static WebDriver driver;
	public static LoginPage login;
	public static HomePage home;

	public PageObjectManager() {
		
	this.driver = SeleniumDriver.getDriver();

	}

	public static LoginPage getLoginPage() {
		login = new LoginPage();
		return login;
	}

	public static HomePage getHomePage() {
		home = new HomePage();
		return home;
	}

	}

