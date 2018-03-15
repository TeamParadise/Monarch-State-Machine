
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.ILinearLift;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LinearLift implements ILinearLift
{
	private WPI_TalonSRX mMainMotor;
	private WPI_TalonSRX mFollowerMotor;
	
	private SpeedControllerGroup mLift;
	
	public LinearLift(WPI_TalonSRX main, WPI_TalonSRX follower)
	{
		mMainMotor = main;
		mFollowerMotor = follower;
		
		mMainMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		
		mLift = new SpeedControllerGroup(mMainMotor, mFollowerMotor);
	}
	
	@Override
	public void set(double speed)
	{
		mLift.set(speed);
	}

	@Override
	public void stop()
	{
		mLift.set(0);
	}
	
	@Override
	public int getHeight() {
		return mMainMotor.getSelectedSensorPosition(0);
	}
	
	@Override
	public void resetHeight() {
		mMainMotor.setSelectedSensorPosition(0, 0, 0);
	}

	@Override
	public void control(IController ctrl)
	{
		if(ctrl.getLinearUp()) mLift.set(1);
		else if(ctrl.getLinearDown()) mLift.set(-1);
		else stop();
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber(getClass().getSimpleName() + " Speed", mLift.get());
	}
	
}
