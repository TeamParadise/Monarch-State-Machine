package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 *
 */
public class LinearLift extends StateMachine
{
	private static final LinearLift mInstance = new LinearLift();

	private WPI_TalonSRX mLinearLiftMotor = new WPI_TalonSRX(RobotMap.LINEAR_LIFT_PORT);

	private DigitalInput mLowerLimit = new DigitalInput(0);
	private DigitalInput mUpperLimit = new DigitalInput(1);

	protected LinearLift()
	{
	}

	public enum LinearLiftState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Linear Lift", this);
				mInstance.mLinearLiftMotor.set(0);
			}
		},
		UP
		{
			@Override
			public void execute()
			{
				reportState("Linear Lift", this);
				while (!mInstance.mUpperLimit.get())
					mInstance.mLinearLiftMotor.set(0.25);
				mInstance.mLinearLiftMotor.set(0);
			}
		},
		DOWN
		{
			@Override
			public void execute()
			{
				reportState("Linear Lift", this);
				while (!mInstance.mLowerLimit.get())
					mInstance.mLinearLiftMotor.set(-0.25);
				mInstance.mLinearLiftMotor.set(0);
			}
		}
	}

	public synchronized static LinearLift getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(LinearLiftState.values(), LinearLiftState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Linear Lift State", getState().toString());

		SmartDashboard.putNumber("Linear Lift Motor", mLinearLiftMotor.get());
		SmartDashboard.putBoolean("Linear Lift Upper Limit", mUpperLimit.get());
		SmartDashboard.putBoolean("Linear Lift Lower Limit", mLowerLimit.get());
	}

}
