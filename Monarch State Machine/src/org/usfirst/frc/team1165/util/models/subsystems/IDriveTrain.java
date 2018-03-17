package org.usfirst.frc.team1165.util.models.subsystems;

import org.usfirst.frc.team1165.util.models.IControllable;
import org.usfirst.frc.team1165.util.models.ISubsystem;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IDriveTrain extends ISubsystem, IControllable {

	/**
	 * Arcade drive method for differential drive platform.
	 *
	 * @param speed
	 *            The robot's speed along the Y axis [-1.0..1.0]. Forward is
	 *            positive.
	 * @param twist
	 *            The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise
	 *            is positive.
	 */
	void arcadeDrive(double speed, double twist);

	/**
	 * Tank drive method for differential drive platform.
	 *
	 * @param leftSpeed
	 *            The robot's left side speed along the Y axis [-1.0..1.0]. Forward
	 *            is positive.
	 * @param rightSpeed
	 *            The robot's right side speed along the Y axis [-1.0..1.0]. Forward
	 *            is positive.
	 */
	void tankDrive(double leftSpeed, double rightSpeed);

	/**
	 * Method to stop the robot's movement.
	 */
	default void stop() {
		arcadeDrive(0, 0);
	}

	/**
	 * Gets the position of the robot.
	 * 
	 * @return the position of the robot in inches.
	 */
	double getPosition();

	/**
	 * Gets the velocity of the robot.
	 * 
	 * @return the velocity of the robot in inches/sec.
	 */
	double getVelocity();

	/**
	 * Sets the sensor position to 0.
	 */
	void resetPosition();

}
