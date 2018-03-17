package org.usfirst.frc.team1165.util.models;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IStateMachine {
	void setState();

	IState<?> getState();

	void transition(IState<?> finalState);
}
