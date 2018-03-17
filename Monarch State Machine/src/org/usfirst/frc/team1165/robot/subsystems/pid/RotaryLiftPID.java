package org.usfirst.frc.team1165.robot.subsystems.pid;

import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;
import org.usfirst.frc.team1165.util.models.subsystems.IRotaryLift;
import org.usfirst.frc.team1165.util.models.subsystems.pid.IRotaryLiftPID;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RotaryLiftPID extends PIDSubsystem implements IRotaryLiftPID {
	private static final RotaryLiftPID mInstance = new RotaryLiftPID();

	private static IRotaryLift mRotaryLift = RotaryLift.getInstance();

	protected RotaryLiftPID() {
		super("Rotary Lift PID", 0.1, 0, 0.01, 0);

		setInputRange(mRotaryLift.getLowerBound(), mRotaryLift.getUpperBound());
		setOutputRange(-0.2, 0.2);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous(false);
	}

	public static RotaryLiftPID getInstance() {
		return mInstance;
	}

	// ----- IRotaryLiftPID ----- //

	@Override
	public void enable(RotaryLiftState state) {
		setSetpoint(state.get());
		enable();
	}

	@Override
	public void disable() {
		mRotaryLift.stop();
		super.disable();
	}

	// ----- PIDSubsystem ----- //

	@Override
	protected double returnPIDInput() {
		return mRotaryLift.getAngle();
	}

	@Override
	protected void usePIDOutput(double speed) {
		mRotaryLift.set(speed);
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getName() + " Setpoint", getSetpoint());
		SmartDashboard.putBoolean(getName() + " On Target", onTarget());
	}

	// ----- Subsystem ----- //

	@Override
	protected void initDefaultCommand() {
	}

}