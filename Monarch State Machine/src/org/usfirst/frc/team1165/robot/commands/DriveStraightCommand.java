package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1165.robot.subsystems.pid.DriveStraightPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightCommand extends Command {

	private static DriveTrain mDriveTrain = DriveTrain.getInstance();
	private static DriveStraightPID mDriveStraightPID = DriveStraightPID.getInstance();

	private double mPosition;

	public DriveStraightCommand(double position) {
		mPosition = position;

		requires(mDriveTrain);
		requires(mDriveStraightPID);
	}

	@Override
	protected void initialize() {
		mDriveStraightPID.enable(mPosition);
	}

	@Override
	protected boolean isFinished() {
		return mDriveStraightPID.onTarget();
	}

	@Override
	protected void end() {
		mDriveStraightPID.disable();
	}
}
