package org.usfirst.frc.team1165.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Kesav Kadalazhi
 */
public class RobotMap {

	// ---------- Ports ---------- //
	
	// ----- Motor Controllers ----- //

	private static final int DRIVE_RIGHT_MASTER_MOTOR_PORT = 6;
	private static final int DRIVE_RIGHT_FOLLOWER_MOTOR_PORT = 2;
	private static final int DRIVE_LEFT_MASTER_MOTOR_PORT = 7;
	private static final int DRIVE_LEFT_FOLLOWER_MOTOR_PORT = 7;
	
	private static final int SHOOTER_RIGHT_MOTOR_PORT = 6;
	private static final int SHOOTER_LEFT_MOTOR_PORT = 2;

	private static final int LINEAR_LIFT_MAIN_MOTOR_PORT = 7;
	private static final int LINEAR_LIFT_FOLLOWER_MOTOR_PORT = 7;
	
	private static final int ROTARY_LIFT_MOTOR_PORT = 8;

	// ----- Sensors ----- //

	private static final int ROTARY_LIFT_POT_PORT = 0;

	// ----- Pneumatics ----- //
	
	private static final int PCM_PORT = 1;

	private static final int SOLENOID_WINGS_RIGHT_PORT = 1;
	private static final int SOLENOID_WINGS_LEFT_PORT = 2;

	private static final int SOLENOID_CLAW_EXTEND_PORT = 4;
	private static final int SOLENOID_CLAW_RETRACT_PORT = 5;

	private static final int SOLENOID_CLIMBER_EXTEND_PORT = 6;
	private static final int SOLENOID_CLIMBER_RETRACT_PORT = 7;

	// ---------- Resources ---------- //
	
	// ----- Claw ----- //

	public static final DoubleSolenoid mClawSolenoid = new DoubleSolenoid(PCM_PORT, SOLENOID_CLAW_EXTEND_PORT, SOLENOID_CLAW_RETRACT_PORT);

	// ----- Climber ----- //

	public static final DoubleSolenoid mClimberSolenoid = new DoubleSolenoid(PCM_PORT, SOLENOID_CLIMBER_EXTEND_PORT, SOLENOID_CLIMBER_RETRACT_PORT);
	
	// ----- LinearLift ----- //

	public static final WPI_TalonSRX mDriveLeftMaster = new WPI_TalonSRX(DRIVE_LEFT_MASTER_MOTOR_PORT);
	public static final WPI_TalonSRX mDriveLeftFollower = new WPI_TalonSRX(DRIVE_LEFT_FOLLOWER_MOTOR_PORT);
	public static final WPI_TalonSRX mDriveRightMaster = new WPI_TalonSRX(DRIVE_RIGHT_MASTER_MOTOR_PORT);
	public static final WPI_TalonSRX mDriveRightFollower = new WPI_TalonSRX(DRIVE_RIGHT_FOLLOWER_MOTOR_PORT);
	
	// ----- LinearLift ----- //

	public static final WPI_TalonSRX mLinearLiftMainMotor = new WPI_TalonSRX(LINEAR_LIFT_MAIN_MOTOR_PORT);
	public static final WPI_TalonSRX mLinearLiftFollowerMotor = new WPI_TalonSRX(LINEAR_LIFT_FOLLOWER_MOTOR_PORT);

	// ----- RotaryLift ----- //

	public static final WPI_TalonSRX mRotaryLiftMotor = new WPI_TalonSRX(ROTARY_LIFT_MOTOR_PORT);

	public static final Potentiometer mRotaryLiftPot = new AnalogPotentiometer(ROTARY_LIFT_POT_PORT, 360, 0);

	// ----- Shooter ----- //

	public static final WPI_TalonSRX mShooterRightMotor = new WPI_TalonSRX(SHOOTER_RIGHT_MOTOR_PORT);
	public static final WPI_TalonSRX mShooterLeftMotor = new WPI_TalonSRX(SHOOTER_LEFT_MOTOR_PORT);

	// ----- Wings ----- //

	public static final Solenoid mWingLeftSolenoid = new Solenoid(PCM_PORT, SOLENOID_WINGS_LEFT_PORT);
	public static final Solenoid mWingRightSolenoid = new Solenoid(PCM_PORT, SOLENOID_WINGS_RIGHT_PORT);

}
