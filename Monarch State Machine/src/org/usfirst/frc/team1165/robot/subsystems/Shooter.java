
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IShooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter implements IShooter {
	private static final IShooter mInstance = new Shooter();

	private IController ctrl = Controller.getInstance();

	private WPI_TalonSRX mRightMotor;
	private WPI_TalonSRX mLeftMotor;

	protected Shooter() {
		mRightMotor = new WPI_TalonSRX(0);
		mRightMotor = new WPI_TalonSRX(1);
	}

	public static IShooter getInstance() {
		return mInstance;
	}

	// ----- IShooter ----- //

	@Override
	public void intake() {
		mRightMotor.set(1);
		mLeftMotor.set(1);
	}

	@Override
	public void eject() {
		mRightMotor.set(-1);
		mLeftMotor.set(-1);
	}

	@Override
	public void stop() {
		mRightMotor.set(0);
		mLeftMotor.set(0);
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getIntake())
			intake();
		else if (ctrl.getEject())
			eject();
		else
			stop();
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getClass().getSimpleName() + " Right", mRightMotor.get());
		SmartDashboard.putNumber(getClass().getSimpleName() + " Left", mLeftMotor.get());
	}

}
