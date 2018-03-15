
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IRotaryLift;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotaryLift implements IRotaryLift {
	private static final IRotaryLift mInstance = new RotaryLift();

	private IController ctrl = Controller.getInstance();

	private WPI_TalonSRX mMotor;

	private Potentiometer mPot;

	protected RotaryLift() {
		mMotor = new WPI_TalonSRX(0);
		mPot = new AnalogPotentiometer(0, 360, 0);
	}

	public static IRotaryLift getInstance() {
		return mInstance;
	}

	// ----- IRotaryLift ----- //

	@Override
	public void set(double speed) {
		mMotor.set(speed);
	}

	@Override
	public void stop() {
		mMotor.set(0);
	}

	@Override
	public double getAngle() {
		return mPot.get();
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getRotaryUp())
			mMotor.set(1);
		else if (ctrl.getRotaryDown())
			mMotor.set(-1);
		else
			stop();
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getClass().getSimpleName() + " Speed", mMotor.get());
	}

}
