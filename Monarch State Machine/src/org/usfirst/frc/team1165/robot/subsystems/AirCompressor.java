
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.State;

/**
 * <p>Class to control and report the status of the compressor.</p>
 * 
 * <p>The AirCompressor has three states:</p>
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
public class AirCompressor extends StateMachine
{
	private static final AirCompressor mInstance = new AirCompressor();

	private Compressor mCompressor = new Compressor(RobotMap.PCM_1);

	protected AirCompressor()
	{
	}

	/**
	 * The AirCompressor has three states: idle(default), start, and stop.
	 *
	 */
	public enum AirCompressorState implements State
	{

		/**
		 * Turn the AirCompressor off (default behavior).
		 */
		IDLE
		{
			@Override
			public void execute()
			{
				reportState("Air Compressor", this);
				mInstance.mCompressor.stop();
			}
		},

		/**
		 * Turn the AirCompressor on.
		 */
		START
		{
			@Override
			public void execute()
			{
				reportState("Air Compressor", this);
				mInstance.mCompressor.start();
			}
		},
		/**
		 * Turn the AirCompressor off.
		 */
		STOP
		{
			@Override
			public void execute()
			{
				reportState("Air Compressor", this);
				mInstance.mCompressor.stop();
			}
		}
	}

	public synchronized static AirCompressor getInstance()
	{
		return mInstance;
	}

	public SendableChooser<State> getStateChooser()
	{
		return getStateChooser(AirCompressorState.values(), AirCompressorState.IDLE);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	public void report()
	{
		SmartDashboard.putString("Compressor Status", getState().toString());

		SmartDashboard.putBoolean("Compressor On", mCompressor.enabled());
		SmartDashboard.putNumber("Compressor Current", mCompressor.getCompressorCurrent());
	}
}
