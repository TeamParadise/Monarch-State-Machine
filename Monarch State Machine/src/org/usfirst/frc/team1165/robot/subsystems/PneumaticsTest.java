
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import util.State;

/**
 *
 */
public class PneumaticsTest extends StateMachine
{
	private static final PneumaticsTest mInstance = new PneumaticsTest();

	private Solenoid mTestSolenoid = new Solenoid(RobotMap.PCM_1, 1);

	protected PneumaticsTest()
	{
	}

	public static enum TestState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Test Piston State: " + this);
				EXTEND.execute();
			}
		},
		RETRACT
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Test Piston State: " + this);
				mInstance.mTestSolenoid.set(true);
			}
		},
		EXTEND
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Test Piston State: " + this);
				mInstance.mTestSolenoid.set(false);
			}
		};

		@Override
		public void execute()
		{
		}
	}

	public synchronized static PneumaticsTest getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(TestState.values(), TestState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Test Status", getState().toString());

		SmartDashboard.putBoolean("Test Piston", mTestSolenoid.get());
	}
}
