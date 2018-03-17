package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.LinearLift;
import org.usfirst.frc.team1165.robot.subsystems.pid.LinearLiftPID;
import org.usfirst.frc.team1165.util.states.LinearLiftState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LinearLiftCommand extends Command {

	private static LinearLift mLift = LinearLift.getInstance();
	private static LinearLiftPID mLiftPID = LinearLiftPID.getInstance();

	private LinearLiftState mState;

	public LinearLiftCommand(LinearLiftState state) {
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
