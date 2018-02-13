
package org.usfirst.frc.team1165.robot.subsystems.superstructures;

import org.usfirst.frc.team1165.robot.subsystems.LinearLift;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift.LinearLiftState;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLiftPID;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLiftPID.RotaryLiftState;
import org.usfirst.frc.team1165.robot.subsystems.StateMachine;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Lift extends StateMachine
{
	private static final Lift mInstance = new Lift();

	private LinearLift mLinearLift = LinearLift.getInstance();
	private RotaryLiftPID mRotaryLift = RotaryLiftPID.getInstance();

	protected Lift()
	{
	}

	public enum LiftState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Lift", this);
//				mInstance.mLinearLift.setState(LinearLiftState.IDLE);
//				mInstance.mRotaryLift.setState(RotaryLiftState.IDLE);
			}
		},
		STAGE_INTAKE
		{
			@Override
			public void execute()
			{
				reportState("Lift", this);
//				mInstance.mLinearLift.setState(LinearLiftState.DOWN);
//				mInstance.mRotaryLift.setState(RotaryLiftState.DOWN);
			}
		},
		STAGE_EJECT
		{
			@Override
			public void execute()
			{
				reportState("Lift", this);
//				mInstance.mLinearLift.setState(LinearLiftState.UP);
//				mInstance.mRotaryLift.setState(RotaryLiftState.UP);
			}
		}
	}

	public synchronized static Lift getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(LiftState.values(), LiftState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Lift Status", getState().toString());
	}
}
