package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.Shooter;
import org.usfirst.frc.team1165.util.states.ShooterState;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ShooterCommand extends TimedCommand {

	private static Shooter mShooter = Shooter.getInstance();

	private ShooterState mState;

	public ShooterCommand(ShooterState state, double timeout) {
		super(timeout);
		mState = state;
		requires(mShooter);
	}

	protected void initialize() {
		mShooter.set(mState);
	}

	protected void end() {
		mShooter.set(ShooterState.IDLE);
	}
}
