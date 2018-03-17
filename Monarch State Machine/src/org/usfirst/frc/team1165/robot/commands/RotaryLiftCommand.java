package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;
import org.usfirst.frc.team1165.robot.subsystems.pid.RotaryLiftPID;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotaryLiftCommand extends Command {

	private static RotaryLift mLift = RotaryLift.getInstance();
	private static RotaryLiftPID mLiftPID = RotaryLiftPID.getInstance();

	private RotaryLiftState mState;

	public RotaryLiftCommand(RotaryLiftState state) {
		mState = state;

		requires(mLift);
		requires(mLiftPID);
	}

	@Override
	protected void initialize() {
		mLiftPID.enable(mState);
	}

	@Override
	protected boolean isFinished() {
		return mLiftPID.onTarget();
	}

	@Override
	protected void end() {
		mLiftPID.disable();
	}
}
