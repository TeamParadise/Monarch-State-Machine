
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IShooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter implements IShooter
{
	private WPI_TalonSRX mRightMotor;
	private WPI_TalonSRX mLeftMotor;
	
	public Shooter(WPI_TalonSRX right, WPI_TalonSRX left)
	{
		mRightMotor = right;
		mRightMotor = left;
	}
	
	@Override
	public void intake()
	{
		mRightMotor.set(1);
		mLeftMotor.set(1);
	}

	@Override
	public void eject()
	{
		mRightMotor.set(-1);
		mLeftMotor.set(-1);
	}

	@Override
	public void stop()
	{
		mRightMotor.set(0);
		mLeftMotor.set(0);
	}

	@Override
	public void control(IController ctrl)
	{
		if(ctrl.getIntake()) intake();
		else if(ctrl.getEject()) eject();
		else stop();
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber(getClass().getSimpleName() + " Right", mRightMotor.get());
		SmartDashboard.putNumber(getClass().getSimpleName() + " Left", mLeftMotor.get());
	}
	
}
