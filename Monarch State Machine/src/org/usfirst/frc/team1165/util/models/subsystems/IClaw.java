package org.usfirst.frc.team1165.util.models.subsystems;

import org.usfirst.frc.team1165.util.models.IControllable;
import org.usfirst.frc.team1165.util.models.ISubsystem;
import org.usfirst.frc.team1165.util.states.ClawState;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IClaw extends ISubsystem, IControllable {

	public void set(ClawState state);

	public void toggle();
}
