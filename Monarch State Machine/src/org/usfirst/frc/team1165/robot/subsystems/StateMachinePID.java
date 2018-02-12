package org.usfirst.frc.team1165.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import util.State;

/**
 *
 */
public abstract class StateMachinePID extends PIDSubsystem
{

	protected State state = SampleState.IDLE;

	public StateMachinePID(String name, double kP, double kI, double kD, double kF)
	{
		super(name, kP, kI, kD, kF);
	}

	private enum SampleState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				System.out.println("Override me");
			}
		}
	}

	public void setState(State state)
	{
		if (this.state != state)
		{
			this.state = state;
			state.execute();
		}
	}

	public State getState()
	{
		return state == null ? SampleState.IDLE : state;
	}

	public SendableChooser<State> getStateChooser(State[] values, State idleState)
	{
		SendableChooser<State> chooser = new SendableChooser<State>();

		chooser.addDefault(getClass().getSimpleName() + " IDLE", idleState);
		for (State state : values)
			if (state != idleState)
				chooser.addObject(getClass().getSimpleName() + " " + state.toString(), state);

		return chooser;
	}

	public abstract SendableChooser<State> getStateChooser();

	public abstract void report();

}
