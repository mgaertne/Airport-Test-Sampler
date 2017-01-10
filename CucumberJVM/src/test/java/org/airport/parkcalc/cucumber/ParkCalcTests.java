package org.airport.parkcalc.cucumber;

import org.airport.parkcalc.pages.ParkCalcPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.ChromeDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "junit:target/cucumber-junit-report.xml", "pretty" }, features = "features")
public class ParkCalcTests {

	private static WebDriver driver;
	public static ParkCalcPage page;

	@BeforeClass
	public static void SuiteSetUp() {
		ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
		driver.navigate().to("http://www.shino.de/parkcalc");
		page = PageFactory.initElements(driver, ParkCalcPage.class);
	}
	
	@AfterClass
	public static void suiteTearDown() {
		if (driver != null) driver.quit();
	}

}
