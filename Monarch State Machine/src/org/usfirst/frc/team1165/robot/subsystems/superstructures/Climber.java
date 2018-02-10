
package org.usfirst.frc.team1165.robot.subsystems.superstructures;

import org.usfirst.frc.team1165.robot.subsystems.ClimberIsolate;
import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston;
import org.usfirst.frc.team1165.robot.subsystems.StateMachine;
import org.usfirst.frc.team1165.robot.subsystems.ClimberIsolate.ClimberIsolateState;
import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston.ClimberPistonState;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import util.State;

/**
 *
 */
public class Climber extends StateMachine
{
	private static final Climber mInstance = new Climber();

	private ClimberPiston climberPiston = ClimberPiston.getInstance();
	private ClimberIsolate climberIsolate = ClimberIsolate.getInstance();

	protected Climber()
	{
	}

	public static enum ClimberState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				// System.out.println("Setting Climber State: " + this);
				// mInstance.state = this;
				// mInstance.climberIsolate.setState(ClimberIsolateState.IDLE);
				// mInstance.climberPiston.setState(ClimberPistonState.IDLE);
			}
		},
		STAGE_RETRACT
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber State: " + this);
				mInstance.climberIsolate.setState(ClimberIsolateState.ISOLATE);
				mInstance.climberPiston.setState(ClimberPistonState.RETRACT);
			}
		},
		RETRACT
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber State: " + this);
				mInstance.climberPiston.setState(ClimberPistonState.RETRACT);
			}
		},
		STAGE_EXTEND
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber State: " + this);
				mInstance.climberIsolate.setState(ClimberIsolateState.ISOLATE);
				mInstance.climberPiston.setState(ClimberPistonState.EXTEND);
			}
		},
		EXTEND
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber State: " + this);
				mInstance.climberPiston.setState(ClimberPistonState.EXTEND);
			}
		},
		FIRE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber State: " + this);
				mInstance.climberPiston.setState(ClimberIsolateState.FIRE);
			}
		};

		public void execute()
		{
		}
	}

	public synchronized static Climber getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return super.getStateChooser(ClimberState.values(), ClimberState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Climber Status", getState().toString());
	}
}
