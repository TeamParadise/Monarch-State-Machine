
package org.usfirst.frc.team1165.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IClimber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber implements IClimber
{
	private DoubleSolenoid mClimber;
	
	public Climber(DoubleSolenoid claw)
	{
		mClimber = claw;
	}
	
	@Override
	public void stageClimb()
	{
		mClimber.set(kForward);
	}

	@Override
	public void climb()
	{
		mClimber.set(kReverse);
	}

	@Override
	public void control(IController ctrl)
	{
		if(ctrl.getStageClimb()) stageClimb();
		else if(ctrl.getClimb()) climb();
	}

	@Override
	public void report()
	{
		SmartDashboard.putString(getClass().getSimpleName() + " State", mClimber.get().toString());
	}
	
}
