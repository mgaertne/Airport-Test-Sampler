package org.airport.parkcalc.helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BrowserDriver {

	public static WebDriver driver;

	public static void startBrowserAt(String url) {
		ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
		driver.navigate().to(url);
	}

	public static void closeAllBrowserWindows() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}
}
