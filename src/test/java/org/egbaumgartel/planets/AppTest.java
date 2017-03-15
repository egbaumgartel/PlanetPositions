package org.egbaumgartel.planets;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egbaumgartel.planets.calcs.Conversions;
import org.egbaumgartel.planets.config.LoadConfig;
import org.egbaumgartel.planets.data.OrbitalElements;
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
		assertEquals(-0.5, Conversions.getJulianDate(2000, 1, 1, 0.0), 0.001);
		assertEquals(6281.5, Conversions.getJulianDate(2017, 3, 14, 0.0), 0.001);
		assertEquals(-1462.5, Conversions.getJulianDate(1995, 12, 31, 0.0), 0.001);
		assertEquals(73778.5, Conversions.getJulianDate(2202, 1, 1, 0.0), 0.001);
		assertEquals(-36265.5, Conversions.getJulianDate(1900, 9, 17, 0.0), 0.001);
		
		assertEquals(-0.5, Conversions.astroJulianDate(2000, 1, 1, 0.0), 0.001);
		assertEquals(6281.5, Conversions.astroJulianDate(2017, 3, 14, 0.0), 0.001);
		assertEquals(-1462.5, Conversions.astroJulianDate(1995, 12, 31, 0.0), 0.001);
		assertEquals(73778.5, Conversions.astroJulianDate(2202, 1, 1, 0.0), 0.001);
		assertEquals(-36265.5, Conversions.astroJulianDate(1900, 9, 17, 0.0), 0.001);
		
		// fractional
		assertEquals(-0.25, Conversions.getJulianDate(2000, 1, 1, 0.25), 0.001);
		assertEquals(6282.25, Conversions.getJulianDate(2017, 3, 14, 0.75), 0.001);
		assertEquals(-1462.2, Conversions.getJulianDate(1995, 12, 31, 0.3), 0.001);
		assertEquals(73779.1, Conversions.getJulianDate(2202, 1, 1, 0.6), 0.001);
		assertEquals(-36264.7, Conversions.getJulianDate(1900, 9, 17, 0.8), 0.001);
		
		assertEquals(-0.25, Conversions.astroJulianDate(2000, 1, 1, 0.25), 0.001);
		assertEquals(6282.25, Conversions.astroJulianDate(2017, 3, 14, 0.75), 0.001);
		assertEquals(-1462.2, Conversions.astroJulianDate(1995, 12, 31, 0.3), 0.001);
		assertEquals(73779.1, Conversions.astroJulianDate(2202, 1, 1, 0.6), 0.001);
		assertEquals(-36264.7, Conversions.astroJulianDate(1900, 9, 17, 0.8), 0.001);
	
	}
	
	/*
	 * Load the orbital params
	 */
	@Test
	public void testReadConfigFile() {
		LoadConfig lc = new LoadConfig("data/elements.txt");
		Map<String,OrbitalElements> planetMap = new HashMap<String,OrbitalElements>();
		
		try {
			List<OrbitalElements> elements = lc.readAllElements();
			
			for (OrbitalElements oe : elements) {
				planetMap.put(oe.getPlanetName(), oe);
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		//check a few of 'em - Uranus has non-zero values for all
		assertEquals(19.18797948, planetMap.get("Uranus").getA(), 0.00000001);
		assertEquals(0.04685740, planetMap.get("Uranus").getE(), 0.00000001);
		assertEquals(0.77298127, planetMap.get("Uranus").getI(), 0.00000001);
		assertEquals(314.20276625, planetMap.get("Uranus").getL(), 0.00000001);
		assertEquals(172.43404441, planetMap.get("Uranus").getW(), 0.00000001);
		assertEquals(73.962502150, planetMap.get("Uranus").getN(), 0.00000001);
		assertEquals(-0.00020455, planetMap.get("Uranus").getD_a(), 0.00000001);
		assertEquals(-0.00001550, planetMap.get("Uranus").getD_e(), 0.00000001);
		assertEquals(-0.00180155, planetMap.get("Uranus").getD_i(), 0.00000001);
		assertEquals(428.49512595, planetMap.get("Uranus").getD_L(), 0.00000001);
		assertEquals(0.09266985, planetMap.get("Uranus").getD_w(), 0.00000001);
		assertEquals(0.05739699, planetMap.get("Uranus").getD_n(), 0.00000001);
		assertEquals(0.00058331, planetMap.get("Uranus").getB(), 0.00000001);
		assertEquals(-0.97731848, planetMap.get("Uranus").getC(), 0.00000001);
		assertEquals(0.17689245, planetMap.get("Uranus").getS(), 0.00000001);
		assertEquals(7.67025000, planetMap.get("Uranus").getF(), 0.00000001);
	}
}
