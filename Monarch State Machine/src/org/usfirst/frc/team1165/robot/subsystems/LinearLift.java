
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.ILinearLift;
import org.usfirst.frc.team1165.util.states.LinearLiftState;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LinearLift implements ILinearLift {
	private static final ILinearLift mInstance = new LinearLift();

	private IController ctrl = Controller.getInstance();

	private WPI_TalonSRX mMainMotor;
	private WPI_TalonSRX mFollowerMotor;

	private SpeedControllerGroup mLift;

	protected LinearLift() {
		mMainMotor = new WPI_TalonSRX(0);
		mFollowerMotor = new WPI_TalonSRX(1);

		mMainMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

		mLift = new SpeedControllerGroup(mMainMotor, mFollowerMotor);
	}

	public static ILinearLift getInstance() {
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
		if (getHeight() < getLowerBound() && speed < 0)
			return false;
		else if (getHeight() > getUpperBound() && speed > 0)
			return false;
		return true;
	}

	@Override
	public void restrict() {
		if (getHeight() < getLowerBound() || getHeight() > getUpperBound()) {
			stop();
		}
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getLinearUp() && allow(1))
			mLift.set(1);
		else if (ctrl.getLinearDown() && allow(-1))
			mLift.set(-1);
		else
			stop();
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getClass().getSimpleName() + " Speed", mLift.get());
	}

}
