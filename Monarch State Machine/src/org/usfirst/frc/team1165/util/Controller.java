package org.usfirst.frc.team1165.util;

import org.usfirst.frc.team1165.util.models.IController;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @author Kesav Kadalazhi
 */
public class Controller implements IController
{
	// DRIVER
	
	private Joystick mDriver = new Joystick(0);
	
	@Override
	public boolean getClawToggle() {
		return mDriver.getRawButton(0);
	}

	@Override
	public boolean getLinearUp() {
		return mDriver.getRawButton(1);
	}

	@Override
	public boolean getLinearDown() {
		return mDriver.getRawButton(2);
	}

	@Override
	public boolean getRotaryUp() {
		return mDriver.getRawButton(3);
	}

	@Override
	public boolean getRotaryDown() {
		return mDriver.getRawButton(4);
	}

	@Override
	public boolean getIntake() {
		return mDriver.getRawButton(5);
	}

	@Override
	public boolean getEject() {
		return mDriver.getRawButton(6);
	}
	
	// CO-DRIVER
	
	private XboxController mCoDriver = new XboxController(1);
	
	@Override
	public boolean getStageClimb() {
		return mCoDriver.getRawButton(0);
	}

	@Override
	public boolean getClimb() {
		return mCoDriver.getRawButton(1);
	}

	@Override
	public boolean getDropLeft() {
		return mCoDriver.getRawButton(2);
	}

	@Override
	public boolean getDropRight() {
		return mCoDriver.getRawButton(3);
	}
	
	@Override
	public void report()
	{
	}

}
