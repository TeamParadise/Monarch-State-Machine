package org.usfirst.frc.team1165.util.states;

import org.usfirst.frc.team1165.util.models.IState;

public enum WingsState implements IState<boolean[]> {
	IDLE(false, false), DROP_LEFT(true, false), DROP_RIGHT(false, true);

	private boolean left, right;

	WingsState(boolean left, boolean right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean[] get() {
		return new boolean[] { left, right };
	}

	public boolean getLeft() {
		return left;
	}

	public boolean getRight() {
		return right;
	}
}