package org.usfirst.frc.team1165.util.states;

import org.usfirst.frc.team1165.util.models.IState;

public enum RotaryLiftState implements IState
{
	IDLE(0), DOWN(0), SCALE_DOWN(22.5), SCALE_UP(45);

	private double value;

	RotaryLiftState(double value) {
		this.value = value;
	}

	@Override
	public double get() {
		return value;
	}
	
	public static double getLowerBound() {
		return IDLE.value;
	}
	
	public static double getUpperBound() {
		return SCALE_UP.value;
	}
}