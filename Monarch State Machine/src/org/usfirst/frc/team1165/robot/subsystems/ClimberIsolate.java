
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 * <p>
 * The ClimberIsolate consists of one {@link DoubleSolenoid} that isolates or
 * powers the Climber. This is part of the system to make the Climber retract
 * faster.
 * </p>
 * 
 * <p>
 * The ClimberIsolate has three states:
 * </p>
 * 
 * <ol>
 * <li>Idle (default)</li>
 * <li>Isolate</li>
 * <li>Fire</li>
 * </ol>
 * 
 * @author Kesav Kadalazhi
 *
 */
public class ClimberIsolate extends StateMachine
{
	private static final ClimberIsolate mInstance = new ClimberIsolate();

	private DoubleSolenoid mClimberIsolateSolenoid = new DoubleSolenoid(RobotMap.PCM_1,
			RobotMap.SOLENOID_CLIMBER_FIRE_PORT, RobotMap.SOLENOID_CLIMBER_ISOLATE_PORT);

	protected ClimberIsolate()
	{
	}

	public enum ClimberIsolateState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Climber Isolate", this);
				mInstance.mClimberIsolateSolenoid.set(Value.kOff);
			}
		},
		ISOLATE
		{
			@Override
			public void execute()
			{
				reportState("Climber Isolate", this);
				mInstance.mClimberIsolateSolenoid.set(Value.kReverse);
			}
		},
		FIRE
		{
			@Override
			public void execute()
			{
				reportState("Climber Isolate", this);
				mInstance.mClimberIsolateSolenoid.set(Value.kForward);
			}
		}
	}

	public synchronized static ClimberIsolate getInstance()
	{
		return mInstance;
	}

	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(ClimberIsolateState.values(), ClimberIsolateState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Climber Isolate Status", getState().toString());

		SmartDashboard.putString("Climber Isolate", mClimberIsolateSolenoid.get().toString());
	}
}
