
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.Controller;
import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.util.models.controller.IController;
import org.usfirst.frc.team1165.util.models.subsystems.ILinearLift;
import org.usfirst.frc.team1165.util.states.LinearLiftState;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LinearLift extends Subsystem implements ILinearLift {
	private static final LinearLift mInstance = new LinearLift();

	private IController ctrl = Controller.getInstance();

	private WPI_TalonSRX mMainMotor = RobotMap.mLinearLiftMainMotor;
	private WPI_TalonSRX mFollowerMotor = RobotMap.mLinearLiftFollowerMotor;

	private SpeedControllerGroup mLift = new SpeedControllerGroup(mMainMotor, mFollowerMotor);

	protected LinearLift() {
		mMainMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	}

	public static LinearLift getInstance() {
		return mInstance;
	}

	// ----- ILinearLift ----- //

	@Override
	public void set(double speed) {
		if (allow(speed))
			mLift.set(speed);
	}

	@Override
	public void stop() {
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

	// ----- IRestricted ----- //

	@Override
	public double getLowerBound() {
		return LinearLiftState.INTAKE.get();
	}

	@Override
	public double getUpperBound() {
		return LinearLiftState.SCALE_UP.get();
	}

	@Override
	public boolean allow(double speed) {
		return (getHeight() < getLowerBound() && speed >= 0) || (getHeight() > getUpperBound() && speed <= 0);
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getLinearUp())
			set(1);
		else if (ctrl.getLinearDown())
			set(-1);
		else
			stop();
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getName() + " Speed", mLift.get());
	}

	// ----- Subsystem ----- //

	@Override
	protected void initDefaultCommand() {
	}

}
