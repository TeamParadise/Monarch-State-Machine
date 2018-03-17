package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.controller.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IDriveTrain;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem implements IDriveTrain {
	private static final DriveTrain mInstance = new DriveTrain();

	private IController ctrl = Controller.getInstance();

	private WPI_TalonSRX mLeftMaster = new WPI_TalonSRX(0);
	private WPI_TalonSRX mLeftSlave = new WPI_TalonSRX(1);
	private WPI_TalonSRX mRightMaster = new WPI_TalonSRX(2);
	private WPI_TalonSRX mRightSlave = new WPI_TalonSRX(3);

	private SpeedControllerGroup mLeftDrive = new SpeedControllerGroup(mLeftMaster, mLeftSlave);
	private SpeedControllerGroup mRightDrive = new SpeedControllerGroup(mRightMaster, mRightSlave);

	private DifferentialDrive mDrive = new DifferentialDrive(mLeftDrive, mRightDrive);

	protected DriveTrain() {
		mRightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	}

	public static DriveTrain getInstance() {
		return mInstance;
	}

	// ----- IDriveTrain ----- //

	@Override
	public void arcadeDrive(double speed, double twist) {
		mDrive.arcadeDrive(speed, twist, false);
	}

	@Override
	public void tankDrive(double leftSpeed, double rightSpeed) {
		mDrive.tankDrive(leftSpeed, rightSpeed, false);
	}

	@Override
	public void driveLeft(double speed) {
		mLeftDrive.set(speed);
	}

	@Override
	public void driveRight(double speed) {
		mRightDrive.set(speed);
	}

	@Override
	public double getPosition() {
		return mRightMaster.getSelectedSensorPosition(0);
	}

	@Override
	public double getVelocity() {
		return mRightMaster.getSelectedSensorVelocity(0);
	}

	@Override
	public void resetPosition() {
		mRightMaster.setSelectedSensorPosition(0, 0, 0);
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		arcadeDrive(ctrl.getDriveY(), ctrl.getDriveTwist());
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getName() + " Right Master", mRightMaster.get());
		SmartDashboard.putNumber(getName() + " Left Master", mLeftMaster.get());

		SmartDashboard.putNumber(getName() + " Right Position", getPosition());
	}

	// ----- Subsystem ----- //

	@Override
	protected void initDefaultCommand() {
	}

}