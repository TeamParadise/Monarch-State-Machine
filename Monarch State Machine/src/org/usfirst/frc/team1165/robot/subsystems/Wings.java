
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IWings;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Wings implements IWings
{
	private Solenoid mLeft;
	private Solenoid mRight;
	
	public Wings(Solenoid left, Solenoid right)
	{
		mLeft = left;
		mRight = right;
	}
	
	@Override
	public void dropLeft()
	{
		mLeft.set(true);
	}

	@Override
	public void dropRight()
	{
		mRight.set(true);
	}

	@Override
	public void reset()
	{
		mLeft.set(false);
		mRight.set(false);
	}
	
	@Override
	public void control(IController ctrl)
	{
		if(ctrl.getDropLeft()) dropLeft();
		if(ctrl.getDropRight()) dropRight();
	
		if(!(ctrl.getDropLeft() || ctrl.getDropRight())) reset();
	}

	@Override
	public void report()
	{
		SmartDashboard.putBoolean(getClass().getSimpleName() + " Left State", mLeft.get());
		SmartDashboard.putBoolean(getClass().getSimpleName() + " Right State", mRight.get());
	}
	
}
