package org.airport.parkcalc.fixtures;
import static org.airport.parkcalc.helper.BrowserDriver.driver;
import static org.airport.parkcalc.helper.ParkingDuration.durationFor;
import static org.openqa.selenium.support.PageFactory.initElements;

import org.airport.parkcalc.helper.ParkingDuration;
import org.airport.parkcalc.pages.ParkCalcPage;

public class ParkingCostsFor {

	private String parkingLot;
	private String duration;
	private String parkingCosts;

	public ParkingCostsFor(String parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	public void setParkingDuration(String duration) {
		this.duration = duration;
	}
	
	public void execute() {
		ParkCalcPage page = initElements(driver, ParkCalcPage.class);
		page.selectParkingLot(parkingLot);
		ParkingDuration duration = durationFor(this.duration);
		page.enterStartDateTime(duration.start());
		page.enterEndDateTime(duration.end());
		page.calculateParkingCosts();
		parkingCosts = page.parkingsCosts();
	}

	public String parkingCosts() {
		return parkingCosts;
	}
	
	public void reset() {
		parkingCosts = "";
	}
}
