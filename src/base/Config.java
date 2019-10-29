package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import util.DriverMethod;

public class Config extends DriverMethod {
	

	@Parameters("Browser")
	@BeforeMethod()
	
	public void setup(String Browser) {
		
		
		if(Browser.equalsIgnoreCase("chrome")) { //configure browser properties
			System.setProperty("webdriver.chrome.driver","/users/jewel/git/Yahoo_Test/Drivers/chromedriver");
			driver = new ChromeDriver();//initiate the chrome browser
		}
		
		else if(Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/users/jewel/git/Yahoo_Test/geckodriver");
			driver = new FirefoxDriver();//initiate the firefox browser
		}
		
		driver.get("https://www.fandango.com/");// get to requested URL/DOMAIN
		
		pageload();
		maxscreen();
		deletecookies();
		waitTime();
	}
	
	
	
	
	@AfterMethod()
	public void closebrowser() {
		driver.quit(); // CLOSING BROWSER AFTER EVERY TEST.
	}
	


}
