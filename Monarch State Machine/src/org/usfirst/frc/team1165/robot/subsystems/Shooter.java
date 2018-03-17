
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.controller.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IShooter;
import org.usfirst.frc.team1165.util.states.ShooterState;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem implements IShooter {
	private static final Shooter mInstance = new Shooter();

	private IController ctrl = Controller.getInstance();

	private WPI_TalonSRX mRightMotor;
	private WPI_TalonSRX mLeftMotor;

	protected Shooter() {
		mRightMotor = new WPI_TalonSRX(0);
		mRightMotor = new WPI_TalonSRX(1);
	}

	public static Shooter getInstance() {
		return mInstance;
	}

	// ----- IShooter ----- //

	@Override
	public void set(ShooterState state) {
		mRightMotor.set(state.getLeft());
		mLeftMotor.set(state.getRight());
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getIntake())
			set(ShooterState.INTAKE);
		else if (ctrl.getEject())
			set(ShooterState.EJECT);
		else
			set(ShooterState.IDLE);
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getName() + " Right", mRightMotor.get());
		SmartDashboard.putNumber(getName() + " Left", mLeftMotor.get());
	}

	// ----- Subsystem ----- //

	@Override
	protected void initDefaultCommand() {
	}

}
