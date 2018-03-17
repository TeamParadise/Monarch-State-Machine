package org.usfirst.frc.team1165.util.states;

import org.usfirst.frc.team1165.util.models.IState;

public enum ShooterState implements IState<double[]> {
	IDLE(0, 0), INTAKE(1, 1), EJECT(-1, -1), TWIST_RIGHT(-1, 1), TWIST_LEFT(1, -1);

	private double left, right;

	ShooterState(double left, double right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public double[] get() {
		return new double[] { left, right };
	}

	public double getLeft() {
		return left;
	}

	public double getRight() {
		return right;
	}
}