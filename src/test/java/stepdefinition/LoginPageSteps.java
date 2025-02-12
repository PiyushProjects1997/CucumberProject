package stepdefinition;

import com.pages.LoginPage;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumDriver;

public class LoginPageSteps {

	public PageObjectManager pageobjectmanager;
	//public LoginPage login = new LoginPage();
/*
	public LoginPageSteps(PageObjectManager pageobjectmanager) {
		this.pageobjectmanager = pageobjectmanager;
	}
	*/
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	 SeleniumDriver.openPage();
	}

	@When("user enter valid credential")
	public void user_enter_valid_credential() {
	 pageobjectmanager.getLoginPage().dologin();
	 SeleniumDriver.waitForPageToLoad();
	}

	@Then("User should redirected to Home page")
	public void user_should_redirected_to_home_page() {
		Boolean text =pageobjectmanager.getHomePage().headertxt();
		
		System.out.println("Test Execution Completed");
	}
}
