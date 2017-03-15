/**
 * 
 */
package org.egbaumgartel.planets.data;

/**
 * @author gregb
 *
 * @date 2017-03-14
 *
 */
/**
 * @author gregb
 *
 * @date 2017-03-15
 *
 */
public class OrbitalElements {
	private final String planetName;
	//semi-major axis
	private final double a;
	//eccentricity
	private final double e;
	//inclination
	private final double i;
	//mean longitude / anomaly
	private final double L;
	//longitude of periapsis
	private final double w;
	//longitude of ascending node
	private final double n;
	
	// deltas over time for the above
	private final double d_a;
	private final double d_e;
	private final double d_i;
	private final double d_L;
	private final double d_w;
	private final double d_n;
	
	// extra params for perturbations
	private final double b;
	private final double c;
	private final double s;
	private final double f;
	
	private OrbitalElements(
			String name,
			double a,
			double e,
			double i,
			double L,
			double w,
			double n,
			double d_a,
			double d_e,
			double d_i,
			double d_L,
			double d_w,
			double d_n,
			double b,
			double c,
			double s,
			double f) {
		
		this.planetName = name;
		this.a = a;
		this.e = e;
		this.i = i;
		this.L = L;
		this.w = w;
		this.n = n;
		this.d_a = d_a;
		this.d_e = d_e;
		this.d_i = d_i;
		this.d_L = d_L;
		this.d_w = d_w;
		this.d_n = d_n;
		this.b = b;
		this.c = c;
		this.s = s;
		this.f = f;
		
	}

	public static class ElementBuilder {
		private String planetName;
		//semi-major axis
		private double a;
		//eccentricity
		private double e;
		//inclination
		private double i;
		//mean longitude / anomally
		private double L;
		//longitude of periapsis
		private double w;
		//longitude of ascending node
		private double n;
		
		// deltas over time for the above
		private double d_a;
		private double d_e;
		private double d_i;
		private double d_L;
		private double d_w;
		private double d_n;
		
		// extra params for perturbations
		private double b;
		private double c;
		private double s;
		private double f;
		
		/*
		 * Start with the name of object as required
		 */
		public ElementBuilder(String name) {
			this.planetName = name;
		}
		
		public ElementBuilder a(double a) {
			this.a = a;
			return this;
		}
		
		public ElementBuilder e(double e) {
			this.e = e;
			return this;
		}
		
		public ElementBuilder i(double i) {
			this.i = i;
			return this;
		}
		
		public ElementBuilder L(double L) {
			this.L = L;
			return this;
		}
		
		public ElementBuilder w(double w) {
			this.w = w;
			return this;
		}
		
		public ElementBuilder n(double n) {
			this.n = n;
			return this;
		}
		
		public ElementBuilder d_a(double d_a) {
			this.d_a = d_a;
			return this;
		}
		
		public ElementBuilder d_e(double d_e) {
			this.d_e = d_e;
			return this;
		}
		
		public ElementBuilder d_i(double d_i) {
			this.d_i = d_i;
			return this;
		}
		
		public ElementBuilder d_L(double d_L) {
			this.d_L = d_L;
			return this;
		}
		
		public ElementBuilder d_w(double d_w) {
			this.d_w = d_w;
			return this;
		}
		
		public ElementBuilder d_n(double d_n) {
			this.d_n = d_n;
			return this;
		}
		
		public ElementBuilder b(double b) {
			this.b = b;
			return this;
		}
		
		public ElementBuilder c(double c) {
			this.c = c;
			return this;
		}
		
		public ElementBuilder s(double s) {
			this.s = s;
			return this;
		}
		
		public ElementBuilder f(double f) {
			this.f = f;
			return this;
		}
		
		public OrbitalElements build() {
			return new OrbitalElements(
					planetName,
					a,
					e,
					i,
					L,
					w,
					n,
					d_a,
					d_e,
					d_i,
					d_L,
					d_w,
					d_n,
					b,
					c,
					s,
					f);
		}
		
	}
	
	/**
	 * @return a - semi-major axis
	 */
	public double getA() {
		return a;
	}

	/**
	 * @return e - eccentricity
	 */
	public double getE() {
		return e;
	}

	/**
	 * @return i - inclination
	 */
	public double getI() {
		return i;
	}

	/**
	 * @return L - mean longitude / anomaly
	 */
	public double getL() {
		return L;
	}

	/**
	 * @return w - longitude of periapsis
	 */
	public double getW() {
		return w;
	}

	/**
	 * @return n - longitude of the ascending node
	 */
	public double getN() {
		return n;
	}

	/**
	 * @return delta-a
	 */
	public double getD_a() {
		return d_a;
	}

	/**
	 * @return delta-e
	 */
	public double getD_e() {
		return d_e;
	}

	/**
	 * @return delta-i
	 */
	public double getD_i() {
		return d_i;
	}

	/**
	 * @return delta-L
	 */
	public double getD_L() {
		return d_L;
	}

	/**
	 * @return delta-w
	 */
	public double getD_w() {
		return d_w;
	}

	/**
	 * @return delta-n
	 */
	public double getD_n() {
		return d_n;
	}

	/**
	 * @return 
	 */
	public double getB() {
		return b;
	}

	/**
	 * @return
	 */
	public double getC() {
		return c;
	}

	/**
	 * @return
	 */
	public double getS() {
		return s;
	}

	/**
	 * @return
	 */
	public double getF() {
		return f;
	}

	/**
	 * @return the planetName
	 */
	public String getPlanetName() {
		return planetName;
	}
	
	

}
