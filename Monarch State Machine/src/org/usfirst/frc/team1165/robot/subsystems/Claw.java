
package org.usfirst.frc.team1165.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IClaw;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw implements IClaw
{
	private DoubleSolenoid mClaw;
	
	public Claw(DoubleSolenoid claw)
	{
		mClaw = claw;
	}
	
	@Override
	public void open()
	{
		mClaw.set(kForward);
	}

	@Override
	public void close()
	{
		mClaw.set(kReverse);
	}

	@Override
	public void control(IController ctrl)
	{
		if(ctrl.getClawToggle())
		{
			if(mClaw.get() == kForward) open();
			else if(mClaw.get() == kReverse) close();
		}
	}

	@Override
	public void report()
	{
		SmartDashboard.putString(getClass().getSimpleName() + " State", mClaw.get().toString());
	}
	
}
