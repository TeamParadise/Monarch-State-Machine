package org.usfirst.frc.team1165.util.models;

/**
 * An interface to control a robot during teleop mode.
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IControllable {

	/**
	 * A method to periodically control a subsystem during teleop mode.
	 */
	public void control();
}
