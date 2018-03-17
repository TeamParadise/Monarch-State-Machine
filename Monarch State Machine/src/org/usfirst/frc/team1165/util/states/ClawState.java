package org.usfirst.frc.team1165.util.states;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kOff;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import org.usfirst.frc.team1165.util.models.IState;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public enum ClawState implements IState<Value> {
	IDLE(kOff), OPEN(kForward), CLOSE(kReverse);

	private Value value;

	ClawState(Value value) {
		this.value = value;
	}

	@Override
	public Value get() {
		return value;
	}
}
