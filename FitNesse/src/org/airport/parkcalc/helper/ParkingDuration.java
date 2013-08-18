package org.airport.parkcalc.helper;

import java.util.Calendar;
import java.util.Date;

public enum ParkingDuration {

	HALF_HOUR("30 minutes", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 0, 30)),
	ONE_HOUR("1 hour", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 1, 0)),
	THREE_HOURS("3 hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 3, 0)),
	THREE_HOURS_THIRTY_MINUTES("3 hours 30 minutes", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 3, 30)),
	FOUR_HOURS("4 hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 4, 0)),
	FIVE_HOURS("5 hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 5, 0)),
	FIVE_HOURS_ONE_MINUTE("5 hours 1 minute", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 5, 1)),
	SIX_HOURS("6 hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 6, 0)),
	SEVEN_HOURS("7 hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 7, 0)),
	TWELVE_HOURS("12 hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 12, 0)),
	TWELVE_HOURS_THIRTY_MINUTES("12 hours 30 minutes", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(4, Calendar.MAY, 1979, 12, 30)),
	TWENTYFOUR_HOURS("24 hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(5, Calendar.MAY, 1979, 0, 0)),
	ONE_DAY_ONE_MINUTE("1 day 1 minute", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(5, Calendar.MAY, 1979, 0, 1)),
	ONE_DAY_THIRTY_MINUTES("1 day 30 minutes", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(5, Calendar.MAY, 1979, 0, 30)),
	ONE_DAY_ONE_HOUR("1 day 1 hour", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(5, Calendar.MAY, 1979, 1, 0)),
	ONE_DAY_ONE_HOUR_VERBALLY("one day, one hour", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(5, Calendar.MAY, 1979, 1, 0)),
	ONE_DAY_THREE_HOURS("one day, three hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(5, Calendar.MAY, 1979, 3, 0)),
	ONE_DAY_FIVE_HOURS("one day, five hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(5, Calendar.MAY, 1979, 5, 0)),
	ONE_DAY_SIX_HOURS("one day, six hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(5, Calendar.MAY, 1979, 6, 0)),
	ONE_DAY_SEVEN_HOURS("one day, seven hours", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(5, Calendar.MAY, 1979, 7, 0)),
	THREE_DAYS("3 days", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(7, Calendar.MAY, 1979, 0, 0)),
	SIX_DAYS("six days", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(10, Calendar.MAY, 1979, 0, 0)),
	SIX_DAYS_ONE_HOUR("six days, one hour", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(10, Calendar.MAY, 1979, 1, 0)),
	SEVEN_DAYS("seven days", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(11, Calendar.MAY, 1979, 0, 0)),
	ONE_WEEK("1 week", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(11, Calendar.MAY, 1979, 0, 0)),
	ONE_WEEK_TOW_DAYS("one week, two days", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(13, Calendar.MAY, 1979, 0, 0)),
	THREE_WEEKS("three weeks", dateFor(4, Calendar.MAY, 1979, 0, 0), dateFor(25, Calendar.MAY, 1979, 0, 0));
	
	public static ParkingDuration durationFor(String name) {
		for (ParkingDuration duration: values()) {
			if (duration.name.equals(name)) {
				return duration;
			}
		}
		throw new IllegalArgumentException("Value does not exist: " + name);
	}
	
	private static Date dateFor(int day, int month, int year, int hour, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minutes);
		return cal.getTime();
	}
	
	private String name;
	private Date start;
	private Date end;
	
	private ParkingDuration(String name, Date start, Date end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}
	
	public Date start() {
		return this.start;
	}

	public Date end() {
		return this.end;
	}
	
}
