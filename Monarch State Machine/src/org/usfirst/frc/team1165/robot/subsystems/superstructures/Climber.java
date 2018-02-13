
package org.usfirst.frc.team1165.robot.subsystems.superstructures;

import org.usfirst.frc.team1165.robot.subsystems.ClimberIsolate;
import org.usfirst.frc.team1165.robot.subsystems.ClimberIsolate.ClimberIsolateState;
import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston;
import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston.ClimberPistonState;
import org.usfirst.frc.team1165.robot.subsystems.ClimberWheels;
import org.usfirst.frc.team1165.robot.subsystems.ClimberWheels.ClimberWheelsState;
import org.usfirst.frc.team1165.robot.subsystems.StateMachine;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 * <p>
 * The Climber is the combination of the {@link ClimberPiston}, the
 * {@link ClimberIsolate} and the {@link ClimberWheels}.
 * </p>
 * <p>
 * The Claw has six states:
 * </p>
 * <ol>
 * <li>Idle (default)</li>
 * <li>Stage Climb</li>
 * <li>Climb</li>
 * <li>Stage Extend</li>
 * <li>Extend</li>
 * <li>Fire</li>
 * </ol>
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Climber extends StateMachine
{
	private static final Climber mInstance = new Climber();

	private ClimberPiston mClimberPiston = ClimberPiston.getInstance();
	private ClimberIsolate mClimberIsolate = ClimberIsolate.getInstance();
	private ClimberWheels mClimberWheels = ClimberWheels.getInstance();

	protected Climber()
	{
	}

	public enum ClimberState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Climber", this);
				mInstance.mClimberIsolate.setState(ClimberIsolateState.IDLE);
				mInstance.mClimberPiston.setState(ClimberPistonState.IDLE);
				mInstance.mClimberWheels.setState(ClimberWheelsState.IDLE);
			}
		},
		STAGE_CLIMB
		{
			@Override
			public void execute()
			{
				reportState("Climber", this);
				mInstance.mClimberIsolate.setState(ClimberIsolateState.ISOLATE);
				mInstance.mClimberPiston.setState(ClimberPistonState.RETRACT);
			}
		},
		CLIMB
		{
			@Override
			public void execute()
			{
				reportState("Climber", this);
				mInstance.mClimberPiston.setState(ClimberPistonState.RETRACT);
				mInstance.mClimberWheels.setState(ClimberWheelsState.ENGAGE);
			}
		},
		STAGE_EXTEND
		{
			@Override
			public void execute()
			{
				reportState("Climber", this);
				mInstance.mClimberIsolate.setState(ClimberIsolateState.ISOLATE);
				mInstance.mClimberPiston.setState(ClimberPistonState.EXTEND);
			}
		},
		EXTEND
		{
			@Override
			public void execute()
			{
				reportState("Climber", this);
				mInstance.mClimberPiston.setState(ClimberPistonState.EXTEND);
				mInstance.mClimberWheels.setState(ClimberWheelsState.IDLE);
				mInstance.mClimberWheels.setState(ClimberWheelsState.DISENGAGE);
			}
		},
		FIRE
		{
			@Override
			public void execute()
			{
				reportState("Climber", this);
				mInstance.mClimberPiston.setState(ClimberIsolateState.FIRE);
			}
		}
	}

	public synchronized static Climber getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(ClimberState.values(), ClimberState.IDLE);
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
