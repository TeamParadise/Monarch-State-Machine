package org.usfirst.frc.team1165.util.models.subsystems.pid;

import org.usfirst.frc.team1165.util.models.IPIDSubsystem;

public interface IDriveStraightPID extends IPIDSubsystem {

	void initHeading();

	void resetInputRange(double target);

	double getTwistCorrect();

	void enable(double target);

	void disable();
}
