package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1165.robot.subsystems.pid.RotateHeadingPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateHeadingCommand extends Command {

	private static DriveTrain mDriveTrain = DriveTrain.getInstance();
	private static RotateHeadingPID mRotateHeadingPID = RotateHeadingPID.getInstance();

	private double mAngle;

	public RotateHeadingCommand(double angle) {
		mAngle = angle;

		requires(mDriveTrain);
		requires(mRotateHeadingPID);
	}

	@Override
	protected void initialize() {
		mRotateHeadingPID.enable(mAngle);
	}

	@Override
	protected boolean isFinished() {
		return mRotateHeadingPID.onTarget();
	}

	@Override
	protected void end() {
		mRotateHeadingPID.disable();
	}
}
