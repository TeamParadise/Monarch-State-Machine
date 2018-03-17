package org.usfirst.frc.team1165.robot.subsystems.pid;

import org.usfirst.frc.team1165.robot.NavX;
import org.usfirst.frc.team1165.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1165.util.models.subsystems.pid.IRotateHeadingPID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RotateHeadingPID extends PIDSubsystem implements IRotateHeadingPID {
	private static final RotateHeadingPID mInstance = new RotateHeadingPID();

	private static DriveTrain mDriveTrain = DriveTrain.getInstance();
	private static NavX mNavX = NavX.getInstance();

	protected RotateHeadingPID() {
		super("Linear Lift PID", 0.1, 0, 0.01, 0);

		setInputRange(0, 360);
		setOutputRange(-0.2, 0.2);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous();
	}

	public static RotateHeadingPID getInstance() {
		return mInstance;
	}

	// ----- IRotateHeadingPID ----- //

	@Override
	public void enable(double target) {
		setSetpointRelative(target);
		enable();
	}

	@Override
	public void disable() {
		mDriveTrain.stop();
		super.disable();
	}

	// ----- PIDSubsystem ----- //

	@Override
	protected double returnPIDInput() {
		return mNavX.getHeading();
	}

	@Override
	protected void usePIDOutput(double twist) {
		mDriveTrain.arcadeDrive(0, twist);
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getName() + " Target", getSetpoint());
		SmartDashboard.putBoolean(getName() + " On Target", onTarget());
	}

	// ----- Subsystem ----- //

	@Override
	protected void initDefaultCommand() {
	}

}