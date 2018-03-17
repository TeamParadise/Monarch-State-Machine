package org.usfirst.frc.team1165.util.models.subsystems;

import org.usfirst.frc.team1165.util.models.IControllable;
import org.usfirst.frc.team1165.util.models.ISubsystem;
import org.usfirst.frc.team1165.util.states.ClimberState;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IClimber extends ISubsystem, IControllable {

	void set(ClimberState state);
}
