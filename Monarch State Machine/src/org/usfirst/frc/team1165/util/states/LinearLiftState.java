package org.usfirst.frc.team1165.util.states;

import org.usfirst.frc.team1165.util.models.IState;

public enum LinearLiftState implements IState<Double> {
	IDLE(0), INTAKE(0), SWITCH(100), SCALE_DOWN(200), SCALE_UP(300);

	private double value;

	LinearLiftState(double value) {
		this.value = value;
	}

	@Override
	public Double get() {
		return value;
	}
}
