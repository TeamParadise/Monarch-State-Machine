package org.usfirst.frc.team1165.util.models.subsystems.pid;

import org.usfirst.frc.team1165.util.models.IPIDSubsystem;
import org.usfirst.frc.team1165.util.states.LinearLiftState;

public interface ILinearLiftPID extends IPIDSubsystem {

	void enable(LinearLiftState state);

	void disable();
}
