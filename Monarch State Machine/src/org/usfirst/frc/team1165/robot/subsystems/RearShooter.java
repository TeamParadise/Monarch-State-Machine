package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RearShooter extends StateMachine
{
	private static RearShooter mInstance = new RearShooter();

	private WPI_TalonSRX mRearRightMotor = new WPI_TalonSRX(RobotMap.REAR_RIGHT_SHOOTER_PORT);
	private WPI_TalonSRX mRearLeftMotor = new WPI_TalonSRX(RobotMap.ROTARY_LIFT_PORT);

	protected RearShooter()
	{
		mRearRightMotor.setInverted(true);
	}

	public enum RearShooterState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Rear Shooter", this);
				mInstance.mRearRightMotor.set(0);
				mInstance.mRearLeftMotor.set(0);
			}
		},
		INTAKE
		{
			@Override
			public void execute()
			{
				reportState("Rear Shooter", this);
				mInstance.mRearRightMotor.set(1);
				mInstance.mRearLeftMotor.set(1);
			}
		},
		EJECT
		{
			@Override
			public void execute()
			{
				reportState("Rear Shooter", this);
				mInstance.mRearRightMotor.set(-1);
				mInstance.mRearLeftMotor.set(-1);
			}
		}
	}

	public synchronized static RearShooter getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(RearShooterState.values(), RearShooterState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Rear Shooter State", getState().toString());

		SmartDashboard.putNumber("Rear Right Shooter", mRearRightMotor.get());
		SmartDashboard.putNumber("Rear Left Shooter", mRearLeftMotor.get());
	}

}
