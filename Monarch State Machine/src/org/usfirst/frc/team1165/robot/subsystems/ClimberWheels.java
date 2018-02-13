
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 * <p>
 * The ClimberWheels consists of two stops at the back of the robot that are let out 
 * </p>
 * 
 * <p>The ClimberWheels has three states:</p>
 * 
 * <ol>
 * <li>Idle (default)</li>
 * <li>Open</li>
 * <li>Close</li>
 * </ol>
 * 
 * @author Kesav Kadalazhi
 *
 */
public class ClimberWheels extends StateMachine
{
	private static final ClimberWheels mInstance = new ClimberWheels();

	private Solenoid mClimberWheelsSolenoid = new Solenoid(RobotMap.PCM_1, RobotMap.SOLENOID_CLIMBER_WHEELS_PORT);

	protected ClimberWheels()
	{
	}

	public enum ClimberWheelsState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Climber Wheels", this);
				mInstance.mClimberWheelsSolenoid.set(false);
			}
		},
		ENGAGE
		{
			@Override
			public void execute()
			{
				reportState("Climber Wheels", this);
				mInstance.mClimberWheelsSolenoid.set(true);
			}
		},
		DISENGAGE
		{
			@Override
			public void execute()
			{
				reportState("Climber Wheels", this);
				mInstance.mClimberWheelsSolenoid.set(false);
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

		SmartDashboard.putBoolean("Climber Wheels Piston", mClimberWheelsSolenoid.get());
	}
}
