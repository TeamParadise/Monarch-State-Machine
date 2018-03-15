
package org.usfirst.frc.team1165.robot;

import org.usfirst.frc.team1165.robot.subsystems.Claw;
import org.usfirst.frc.team1165.robot.subsystems.Climber;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;
import org.usfirst.frc.team1165.robot.subsystems.Shooter;
import org.usfirst.frc.team1165.robot.subsystems.Wings;
import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IClaw;
import org.usfirst.frc.team1165.util.models.subsystems.IClimber;
import org.usfirst.frc.team1165.util.models.subsystems.ILinearLift;
import org.usfirst.frc.team1165.util.models.subsystems.IRotaryLift;
import org.usfirst.frc.team1165.util.models.subsystems.IShooter;
import org.usfirst.frc.team1165.util.models.subsystems.IWings;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * @author Kesav Kadalazhi
 */
public class Robot extends IterativeRobot
{
	public static IClaw mClaw;
	public static IClimber mClimber;
	public static ILinearLift mLinearLift;
	public static IRotaryLift mRotaryLift;
	public static IShooter mShooter;
	public static IWings mWings;
	
	private static IController mCtrl;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		mCtrl = new Controller();
		
		mClaw = new Claw(null);
		mClimber = new Climber(null);
		mLinearLift = new LinearLift(null, null);
		mRotaryLift = new RotaryLift(null, null);
		mShooter = new Shooter(null, null);
		mWings = new Wings(null, null);
	}

	public void robotPeriodic()
	{
		mClaw.report();
		mClimber.report();
		mLinearLift.report();
		mRotaryLift.report();
		mShooter.report();
		mWings.report();
	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit()
	{
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
		
		mClaw.control(mCtrl);
		mClimber.control(mCtrl);
		mLinearLift.control(mCtrl);
		mRotaryLift.control(mCtrl);
		mShooter.control(mCtrl);
		mWings.control(mCtrl);
	}
}
