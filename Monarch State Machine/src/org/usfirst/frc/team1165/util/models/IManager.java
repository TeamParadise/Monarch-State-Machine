package org.usfirst.frc.team1165.util.models;

/**
 * <p>
 * An interface to manage all subsystems of the robot easily.
 * </p>
 * 
 * <p>
 * A Manager is responsible for reporting and restricting all subsystems when
 * the robot is enabled, and for controlling all subsystems during teleop mode.
 * </p>
 * 
 * @author Kesav Kadalazhi
 *
 * @see ISubsystem
 * @see IReportable
 * @see IControllable
 * @see IRestricted
 *
 */
public interface IManager {

	/**
	 * Reports all given subsystems periodically.
	 * 
	 * @see IReportable
	 */
	void report();

	/**
	 * Controls all given subsystems during teleop mode.
	 * 
	 * @see IControllable
	 */
	void control();
}
