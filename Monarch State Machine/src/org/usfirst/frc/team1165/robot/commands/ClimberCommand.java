package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.Climber;
import org.usfirst.frc.team1165.util.states.ClimberState;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClimberCommand extends InstantCommand {

	private static Climber mClimber = Climber.getInstance();

	private ClimberState mState;

	public ClimberCommand(ClimberState state) {
		mState = state;
		requires(mClimber);
	}

	@Override
	protected void initialize() {
		mClimber.set(mState);
	}
}
