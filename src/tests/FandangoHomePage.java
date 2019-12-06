package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	public void LogoVisibilityTest() {
		WebElement aab =	driver.findElement(By.xpath(bb.FandangoLOGO));
		boolean awq =aab.isDisplayed();
		try {
			Assert.assertEquals(awq, true);
			System.out.println("Fandango logo is visible");
			

			}
			catch(Exception e) {
				System.out.println(e);
			}

		}

		@Test(dependsOnMethods = {"LogoVisibilityTest"})
		public void LogoEnableTest() {
			boolean xyz = 	driver.findElement(By.xpath(bb.FandangoLOGO)).isEnabled();
			try {
				Assert.assertEquals(xyz, true);
				System.out.println("Fandango logo is enabled");
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

		@Test
		public void FandangoLoginTest() {
			try {
			ClickByXpath(bb.SignInBtn);
			TypeByXpath(bb.SN_Email,aa.Email);
			TypeByXpath(bb.SN_Pass,aa.Password);
			ClickByXpath(bb.SN_LOGin);
			String Membermessage =	driver.findElement(By.xpath(bb.Dashboard)).getText();
			String 	ACTmessage = Membermessage.trim();
			System.out.println(ACTmessage);
			Assert.assertEquals(ACTmessage, aa.expectedMessage, "SignIn was Successfull");
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		@Test
		public void demotest() {
			System.out.println("this is a test");// to check git on terminal******
		}
			
		
	}


