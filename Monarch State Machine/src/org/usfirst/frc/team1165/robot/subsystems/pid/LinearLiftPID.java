package org.usfirst.frc.team1165.robot.subsystems.pid;

import org.usfirst.frc.team1165.robot.subsystems.LinearLift;
import org.usfirst.frc.team1165.util.models.subsystems.ILinearLift;
import org.usfirst.frc.team1165.util.models.subsystems.pid.ILinearLiftPID;
import org.usfirst.frc.team1165.util.states.LinearLiftState;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class LinearLiftPID extends PIDSubsystem implements ILinearLiftPID {
	private static final LinearLiftPID mInstance = new LinearLiftPID();

	private static ILinearLift mLinearLift = LinearLift.getInstance();

	protected LinearLiftPID() {
		super("Linear Lift PID", 0.1, 0, 0.01, 0);

		setInputRange(mLinearLift.getLowerBound(), mLinearLift.getUpperBound());
		setOutputRange(-0.2, 0.2);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous(false);
	}

	public static LinearLiftPID getInstance() {
		return mInstance;
	}

	// ----- ILinearLiftPID ----- //

	@Override
	public void enable(LinearLiftState state) {
		setSetpoint(state.get());
		enable();
	}

	@Override
	public void disable() {
		mLinearLift.stop();
		super.disable();
	}

	// ----- PIDSubsystem ----- //

	@Override
	protected double returnPIDInput() {
		return mLinearLift.getHeight();
	}

	@Override
	protected void usePIDOutput(double speed) {
		mLinearLift.set(speed);
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