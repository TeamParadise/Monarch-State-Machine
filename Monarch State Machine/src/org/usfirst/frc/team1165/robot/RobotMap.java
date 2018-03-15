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

	// MOTOR CONTROLLERS

	public static final int FRONT_RIGHT_SHOOTER_PORT = 6;
	public static final int FRONT_LEFT_SHOOTER_PORT = 2;

	public static final int REAR_RIGHT_SHOOTER_PORT = 4;
	public static final int REAR_LEFT_SHOOTER_PORT = 3;

	public static final int LINEAR_LIFT_PORT = 7;
	public static final int ROTARY_LIFT_PORT = 8;

	public static final int SERVO_PORT = 0;

	// SENSORS

	public static final int LINEAR_LIFT_ENCODER_PORT = 0; // placeholder value
	public static final int ROTARY_LIFT_POT_PORT = 0; // placeholder value

	// PNEUMATICS

	public static final int PCM_1 = 1;

	public static final int SOLENOID_CLIMBER_WHEELS_PORT = 1;

	public static final int SOLENOID_CLIMBER_ISOLATE_PORT = 2;
	public static final int SOLENOID_CLIMBER_FIRE_PORT = 3;

	public static final int SOLENOID_ARM_EXTEND_PORT = 4;
	public static final int SOLENOID_ARM_RETRACT_PORT = 5;

	public static final int SOLENOID_CLIMBER_EXTEND_PORT = 6;
	public static final int SOLENOID_CLIMBER_RETRACT_PORT = 7;

	// ----- Claw ----- //

	public static final DoubleSolenoid mClawSolenoid = new DoubleSolenoid(0, 1);

	// ----- Climber ----- //

	public static final DoubleSolenoid mClimberSolenoid = new DoubleSolenoid(2, 3);

	// ----- LinearLift ----- //

	public static final WPI_TalonSRX mLinearLiftMainMotor = new WPI_TalonSRX(0);
	public static final WPI_TalonSRX mLinearLiftFollowerMotor = new WPI_TalonSRX(1);

	// ----- RotaryLift ----- //

	public static final WPI_TalonSRX mRotaryLiftMotor = new WPI_TalonSRX(0);

	public static final Potentiometer mRotaryLiftPot = new AnalogPotentiometer(0, 360, 0);

	// ----- Shooter ----- //

	public static final WPI_TalonSRX mShooterRightMotor = new WPI_TalonSRX(0);
	public static final WPI_TalonSRX mShooterLeftMotor = new WPI_TalonSRX(1);

	// ----- Wings ----- //

	public static final Solenoid mWingLeftSolenoid = new Solenoid(0);
	public static final Solenoid mWingRightSolenoid = new Solenoid(0);

}
