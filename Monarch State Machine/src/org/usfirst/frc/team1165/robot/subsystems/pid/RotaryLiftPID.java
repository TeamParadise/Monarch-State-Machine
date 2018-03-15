package org.usfirst.frc.team1165.robot.subsystems.pid;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.util.models.subsystems.pid.IRotaryLiftPID;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RotaryLiftPID extends PIDSubsystem implements IRotaryLiftPID
{
	protected RotaryLiftPID()
	{
		super("Rotary Lift PID", 0.1, 0, 0.01, 0);

		setInputRange(RotaryLiftState.getLowerBound(), RotaryLiftState.getUpperBound());
		setOutputRange(-0.2, 0.2);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous(false);
	}
	
	@Override
	public void setAngle(RotaryLiftState state)
	{
		setSetpoint(state.get());
	}
	
	@Override
	protected double returnPIDInput()
	{
		return Robot.mRotaryLift.getAngle();
	}

	@Override
	protected void usePIDOutput(double speed)
	{
		Robot.mRotaryLift.set(speed);
	}

	@Override
	protected void initDefaultCommand() {
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber("Linear Lift Target", getSetpoint());
		SmartDashboard.putBoolean("Linear Lift On Target", onTarget());
	}

}