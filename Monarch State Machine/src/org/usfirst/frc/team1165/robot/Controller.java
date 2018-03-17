package org.usfirst.frc.team1165.robot;

import org.usfirst.frc.team1165.util.models.controller.IController;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @author Kesav Kadalazhi
 */
public class Controller implements IController {
	private static final IController mInstance = new Controller();

	protected Controller() {
	}

	public static IController getInstance() {
		return mInstance;
	}

	// ----- IDriverController ----- //

	private Joystick mDriver = new Joystick(0);

	@Override
	public double getDriveX() {
		return dampen(mDriver.getX());
	}

	@Override
	public double getDriveY() {
		return dampen(-mDriver.getY());
	}

	@Override
	public double getDriveTwist() {
		return dampen(mDriver.getTwist());
	}

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

	// ----- ICoDriverController ----- //

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

	// ----- Helper Methods ----- //

	private static final double DEADBAND = 0.05;

	@Override
	public double dampen(double input) {
		return Math.abs(input) < DEADBAND ? 0 : Math.pow(input, 3);
	}

	@Override
	public double dampen(double input, double damp) {
		return Math.abs(input) < DEADBAND ? 0 : Math.copySign(Math.pow(input, damp), input);
	}

	@Override
	public double restrict(double input, double low, double high) {
		if (input < low)
			return low;
		else if (input > high)
			return high;
		else
			return input;
	}

}
