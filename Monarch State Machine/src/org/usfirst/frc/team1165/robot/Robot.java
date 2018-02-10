
package org.usfirst.frc.team1165.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team1165.robot.subsystems.AirCompressor;
import org.usfirst.frc.team1165.robot.subsystems.Claw;
import org.usfirst.frc.team1165.robot.subsystems.ClimberIsolate;
import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston;
import org.usfirst.frc.team1165.robot.subsystems.FrontShooter;
import org.usfirst.frc.team1165.robot.subsystems.PneumaticsTest;
import org.usfirst.frc.team1165.robot.subsystems.RearShooter;
import org.usfirst.frc.team1165.robot.subsystems.superstructures.Climber;
import org.usfirst.frc.team1165.robot.subsystems.superstructures.Intake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
//	public static final FrontShooter mFrontShooter = FrontShooter.getInstance();
//	public static final RearShooter mRearShooter = RearShooter.getInstance();
//	public static final Claw mClaw = Claw.getInstance();
//	public static final Intake mIntake = Intake.getInstance();
//
//	public static final ClimberPiston mClimberPiston = ClimberPiston.getInstance();
//	public static final ClimberIsolate mClimberIsolate = ClimberIsolate.getInstance();
//	public static final Climber mClimber = Climber.getInstance();
//
//	public static final AirCompressor mAirCompressor = AirCompressor.getInstance();

	public static final PneumaticsTest mTest = PneumaticsTest.getInstance();
	
//	public static final OI mOI = new OI();

	private static final SubsystemManager mManager = new SubsystemManager();

// 	private static Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		mManager.putStateChooser();
	}

	public void robotPeriodic()
	{
//		mOI.report();
		
		mManager.report();
		mManager.putSelectedState();

	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit()
	{
		// schedule the autonomous command (example)
		// if (autonomousCommand != null)
		// autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// if (autonomousCommand != null)
		// autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit()
	{

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
	}
}
