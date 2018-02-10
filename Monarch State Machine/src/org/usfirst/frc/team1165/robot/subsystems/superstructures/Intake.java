
package org.usfirst.frc.team1165.robot.subsystems.superstructures;

import org.usfirst.frc.team1165.robot.subsystems.Claw;
import org.usfirst.frc.team1165.robot.subsystems.Claw.ClawState;
import org.usfirst.frc.team1165.robot.subsystems.FrontShooter;
import org.usfirst.frc.team1165.robot.subsystems.FrontShooter.FrontShooterState;
import org.usfirst.frc.team1165.robot.subsystems.RearShooter;
import org.usfirst.frc.team1165.robot.subsystems.RearShooter.RearShooterState;
import org.usfirst.frc.team1165.robot.subsystems.StateMachine;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import util.State;

/**
 *
 */
public class Intake extends StateMachine
{
	private static final Intake mInstance = new Intake();

	private Claw mClaw = Claw.getInstance();
	private FrontShooter mFrontShooter = FrontShooter.getInstance();
	private RearShooter mRearShooter = RearShooter.getInstance();

	protected Intake()
	{
	}

	/**
	 * <table>
	 * <thead>
	 * <tr>
	 * <th>State</th>
	 * <th>Claw</th>
	 * <th>Front</th>
	 * <th>Rear</th>
	 * </tr>
	 * </thead> <tbody>
	 * <tr>
	 * <td>Idle</td>
	 * <td>Idle</td>
	 * <td>Idle</td>
	 * <td>Idle</td>
	 * </tr>
	 * <tr>
	 * <td>Open</td>
	 * <td>Open</td>
	 * <td>Idle</td>
	 * <td>Idle</td>
	 * </tr>
	 * <tr>
	 * <td>Stage Intake</td>
	 * <td>Open</td>
	 * <td>Intake</td>
	 * <td>Intake</td>
	 * </tr>
	 * <tr>
	 * <td>Twist Right</td>
	 * <td>Open</td>
	 * <td>Twist Right</td>
	 * <td>Idle</td>
	 * </tr>
	 * <tr>
	 * <td>Twist Left</td>
	 * <td>Open</td>
	 * <td>Twist Left</td>
	 * <td>Idle</td>
	 * </tr>
	 * <tr>
	 * <td>Intake</td>
	 * <td>Close</td>
	 * <td>Intake</td>
	 * <td>Intake</td>
	 * </tr>
	 * <tr>
	 * <td>Store</td>
	 * <td>Close</td>
	 * <td>Idle</td>
	 * <td>Idle</td>
	 * </tr>
	 * <tr>
	 * <td>Spit</td>
	 * <td>Close</td>
	 * <td>Eject</td>
	 * <td>Eject</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * 
	 * @author Kesav Kadalazhi
	 *
	 */
	public enum IntakeState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Intake State: " + this);
				mInstance.mClaw.setState(ClawState.IDLE);
				mInstance.mFrontShooter.setState(FrontShooterState.IDLE);
				mInstance.mRearShooter.setState(RearShooterState.IDLE);
			}
		},
		OPEN
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Intake State: " + this);
				mInstance.mClaw.setState(ClawState.OPEN);
				mInstance.mFrontShooter.setState(FrontShooterState.IDLE);
				mInstance.mRearShooter.setState(RearShooterState.IDLE);
			}
		},
		STAGE_INTAKE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Intake State: " + this);
				mInstance.mClaw.setState(ClawState.OPEN);
				mInstance.mFrontShooter.setState(FrontShooterState.INTAKE);
				mInstance.mRearShooter.setState(RearShooterState.INTAKE);
			}
		},
		TWIST_RIGHT
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Intake State: " + this);
				mInstance.mClaw.setState(ClawState.OPEN);
				mInstance.mFrontShooter.setState(FrontShooterState.TWIST_RIGHT);
				mInstance.mRearShooter.setState(RearShooterState.IDLE);
			}
		},
		TWIST_LEFT
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Intake State: " + this);
				mInstance.mClaw.setState(ClawState.OPEN);
				mInstance.mFrontShooter.setState(FrontShooterState.TWIST_LEFT);
				mInstance.mRearShooter.setState(RearShooterState.IDLE);
			}
		},
		INTAKE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Intake State: " + this);
				mInstance.mClaw.setState(ClawState.CLOSE);
				mInstance.mFrontShooter.setState(FrontShooterState.INTAKE);
				mInstance.mRearShooter.setState(RearShooterState.INTAKE);
			}
		},
		STORE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Intake State: " + this);
				mInstance.mClaw.setState(ClawState.CLOSE);
				mInstance.mFrontShooter.setState(FrontShooterState.IDLE);
				mInstance.mRearShooter.setState(RearShooterState.IDLE);
			}
		},
		SPIT
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Intake State: " + this);
				System.out.println("Claw State: " + mInstance.mClaw.getState());
				mInstance.mClaw.setState(ClawState.CLOSE);
				mInstance.mFrontShooter.setState(FrontShooterState.EJECT);
				mInstance.mRearShooter.setState(RearShooterState.EJECT);
			}
		};

		public void execute()
		{
		}
	}

	public synchronized static Intake getInstance()
	{
		return mInstance;
	}

	@Override
	public SendableChooser<State> getStateChooser()
	{
		return super.getStateChooser(IntakeState.values(), IntakeState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Intake Status", getState().toString());
	}
}
