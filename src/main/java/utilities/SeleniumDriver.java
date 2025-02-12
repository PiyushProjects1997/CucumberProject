package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumDriver {

	private static SeleniumDriver seleniumDriver;
	 
    //initialize webdriver
    private static WebDriver driver;
    
    //initialize timeouts
    private static WebDriverWait waitDriver;
    //initiliase properties
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static Logger log = Logger.getLogger(SeleniumDriver.class.getName());


	//public WebDriverWait wait;
	private FileInputStream fis;
	

    private  SeleniumDriver() {
    	
    	
    	PropertyConfigurator
		.configure(System.getProperty("user.dir") + "/src/test/resources/properties/log4j.properties");
    	
    	try {
			fis = new FileInputStream("./src/test/resources/properties/Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (config.getProperty("browser").equals("chrome")) {

			driver = new ChromeDriver();
			log.info("Chrome Browser has been Launched");

		} else if (config.getProperty("browser").equals("firefox")) {

			driver = new FirefoxDriver();
	
		}


        driver.manage().window().maximize();

        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
    
       
    }

    public static void openPage() {

        driver.get(config.getProperty("testsiteurl"));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
       if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver();
      
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
          driver.quit();
        }
        seleniumDriver = null;
    }
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}