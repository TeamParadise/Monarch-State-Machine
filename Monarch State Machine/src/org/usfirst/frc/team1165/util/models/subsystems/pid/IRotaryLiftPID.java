package org.usfirst.frc.team1165.util.models.subsystems.pid;

import org.usfirst.frc.team1165.util.models.IPIDSubsystem;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

public interface IRotaryLiftPID extends IPIDSubsystem
{
	void setAngle(RotaryLiftState state);
}
