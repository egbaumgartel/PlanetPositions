/**
 * 
 */
package org.egbaumgartel.planets.celestial;

/**
 * @author gregb
 *
 * @date 2017-03-13
 *
 */
public enum Conversions {
	INSTANCE;
	
	/**
	 * turn a M/D/Y into a Epoch 2000 d time. Double for fractions of a day
	 * 
	 * http://www.stjarnhimlen.se/comp/ppcomp.html
	 * 
	 * This one doesn't seem to always work, not sure if it's the formula or the code.
	 * Making it private for now.
	 * 
	 * @param year
	 * @param month
	 * @param day - fractional day - NOTE - month starts at 0.0
	 * @return J date for a given year/month/day based on J2000.
	 */
	private double getJTime(int year, int month, double date) throws IllegalArgumentException {
		if (month < 1 || month > 12) 
			throw new IllegalArgumentException("month must be between 1 and 12");
		// TODO - check for length of month
		if (date < 0 || date >= 31)
			throw new IllegalArgumentException("day must be between 1 and less than 31");
		
		long dayInt = (long) Math.floor(date);
		
		// these need to be integer divisions
		long jDay = 367 * year - 7 * (year + (month + 9)/12) / 4 + 275*month/9 + dayInt - 730530;

		double jDate = jDay + (date - dayInt);

		return jDate - 0.5;
	}
	
	
	/**
	 * http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html
	 * 
	 * This method seems a little more intuitive in that first day of month is 1.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param dayFraction
	 * @return
	 */
	public double getJD(int year, int month, int day, double dayFraction) throws IllegalArgumentException {
		
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

}
