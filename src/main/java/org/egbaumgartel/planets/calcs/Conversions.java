/**
 * 
 */
package org.egbaumgartel.planets.calcs;

import java.time.LocalDate;
import java.time.temporal.JulianFields;

/**
 * @author gregb
 *
 * @date 2017-03-13
 *
 */
public enum Conversions {
	INSTANCE;
	
	
	/**
	 * http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html
	 * 
	 * Return J2000 fractional Julian date given year, month, day, fraction.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param dayFraction
	 * @return  Fractional J2000 Julian date
	 */
	public static double getJulianDate(int year, int month, int day, double dayFraction) {
		
		if (dayFraction < 0.0 || dayFraction >= 1.0) 
			throw new IllegalArgumentException("dayFraction must be 0 or greater, and less than 1");
		if (month < 1 || month > 12) 
			throw new IllegalArgumentException("month must be between 1 and 12");
		// TODO - check for length of month
		if (day < 1 || day > 31)
			throw new IllegalArgumentException("day must be between 1 and 31");
		
		// January or February need to be the 13th or 14th month of the previous year
		int newMonth = month < 3 ? month+12 : month;
		int newYear = month < 3 ? year-1 : year;
		
		// all these are integer divisions, dropping the fractional part
		int a = newYear / 100;
		int b = a / 4;
		int c = 2 - a + b;
		long e = (long) (365.25 * (newYear + 4716));
		long f = (long) (30.6001 * (newMonth + 1));
		double jd = c + day + e + f - 1524.5 + dayFraction;
		
		return jd - 2451545;
		
	}
	
	
	/**
	 * Java 8 Temporal class usage.  Most likely the best.
	 * 
	 * Return J2000 fractional Julian date given year, month, day, fraction.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param dayFraction
	 * @return J2000 fractional Julian Date
	 */
	public static double astroJulianDate(int year, int month, int day, double dayFraction) {
		
		if (dayFraction < 0.0 || dayFraction >= 1.0) 
			throw new IllegalArgumentException("dayFraction must be 0 or greater, and less than 1");
		
		LocalDate plotDate = LocalDate.of(year, month, day);
		long julianDate = plotDate.getLong(JulianFields.JULIAN_DAY);
		
		return julianDate + dayFraction - 2451545.5;
		
	}

}
