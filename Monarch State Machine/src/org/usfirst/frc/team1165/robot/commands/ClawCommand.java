package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.Claw;
import org.usfirst.frc.team1165.util.states.ClawState;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClawCommand extends InstantCommand {

	private static Claw mClaw = Claw.getInstance();

	private ClawState mState;

	public ClawCommand(ClawState state) {
		mState = state;
		requires(mClaw);
	}

	@Override
	protected void initialize() {
		mClaw.set(mState);
	}
}
