package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import util.State;

/**
 *
 */
public class FrontShooter extends StateMachine
{
	private static FrontShooter mInstance = new FrontShooter();

	private WPI_TalonSRX mFrontRightMotor = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_SHOOTER_PORT);
	private WPI_TalonSRX mFrontLeftMotor = new WPI_TalonSRX(RobotMap.FRONT_LEFT_SHOOTER_PORT);

	protected FrontShooter()
	{
	}

	public enum FrontShooterState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				mInstance.mFrontRightMotor.set(0);
				mInstance.mFrontLeftMotor.set(0);
			}
		},
		INTAKE
		{
			@Override
			public void execute()
			{
				mInstance.mFrontRightMotor.set(1);
				mInstance.mFrontLeftMotor.set(1);
			}
		},
		EJECT
		{
			@Override
			public void execute()
			{
				mInstance.mFrontRightMotor.set(-1);
				mInstance.mFrontLeftMotor.set(-1);
			}
		},
		TWIST_RIGHT
		{
			@Override
			public void execute()
			{
				mInstance.mFrontRightMotor.set(1);
				mInstance.mFrontLeftMotor.set(-1);
			}
		},
		TWIST_LEFT
		{
			@Override
			public void execute()
			{
				mInstance.mFrontRightMotor.set(-1);
				mInstance.mFrontLeftMotor.set(1);
			}
		};

		@Override
		public void execute()
		{
		}
	}

	public synchronized static FrontShooter getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return super.getStateChooser(FrontShooterState.values(), FrontShooterState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Front Shooter State", getState().toString());

		SmartDashboard.putNumber("Front Right Shooter", mFrontRightMotor.get());
		SmartDashboard.putNumber("Front Left Shooter", mFrontLeftMotor.get());
	}

}
