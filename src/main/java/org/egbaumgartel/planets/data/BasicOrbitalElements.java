package org.egbaumgartel.planets.data;

/**
 * @author gregb
 *
 * @date 2017-03-13
 *
 */

public enum BasicOrbitalElements {
/*	
 *  http://www.met.rdg.ac.uk/~ross/Astronomy/Planets.html
 *  (epoch = J2000 = 2000 January 1.5)
 *   a, m0, e, i, w, o
*/	
	MERCURY("Mercury",
			0.38709893,
			252.25084,
			0.20563069,
			7.00487,
			77.45645,
			48.33167
			),
	VENUS("Venus",
			0.72333199,
			181.97973,
			0.00677323,
			3.39471,
			131.53298,
			76.68069
			),
	EARTH("Earth",
			1.00000011,
			100.46435,
			0.01671022,
			0.00005,
			102.94719,
			-11.26064
			),
	MARS("Mars",
			1.52366231,
			355.45332,
			0.09341233,
			1.85061,
			336.04084,
			49.57854
			),
	JUPITER("Jupiter",
			5.20336301,
			34.40438,
			0.04839266,
			1.30530,
			14.75385,
			100.55615
			),
	SATURN("Saturn",
			9.53707032,
			49.94432,
			0.05415060,
			2.48446,
			92.43194,
			113.71504
			),
	URANUS("Uranus",
			19.19126393,
			313.23218,
			0.04716771,
			0.76986,
			170.96424,
			74.22988
			),
	NEPTUNE("Neptune",
			30.06896348,
			304.88003,
			0.00858587,
			1.76917,
			44.97135,
			131.72169
			);
	
	// Display Name
	private final String displayName;
	// semi-major axis
	private final double a;
	// mean anomaly
	private final double m0;
	// Eccentricity
	private final double e;
	// inclination (degrees)
	private final double i;
	// argument of periapsis (degrees)
	private final double w;
	// longitude of ascending node (degrees)
	private final double o;


	
	private BasicOrbitalElements(
			String name,
			double a,
			double m0,
			double e,
			double i,
			double w,
			double o)
	{
		this.displayName = name;
		this.e = e;
		this.a = a;
		this.i = i;
		this.o = o;
		this.w = w;
		this.m0 = m0;
	}
	
	public String getName() {
		return this.displayName;
	}
	
	// different names for same method, so that they can be referenced either way
	
	public double geta() {
		return this.a;
	}
	
	public double getSemiMajorAxis() {
		return geta();
	}
	
	public double getM0() {
		return this.m0;
	}
	
	public double getMeanAnomaly() {
		return getM0();
	}
	
	public double gete() {
		return this.e;
	}

	public double getEccentricity() {
		return gete();
	}
	
	public double geti() {
		return this.i;
	}
	
	public double getInclination() {
		return geti();
	}
	
	public double geto() {
		return this.o;
	}
	
	public double getLongAscendingNode() {
		return geto();
	}
	
	public double getw() {
		return this.w;
	}
	
	public double getArgPeriapsis() {
		return getw();
	}
}
