package stepdefinition;

import java.util.List;
import java.util.Map;

import com.pages.PageObjectManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumDriver;

public class Datatables {

	@Given("User is on login page")
	public void user_is_on_login_page() {
			SeleniumDriver.openPage();
	}

	@When("User enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		System.out.println("Username is " + data.get(0).get("username")+"Password is " + data.get(0).get("password"));
		
	}

	@Then("User should able to logged in successfully.")
	public void user_should_able_to_logged_in_successfully() {
		System.out.println("Execution via datatable has been completed successfully");
	}

}
