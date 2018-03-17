package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.Wings;
import org.usfirst.frc.team1165.util.states.WingsState;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class WingsCommand extends InstantCommand {

	private static Wings mWings = Wings.getInstance();

	private WingsState mState;

	public WingsCommand(WingsState state) {
		mState = state;
		requires(mWings);
	}

	@Override
	protected void initialize() {
		mWings.set(mState);
	}
}
