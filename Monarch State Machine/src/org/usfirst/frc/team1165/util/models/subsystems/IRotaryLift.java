package org.usfirst.frc.team1165.util.models.subsystems;

import org.usfirst.frc.team1165.util.models.ISubsystem;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IRotaryLift extends ISubsystem {
	void set(double speed);

	void stop();

	double getAngle();
}
