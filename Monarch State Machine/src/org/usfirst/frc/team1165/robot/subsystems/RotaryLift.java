
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.Controller;
import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.util.models.controller.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IRotaryLift;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotaryLift extends Subsystem implements IRotaryLift {
	private static final RotaryLift mInstance = new RotaryLift();

	private IController ctrl = Controller.getInstance();

	private WPI_TalonSRX mMotor = RobotMap.mRotaryLiftMotor;

	private Potentiometer mPot = RobotMap.mRotaryLiftPot;

	protected RotaryLift() {
	}

	public static RotaryLift getInstance() {
		return mInstance;
	}

	// ----- IRotaryLift ----- //

	@Override
	public void set(double speed) {
		if (allow(speed))
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

	// ----- IRestricted ----- //

	@Override
	public double getLowerBound() {
		return RotaryLiftState.INTAKE.get();
	}

	@Override
	public double getUpperBound() {
		return RotaryLiftState.SCALE_UP.get() + 10;
	}

	@Override
	public boolean allow(double speed) {
		return (getAngle() < getLowerBound() && speed >= 0) || (getAngle() > getUpperBound() && speed <= 0);
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getRotaryUp())
			set(1);
		else if (ctrl.getRotaryDown())
			set(-1);
		else
			stop();
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getName() + " Speed", mMotor.get());
	}

	// ----- Subsystem ----- //

	@Override
	protected void initDefaultCommand() {
	}

}
