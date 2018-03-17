package org.usfirst.frc.team1165.util.models.subsystems;

import org.usfirst.frc.team1165.util.models.IControllable;
import org.usfirst.frc.team1165.util.models.ISubsystem;
import org.usfirst.frc.team1165.util.states.WingsState;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IWings extends ISubsystem, IControllable {
	void set(WingsState state);
}
