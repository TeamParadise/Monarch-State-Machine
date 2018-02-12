
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 *
 */
public class ClimberWheels extends StateMachine
{
	private static final ClimberWheels mInstance = new ClimberWheels();

	private Solenoid mTestSolenoid = new Solenoid(RobotMap.PCM_1, 1);

	protected ClimberWheels()
	{
	}

	public static enum ClimberWheelsState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Climber Wheels", this);
				EXTEND.execute();
			}
		},
		RETRACT
		{
			@Override
			public void execute()
			{
				reportState("Climber Wheels", this);
				mInstance.mTestSolenoid.set(true);
			}
		},
		EXTEND
		{
			@Override
			public void execute()
			{
				reportState("Climber Wheels", this);
				mInstance.mTestSolenoid.set(false);
			}
		}
	}

	public synchronized static ClimberWheels getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(ClimberWheelsState.values(), ClimberWheelsState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Climber Wheels Status", getState().toString());

		SmartDashboard.putBoolean("Climber Wheels Piston", mTestSolenoid.get());
	}
}
