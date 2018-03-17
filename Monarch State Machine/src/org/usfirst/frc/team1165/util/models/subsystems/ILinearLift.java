package org.usfirst.frc.team1165.util.models.subsystems;

import org.usfirst.frc.team1165.util.models.IControllable;
import org.usfirst.frc.team1165.util.models.IRestricted;
import org.usfirst.frc.team1165.util.models.ISubsystem;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface ILinearLift extends ISubsystem, IRestricted, IControllable {
	void set(double speed);

	void stop();

	int getHeight();

	void resetHeight();
}
