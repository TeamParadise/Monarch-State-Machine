package org.usfirst.frc.team1165.util.models.subsystems.pid;

import org.usfirst.frc.team1165.util.models.IPIDSubsystem;

public interface IRotateHeadingPID extends IPIDSubsystem {

	void enable(double target);

	void disable();
}
