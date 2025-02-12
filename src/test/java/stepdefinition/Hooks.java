package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.SeleniumDriver;

public class Hooks {

	@Before
	public void setUp() {

		SeleniumDriver.setUpDriver();

	}

	@AfterStep
	public static void capturescreenshot(Scenario scenario) {
		if(scenario.isFailed())	{
		WebDriver driver = SeleniumDriver.getDriver();
		{
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes, "image/png", "screenshot");

		}
		}
	}

	@After
	public void close() {
		SeleniumDriver.tearDown();
}

}


