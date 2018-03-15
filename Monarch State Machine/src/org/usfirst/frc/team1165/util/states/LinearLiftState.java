package org.usfirst.frc.team1165.util.states;

import org.usfirst.frc.team1165.util.models.IState;

public enum LinearLiftState implements IState
{
	IDLE(0), INTAKE(0), SWITCH(100), SCALE_DOWN(200), SCALE_UP(300);

	private double value;

	LinearLiftState(double value) {
		this.value = value;
	}

	@Override
	public double get() {
		return value;
	}
	
	public static double getLowerBound() {
		return IDLE.value - 10;
	}
	
	public static double getUpperBound() {
		return SCALE_UP.value + 10;
	}
}
