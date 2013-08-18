package org.airport.parkcalc.helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriver {

	public static WebDriver driver;

	public static void startBrowserAt(String url) {
		driver = new FirefoxDriver();
		driver.navigate().to(url);
	}

	public static void closeAllBrowserWindows() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}
}
