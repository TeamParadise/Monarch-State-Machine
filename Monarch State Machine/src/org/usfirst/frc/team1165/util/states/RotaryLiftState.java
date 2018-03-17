package org.usfirst.frc.team1165.util.states;

import org.usfirst.frc.team1165.util.models.IState;

public enum RotaryLiftState implements IState<Double> {
	IDLE(0), INTAKE(0), SWITCH(22.5), SCALE_DOWN(22.5), SCALE_UP(45);

	private double value;

	RotaryLiftState(double value) {
		this.value = value;
	}

	@Override
	public Double get() {
		return value;
	}
}