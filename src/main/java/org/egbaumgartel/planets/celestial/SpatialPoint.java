/**
 * 
 */
package org.egbaumgartel.planets.celestial;

/**
 * @author gregb
 *
 * @date 2017-03-13
 * 
 * Immutable point object, must be constructed with values.
 *
 */
public class SpatialPoint {
	
	private final double x;
	private final double y;
	private final double z;
	
	public SpatialPoint(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * @return x - x position
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * @return y - y position
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * @return z - z position
	 */
	public double getZ() {
		return this.z;
	}

}
