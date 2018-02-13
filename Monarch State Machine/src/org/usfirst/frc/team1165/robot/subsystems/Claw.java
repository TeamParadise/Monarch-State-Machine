
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 * <p>
 * The Claw consists of two pistons, which are controlled by one {@link DoubleSolenoid}.
 * </p>
 * 
 * <p>
 * The Claw has three states:
 * </p>
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
public class Claw extends StateMachine
{
	private static final Claw mInstance = new Claw();

	private DoubleSolenoid mClawSolenoid = new DoubleSolenoid(RobotMap.PCM_1, RobotMap.SOLENOID_ARM_EXTEND_PORT,
			RobotMap.SOLENOID_ARM_RETRACT_PORT);

	protected Claw()
	{
	}

	public enum ClawState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Claw", this);
				mInstance.mClawSolenoid.set(Value.kOff);
			}
		},
		OPEN
		{
			@Override
			public void execute()
			{
				reportState("Claw", this);
				mInstance.mClawSolenoid.set(Value.kReverse);
				
				try {Thread.sleep(60);}
				catch (InterruptedException e) { e.printStackTrace(); }
				
				mInstance.mClawSolenoid.set(Value.kOff);
			}
		},
		CLOSE
		{
			@Override
			public void execute()
			{
				reportState("Claw", this);
				mInstance.mClawSolenoid.set(Value.kForward);
				
				try { Thread.sleep(60); }
				catch (InterruptedException e) { e.printStackTrace(); }
				
				mInstance.mClawSolenoid.set(Value.kOff);
			}
		}
	}

	public synchronized static Claw getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(ClawState.values(), ClawState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Claw Status", getState().toString());

		SmartDashboard.putString("Claw Piston", mClawSolenoid.get().toString());
	}
}
