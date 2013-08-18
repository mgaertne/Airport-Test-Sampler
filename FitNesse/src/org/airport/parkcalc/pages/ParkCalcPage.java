package org.airport.parkcalc.pages;

import static org.openqa.selenium.By.xpath;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParkCalcPage {

	private static final DateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");
	private static final DateFormat TIME_FORMATTER = new SimpleDateFormat("hh:mm");
	private static final DateFormat AMPM_FORMATTER = new SimpleDateFormat("a");
			
	@FindBy(id = "ParkingLot")
	WebElement parkingLot;

	@FindBy(name = "Submit")
	WebElement calculateButton;

	@FindBy(name = "StartingDate")
	private WebElement startingDate;
	
	@FindBy(name = "StartingTime")
	private WebElement startingTime;
	
	@FindBy(name = "LeavingDate")
	private WebElement leavingDate;
	
	@FindBy(name = "LeavingTime")
	private WebElement leavingTime;
	
	private WebDriver driver;

	public ParkCalcPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectParkingLot(String parkingLot) {
		WebElement selectedOption = this.parkingLot
				.findElement(xpath("option[text() = '" + parkingLot + "']"));
		if (selectedOption != null) {
			selectedOption.click();
		}
	}

	public String parkingsCosts() {
		return driver.findElement(
						xpath("//tr[td/div[@class='SubHead'] = 'estimated Parking costs']/td/span/b"))
				.getText();
	}

	public void calculateParkingCosts() {
		calculateButton.click();
	}

	public void enterStartDateTime(Date startDate) {
		enterTextIntoField(startingDate, DATE_FORMATTER.format(startDate));
		enterTextIntoField(startingTime, TIME_FORMATTER.format(startDate));
		driver.findElement(xpath("//input[@name='StartingTimeAMPM' and @value='"+ AMPM_FORMATTER.format(startDate)+"']")).click();
	}
	
	public void enterEndDateTime(Date endDate) {
		enterTextIntoField(leavingDate, DATE_FORMATTER.format(endDate));
		enterTextIntoField(leavingTime, TIME_FORMATTER.format(endDate));
		driver.findElement(xpath("//input[@name='LeavingTimeAMPM' and @value='"+ AMPM_FORMATTER.format(endDate)+"']")).click();
	}
	
	private void enterTextIntoField(WebElement field, String text) {
		field.clear();
		field.sendKeys(text);
	}

}
