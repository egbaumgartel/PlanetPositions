package org.egbaumgartel.planets;

import static org.junit.Assert.*;

import org.egbaumgartel.planets.calcs.Conversions;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    /**
     * Rigourous Test :-)
     */
	@Test
    public void testApp()
    {
		System.out.println("Running Test");
        assertTrue( true );
    }
	
	/*
	 * Test conversions to J2000 Julian Dates.
	 * 
	 * Commented out getJTime() calls are because of some anomalies about how that
	 * formula (or my code) returns it.  The tests check out on getJD().
	 */
	
	@Test
	public void testJulianConversion() {
		Conversions c = Conversions.INSTANCE;

/*		System.out.println(c.getJTime(2000, 1, 0.0));
		System.out.println(c.getJTime(2017, 3, 13.0));
		System.out.println(c.getJTime(1995, 12, 30.0));
		System.out.println(c.getJTime(2202, 1, 0.0));
		System.out.println(c.getJTime(1900, 9, 16.0));*/
/*		System.out.println(c.astroJulianDate(2000, 1, 1, 0.0));
		System.out.println(c.astroJulianDate(2017, 3, 14, 0.0));
		System.out.println(c.astroJulianDate(1995, 12, 31, 0.0));
		System.out.println(c.astroJulianDate(2202, 1, 1, 0.0));
		System.out.println(c.astroJulianDate(1900, 9, 17, 0.0));
		System.out.println("------");
		System.out.println(c.getJulianDate(2000, 1, 1, 0.0));
		System.out.println(c.getJulianDate(2017, 3, 14, 0.0));
		System.out.println(c.getJulianDate(1995, 12, 31, 0.0));
		System.out.println(c.getJulianDate(2202, 1, 1, 0.0));
		System.out.println(c.getJulianDate(1900, 9, 17, 0.0));*/
		
		/*
		 * Correct Julian dates (J2000) based on
		 * 
		 * https://www.aavso.org/jd-calculator
		 */
		
		
		// non-fractional
		assertEquals(-0.5, c.getJulianDate(2000, 1, 1, 0.0), 0.001);
		assertEquals(6281.5, c.getJulianDate(2017, 3, 14, 0.0), 0.001);
		assertEquals(-1462.5, c.getJulianDate(1995, 12, 31, 0.0), 0.001);
		assertEquals(73778.5, c.getJulianDate(2202, 1, 1, 0.0), 0.001);
		assertEquals(-36265.5, c.getJulianDate(1900, 9, 17, 0.0), 0.001);
		
		assertEquals(-0.5, c.astroJulianDate(2000, 1, 1, 0.0), 0.001);
		assertEquals(6281.5, c.astroJulianDate(2017, 3, 14, 0.0), 0.001);
		assertEquals(-1462.5, c.astroJulianDate(1995, 12, 31, 0.0), 0.001);
		assertEquals(73778.5, c.astroJulianDate(2202, 1, 1, 0.0), 0.001);
		assertEquals(-36265.5, c.astroJulianDate(1900, 9, 17, 0.0), 0.001);
		
		// fractional
		assertEquals(-0.25, c.getJulianDate(2000, 1, 1, 0.25), 0.001);
		assertEquals(6282.25, c.getJulianDate(2017, 3, 14, 0.75), 0.001);
		assertEquals(-1462.2, c.getJulianDate(1995, 12, 31, 0.3), 0.001);
		assertEquals(73779.1, c.getJulianDate(2202, 1, 1, 0.6), 0.001);
		assertEquals(-36264.7, c.getJulianDate(1900, 9, 17, 0.8), 0.001);
		
		assertEquals(-0.25, c.astroJulianDate(2000, 1, 1, 0.25), 0.001);
		assertEquals(6282.25, c.astroJulianDate(2017, 3, 14, 0.75), 0.001);
		assertEquals(-1462.2, c.astroJulianDate(1995, 12, 31, 0.3), 0.001);
		assertEquals(73779.1, c.astroJulianDate(2202, 1, 1, 0.6), 0.001);
		assertEquals(-36264.7, c.astroJulianDate(1900, 9, 17, 0.8), 0.001);

		
	}
}
