package org.usfirst.frc.team1165.robot.subsystems.pid;

import org.usfirst.frc.team1165.robot.Controller;
import org.usfirst.frc.team1165.robot.NavX;
import org.usfirst.frc.team1165.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1165.util.models.subsystems.pid.IDriveStraightPID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class DriveStraightPID extends PIDSubsystem implements IDriveStraightPID {
	private static final DriveStraightPID mInstance = new DriveStraightPID();

	private static DriveTrain mDriveTrain = DriveTrain.getInstance();
	private static NavX mNavX = NavX.getInstance();

	private double mInitHeading;

	protected DriveStraightPID() {
		super("Linear Lift PID", 0.1, 0, 0.01, 0);

		setOutputRange(-0.2, 0.2);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous();
	}

	public static DriveStraightPID getInstance() {
		return mInstance;
	}

	// ----- IDriveStraightPID ----- //

	@Override
	public void initHeading() {
		mInitHeading = mNavX.getHeading();
	}

	@Override
	public void resetInputRange(double target) {
		setInputRange(mDriveTrain.getPosition() - target * 2, mDriveTrain.getPosition() + target * 2);
	}

	@Override
	public double getTwistCorrect() {
		return Controller.getInstance().restrict((mInitHeading - mNavX.getHeading()) * 0.1, -0.4, 0.4);
	}

	@Override
	public void enable(double target) {
		initHeading();
		resetInputRange(target);
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
		return mDriveTrain.getPosition();
	}

	@Override
	protected void usePIDOutput(double twist) {
		mDriveTrain.arcadeDrive(twist, getTwistCorrect());
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