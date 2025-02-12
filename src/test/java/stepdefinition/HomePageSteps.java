package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumDriver;

public class HomePageSteps {

//	public WebDriver driver;
//	public PageObjectManager pageobjectmanager;
	public HomePage home;

	// public LoginPage login = new LoginPage();
	/*
	 * public HomePageSteps(PageObjectManager pageobjectmanager) {
	 * this.pageobjectmanager=pageobjectmanager; }
	 */
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		SeleniumDriver.openPage();

		home = PageObjectManager.getLoginPage().dologin();

		// Assert.assertTrue(home.headertxt());
	}

	@When("Dropdown is displaying after post click on Searchbtn")
	public void dropdown_is_displaying_after_post_click_on_searchbtn() {
		home.clickonsharebtn();
	}

	@When("User click on logout btn")
	public void user_click_on_logout_btn() {
		home.clickonlogoutbtn();
		SeleniumDriver.waitForPageToLoad();
	}

	@Then("User should navigated back to LoginPage")
	public void user_should_navigated_back_to_login_page() {

		String text = PageObjectManager.getLoginPage().verifytext();
		System.out.println(text);
		
	}

}
