package org.usfirst.frc.team1165.util.models.subsystems;

import org.usfirst.frc.team1165.util.models.ISubsystem;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IWings extends ISubsystem {
	void dropLeft();

	void dropRight();

	void reset();
}
