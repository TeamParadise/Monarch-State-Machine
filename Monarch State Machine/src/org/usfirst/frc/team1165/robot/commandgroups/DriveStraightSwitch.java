package org.usfirst.frc.team1165.robot.commandgroups;

import org.usfirst.frc.team1165.robot.commands.ClawCommand;
import org.usfirst.frc.team1165.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team1165.robot.commands.LinearLiftCommand;
import org.usfirst.frc.team1165.robot.commands.RotaryLiftCommand;
import org.usfirst.frc.team1165.robot.commands.ShooterCommand;
import org.usfirst.frc.team1165.util.states.ClawState;
import org.usfirst.frc.team1165.util.states.LinearLiftState;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;
import org.usfirst.frc.team1165.util.states.ShooterState;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraightSwitch extends CommandGroup {
	public DriveStraightSwitch() {
		addParallel(new LinearLiftCommand(LinearLiftState.SWITCH));
		addParallel(new RotaryLiftCommand(RotaryLiftState.SWITCH));
		addSequential(new DriveStraightCommand(10 * 12));
		addParallel(new ClawCommand(ClawState.OPEN));
		addSequential(new ShooterCommand(ShooterState.EJECT, 1));
	}
}
