package org.usfirst.frc.team1165.util.models;

/**
 * An interface shared by all subsystems whose motion is restricted.
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IRestricted {

	/**
	 * @return the lower restriction of the subsystem's motion
	 */
	double getLowerBound();

	/**
	 * @return the upper restriction of the subsystem's motion
	 */
	double getUpperBound();

	/**
	 * Determines whether a particular motion should be allowed.
	 * 
	 * @param speed
	 *            a given motion to be applied to a subsystem
	 * 
	 * @return whether or not the given motion should be applied
	 */
	boolean allow(double speed);
}
