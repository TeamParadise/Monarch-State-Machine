package org.usfirst.frc.team1165.util.models.controller;

/**
 * An interface allowing the CoDriver to control the robot during teleop mode.
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface ICoDriverController {

	/**
	 * Returns whether or not to stage the climber.
	 * 
	 * @return value of the stage climb button
	 */
	public boolean getStageClimb();

	/**
	 * Returns whether or not to climb.
	 * 
	 * @return value of the climb button
	 */
	public boolean getClimb();

	/**
	 * Returns whether or not to drop the left wing.
	 * 
	 * @return value of the drop left wing button
	 */
	public boolean getDropLeft();

	/**
	 * Returns whether or not to drop the right wing.
	 * 
	 * @return value of the drop right wing button
	 */
	public boolean getDropRight();
}
