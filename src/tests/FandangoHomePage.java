package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Config;
import locators.FDNG_Locators;
import util.DriverMethod;
import values.FDNG_Values;

public class FandangoHomePage extends Config {

	FDNG_Values aa = new FDNG_Values();
	FDNG_Locators bb = new FDNG_Locators();
	DriverMethod cc = new DriverMethod();

	@Test
	public void FandangoURL() {
		String actURL =	driver.getCurrentUrl();
		System.out.println(actURL);
		if(actURL==aa.EXPTDurl) {
			System.out.println("Landed on Correct URL");
		}
		else {
			System.out.println("Test#1: Didnt Land of the Correct URL");
		}

	}

	@Test
	public void FandangoTittleTest() {
		String actdTittle =	driver.getTitle();
		if(actdTittle==aa.EXPTDtittle) {
			System.out.println("Fandango tittle is as expected");
		}
		else {
			System.out.println("Fandango Tittle Did not Match");
		}
	}


	@Test
	public void LogoVisibilityTest(String Locator) {
		boolean awq =	driver.findElement(By.xpath(bb.FandangoLOGO)).isDisplayed();
		if(awq==true) {
			System.out.println("Fandango logo is Displayed");
		}

	}

	@Test(dependsOnMethods = {"LogoVisibilityTest"})
	public void LogoEnableTest(String Locator) {
		boolean xyz = 	driver.findElement(By.xpath(bb.FandangoLOGO)).isEnabled();
		if(xyz==true) {
			System.out.println("Fandango logo is Enabled");
		}
	}
	
	@Test
	public void FandangoLoginTest() {
		ClickByXpath(bb.SignInBtn);
		TypeByXpath(bb.SN_Email,aa.Email);
		TypeByXpath(bb.SN_Pass,aa.Password);
		ClickByXpath(bb.SN_LOGin);
	String Membermessage =	driver.findElement(By.xpath(bb.Dashboard)).getText();
	String 	ACTmessage = Membermessage.trim();
	System.out.println(ACTmessage);
	Assert.assertEquals(ACTmessage, aa.expectedMessage, "SignIn was Successfull");
	}
}


