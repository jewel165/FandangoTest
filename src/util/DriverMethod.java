package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DriverMethod {
	

	public WebDriver driver;

	//Proper pageload/waittime

	public void maxscreen() {
		driver.manage().window().maximize(); // maximize the browser
	}

	public void deletecookies() {
		driver.manage().deleteAllCookies(); //delete all cookies
	}

	public void waitTime() { //implicitwaittime
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void pageload() { // time to load the page contents.
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	//All Clicks
	public void ClickByXpath(String Locator) {
		driver.findElement(By.xpath(Locator)).click();
	}
	
	public void ClickById(String Locator) {
		driver.findElement(By.id(Locator)).click();
	}
	
	public void ClickByCSS(String Locator) {
		driver.findElement(By.cssSelector(Locator)).click();
	}
	//All Types/input
	public void TypeByXpath(String Locator , String Value) {
		driver.findElement(By.xpath(Locator)).sendKeys(Value);
	}
	public void TypeById(String Locator, String Value) {
		driver.findElement(By.id(Locator)).sendKeys(Value);
	}
	

}
