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
	private static final IRotaryLiftPID mInstance = new RotaryLiftPID();

	private static IRotaryLift mRotaryLift = RotaryLift.getInstance();

	protected RotaryLiftPID() {
		super("Rotary Lift PID", 0.1, 0, 0.01, 0);

		setInputRange(RotaryLiftState.getLowerBound(), RotaryLiftState.getUpperBound());
		setOutputRange(-0.2, 0.2);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous(false);
	}

	public static IRotaryLiftPID getInstance() {
		return mInstance;
	}

	// ----- IRotaryLiftPID ----- //

	@Override
	public void setAngle(RotaryLiftState state) {
		setSetpoint(state.get());
	}

	@Override
	protected double returnPIDInput() {
		return mRotaryLift.getAngle();
	}

	@Override
	protected void usePIDOutput(double speed) {
		mRotaryLift.set(speed);
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initDefaultCommand() {
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber("Linear Lift Target", getSetpoint());
		SmartDashboard.putBoolean("Linear Lift On Target", onTarget());
	}

}