package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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
public class LinearLiftPID extends StateMachinePID
{
	private static final LinearLiftPID mInstance = new LinearLiftPID();

	private WPI_TalonSRX mLinearLiftMotor = new WPI_TalonSRX(RobotMap.LINEAR_LIFT_PORT);

	private Encoder mEncoder = new Encoder(0, 0, false, EncodingType.k4X);
	
	protected LinearLiftPID()
	{
		super("Linear Lift", 0.01, 0, 0, 0);

		setInputRange(0, 1000); // placeholder value
		setOutputRange(-0.25, 0.25);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous(false);
	}

	public enum LinearLiftState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Linear Lift", this);
				mInstance.disable();
				mInstance.mLinearLiftMotor.set(0);
			}
		},
		DOWN
		{
			@Override
			public void execute()
			{
				reportState("Linear Lift", this);
				mInstance.setSetpoint(0); // placeholder value
				mInstance.enable();
			}
		},
		SWITCH
		{
			@Override
			public void execute()
			{
				reportState("Linear Lift", this);
				mInstance.setSetpoint(100); // placeholder value
				mInstance.enable();
			}
		},
		SCALE_DOWN
		{
			@Override
			public void execute()
			{
				reportState("Linear Lift", this);
				mInstance.setSetpoint(200); // placeholder value
				mInstance.enable();
			}
		},
		SCALE_UP
		{
			@Override
			public void execute()
			{
				reportState("Linear Lift", this);
				mInstance.setSetpoint(300); // placeholder value
				mInstance.enable();
			}
		}
	}

	public synchronized static LinearLiftPID getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(LinearLiftState.values(), LinearLiftState.IDLE);
	}

	public double getPosition() {
		return mEncoder.get();
	}
	
	@Override
	protected double returnPIDInput()
	{
		return getPosition();
	}

	@Override
	protected void usePIDOutput(double output)
	{
		mLinearLiftMotor.set(output);
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
		SmartDashboard.putNumber("Linear Lift Motor Position", getPosition());
	}

}
