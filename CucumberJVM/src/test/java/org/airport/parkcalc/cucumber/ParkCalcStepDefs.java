package org.airport.parkcalc.cucumber;

import static org.airport.parkcalc.cucumber.ParkCalcTests.page;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.airport.parkcalc.pages.ParkingDuration;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParkCalcStepDefs {

	@When("^I park my car in the (.*) Lot for (.*)$")
	public void whenIParkMyCarAtFor(String parkingLot, String duration) {
		page.selectParkingLot(parkingLot);

		ParkingDuration parkingDuration = ParkingDuration.durationFor(duration);
		page.enterStartDateTime(parkingDuration.start());
		page.enterEndDateTime(parkingDuration.end());
		page.calculateParkingCosts();
	}

	@Then("^I will have to pay (.*)$")
	public void thenIWillHaveToPay(String parkingCosts) {
		assertThat(page.parkingsCosts(), is(equalTo(parkingCosts)));
	}
}
