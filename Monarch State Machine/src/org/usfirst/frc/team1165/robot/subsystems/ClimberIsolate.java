
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import util.State;

/**
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

	public static enum ClimberIsolateState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber Isolate State: " + this);
				mInstance.mClimberIsolateSolenoid.set(Value.kOff);
			}
		},
		ISOLATE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber Isolate State: " + this);
				mInstance.mClimberIsolateSolenoid.set(Value.kReverse);
			}
		},
		FIRE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber Isolate State: " + this);
				mInstance.mClimberIsolateSolenoid.set(Value.kForward);
			}
		};

		public void execute()
		{
		}
	}

	public synchronized static ClimberIsolate getInstance()
	{
		return mInstance;
	}

	public SendableChooser<State> getStateChooser()
	{
		return super.getStateChooser(ClimberIsolateState.values(), ClimberIsolateState.IDLE);
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
