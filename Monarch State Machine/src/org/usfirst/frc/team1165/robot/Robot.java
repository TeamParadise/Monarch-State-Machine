
package org.usfirst.frc.team1165.robot;

import java.util.Arrays;

import org.usfirst.frc.team1165.robot.subsystems.Claw;
import org.usfirst.frc.team1165.robot.subsystems.Climber;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;
import org.usfirst.frc.team1165.robot.subsystems.Shooter;
import org.usfirst.frc.team1165.robot.subsystems.Wings;
import org.usfirst.frc.team1165.robot.subsystems.pid.LinearLiftPID;
import org.usfirst.frc.team1165.robot.subsystems.pid.RotaryLiftPID;

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
public class Robot extends IterativeRobot {

	private static Manager mManager = new Manager(Arrays.asList(Claw.getInstance(), Climber.getInstance(),
			LinearLift.getInstance(), RotaryLift.getInstance(), Shooter.getInstance(), Wings.getInstance(),

			LinearLiftPID.getInstance(), RotaryLiftPID.getInstance()));

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	public void robotInit() {
	}

	public void robotPeriodic() {
		mManager.report();

		NavX.getInstance().report();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		mManager.control();
	}
}
