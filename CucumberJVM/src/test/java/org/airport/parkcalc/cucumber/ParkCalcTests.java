package org.airport.parkcalc.cucumber;

import org.airport.parkcalc.pages.ParkCalcPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = { "junit:target/cucumber-junit-report.xml", "pretty" }, features = "features")
public class ParkCalcTests {

	private static WebDriver driver;
	public static ParkCalcPage page;

	@BeforeClass
	public static void SuiteSetUp() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.shino.de/parkcalc");
		page = PageFactory.initElements(driver, ParkCalcPage.class);
	}
	
	@AfterClass
	public static void suiteTearDown() {
		if (driver != null) driver.quit();
	}

}
