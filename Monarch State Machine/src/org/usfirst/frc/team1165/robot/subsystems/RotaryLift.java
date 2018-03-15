
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IRotaryLift;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotaryLift implements IRotaryLift
{
	private WPI_TalonSRX mMotor;
	
	private AnalogPotentiometer mPot;
	
	public RotaryLift(WPI_TalonSRX motor, AnalogPotentiometer pot)
	{
		mMotor = motor;		
		mPot = pot;
	}
	
	@Override
	public void set(double speed)
	{
		mMotor.set(speed);
	}

	@Override
	public void stop()
	{
		mMotor.set(0);
	}

	@Override
	public double getAngle() {
		return mPot.get();
	}

	@Override
	public void control(IController ctrl)
	{
		if(ctrl.getRotaryUp()) mMotor.set(1);
		else if(ctrl.getRotaryDown()) mMotor.set(-1);
		else stop();
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber(getClass().getSimpleName() + " Speed", mMotor.get());
	}
	
}
