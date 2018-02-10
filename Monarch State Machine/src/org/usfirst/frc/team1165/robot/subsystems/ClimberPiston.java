
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
public class ClimberPiston extends StateMachine
{
	private static final ClimberPiston mInstance = new ClimberPiston();

	private DoubleSolenoid mClimberSolenoid = new DoubleSolenoid(RobotMap.PCM_1, RobotMap.SOLENOID_CLIMBER_EXTEND_PORT,
			RobotMap.SOLENOID_CLIMBER_RETRACT_PORT);

	protected ClimberPiston()
	{
	}

	public static enum ClimberPistonState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber Piston State: " + this);
				mInstance.mClimberSolenoid.set(Value.kOff);
			}
		},
		EXTEND
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber Piston State: " + this);
				mInstance.mClimberSolenoid.set(Value.kForward);
			}
		},
		RETRACT
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Climber Piston State: " + this);
				mInstance.mClimberSolenoid.set(Value.kReverse);
			}
		};

		public void execute()
		{
		}
	}

	public synchronized static ClimberPiston getInstance()
	{
		return mInstance;
	}

	public SendableChooser<State> getStateChooser()
	{
		return super.getStateChooser(ClimberPistonState.values(), ClimberPistonState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Climber Piston Status", getState().toString());

		SmartDashboard.putString("Climber Piston", mClimberSolenoid.get().toString());
	}
}
