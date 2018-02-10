
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import util.State;

/**
 *
 */
public class AirCompressor extends StateMachine
{
	private static AirCompressor mInstance = new AirCompressor();

	private Compressor mCompressor = new Compressor(RobotMap.PCM_1);

	protected AirCompressor()
	{
	}

	public static enum AirCompressorState implements State
	{
		IDLE
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Compressor State: " + this);
				mInstance.mCompressor.stop();
			}
		},
		START
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Compressor State: " + this);
				mInstance.mCompressor.start();
			}
		},
		STOP
		{
			@Override
			public void execute()
			{
				System.out.println("Setting Compressor State: " + this);
				mInstance.mCompressor.stop();
			}
		};

		public void execute()
		{
		}
	}

	public synchronized static AirCompressor getInstance()
	{
		return mInstance;
	}

	public boolean isEnabled()
	{
		return mCompressor.enabled();
	}

	public double getCurrent()
	{
		return mCompressor.getCompressorCurrent();
	}

	public SendableChooser<State> getStateChooser()
	{
		return super.getStateChooser(AirCompressorState.values(), AirCompressorState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	public void report()
	{
		SmartDashboard.putString("Compressor Status", getState().toString());

		SmartDashboard.putBoolean("Compressor On", isEnabled());
		SmartDashboard.putNumber("Compressor Current", getCurrent());
	}
}
