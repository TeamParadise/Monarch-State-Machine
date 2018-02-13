package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RotaryLiftPID extends StateMachinePID
{
	private static final RotaryLiftPID mInstance = new RotaryLiftPID();

	private WPI_TalonSRX mRotaryLiftMotor = new WPI_TalonSRX(RobotMap.ROTARY_LIFT_PORT);

	private Encoder mEncoder = new Encoder(0, 0, false, EncodingType.k4X);
	
	protected RotaryLiftPID()
	{
		super("Rotary Lift", 0.01, 0, 0, 0);

		setInputRange(0, 360);
		setOutputRange(-0.25, 0.25);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous(false);
	}

	public enum RotaryLiftState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Rotary Lift", this);
				mInstance.disable();
				mInstance.mRotaryLiftMotor.set(0);
			}
		},
		DOWN
		{
			@Override
			public void execute()
			{
				reportState("Rotary Lift", this);
				mInstance.setSetpoint(0); // placeholder value
				mInstance.enable();
			}
		},
		UP
		{
			@Override
			public void execute()
			{
				reportState("Rotary Lift", this);
				mInstance.setSetpoint(90); // placeholder value
				mInstance.enable();
			}
		}
	}

	public synchronized static RotaryLiftPID getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(RotaryLiftState.values(), RotaryLiftState.IDLE);
	}

	@Override
	protected double returnPIDInput()
	{
		return mEncoder.get();
	}

	@Override
	protected void usePIDOutput(double output)
	{
		mRotaryLiftMotor.set(output);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Rotary Lift State", getState().toString());

		SmartDashboard.putNumber("Rotary Lift Motor", mRotaryLiftMotor.get());
		SmartDashboard.putNumber("Rotary Lift Motor", mEncoder.get());
	}

}
