package org.usfirst.frc.team1165.util;

import java.util.List;

import org.usfirst.frc.team1165.util.models.IControllable;
import org.usfirst.frc.team1165.util.models.IManager;
import org.usfirst.frc.team1165.util.models.ISubsystem;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Manager implements IManager {
	private List<ISubsystem> mSubsystems;

	public Manager(List<ISubsystem> subsystems) {
		mSubsystems = subsystems;
	}

	@Override
	public void report() {
		mSubsystems.forEach((subsystem) -> {
			subsystem.report();
			if (subsystem instanceof Sendable) {
				SmartDashboard.putData((Sendable) subsystem);
			}
		});
	}

	@Override
	public void control() {
		mSubsystems.forEach((subsystem) -> {
			if (subsystem instanceof IControllable) {
				((IControllable) subsystem).control();
			}
		});
	}

}