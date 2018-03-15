package org.usfirst.frc.team1165.robot.subsystems.pid;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.util.models.subsystems.pid.ILinearLiftPID;
import org.usfirst.frc.team1165.util.states.LinearLiftState;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class LinearLiftPID extends PIDSubsystem implements ILinearLiftPID
{
	protected LinearLiftPID()
	{
		super("Linear Lift PID", 0.1, 0, 0.01, 0);

		setInputRange(LinearLiftState.getLowerBound(), LinearLiftState.getUpperBound());
		setOutputRange(-0.2, 0.2);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous(false);
	}
	
	@Override
	public void setHeight(LinearLiftState position)
	{
		setSetpoint(position.get());
	}
	
	@Override
	protected double returnPIDInput()
	{
		return Robot.mLinearLift.getHeight();
	}

	@Override
	protected void usePIDOutput(double speed)
	{
		Robot.mLinearLift.set(speed);
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