package org.usfirst.frc.team1165.util.models.controller;

/**
 * An interface allowing the Driver to control the robot during teleop mode.
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IDriverController {

	/**
	 * The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
	 * 
	 * @return the X value of the joystick
	 */
	public double getDriveX();

	/**
	 * The robot's speed along the Y axis [-1.0..1.0]. Forward is positive.
	 * 
	 * @return the Y value of the joystick
	 */
	public double getDriveY();

	/**
	 * The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is
	 * positive.
	 * 
	 * @return the Twist value of the joystick
	 */
	public double getDriveTwist();

	/**
	 * Returns whether or not to toggle the claw.
	 * 
	 * @return value of the toggle claw button
	 */
	public boolean getClawToggle();

	/**
	 * Returns whether or not to move the linear lift up.
	 * 
	 * @return value of the linear lift up button
	 */
	public boolean getLinearUp();

	/**
	 * Returns whether or not to move the linear lift down.
	 * 
	 * @return value of the linear lift down button
	 */
	public boolean getLinearDown();

	/**
	 * Returns whether or not to turn the rotary lift up.
	 * 
	 * @return value of the rotary lift up button
	 */
	public boolean getRotaryUp();

	/**
	 * Returns whether or not to turn the rotary lift down.
	 * 
	 * @return value of the rotary lift down button
	 */
	public boolean getRotaryDown();

	/**
	 * Returns whether or not to intake a cube.
	 * 
	 * @return value of the shooter intake button
	 */
	public boolean getIntake();

	/**
	 * Returns whether or not to eject a cube.
	 * 
	 * @return value of the shooter eject button
	 */
	public boolean getEject();
}
