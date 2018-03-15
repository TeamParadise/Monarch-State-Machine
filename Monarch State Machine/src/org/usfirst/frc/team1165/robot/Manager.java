package org.usfirst.frc.team1165.robot;

import java.util.List;

import org.usfirst.frc.team1165.util.models.IManager;
import org.usfirst.frc.team1165.util.models.IRestricted;
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
			SmartDashboard.putData((Sendable) subsystem);
			subsystem.report();
		});
	}

	@Override
	public void control() {
		mSubsystems.forEach(ISubsystem::control);
	}

	public void restrict() {
		mSubsystems.forEach((subsystem) -> {
			if (subsystem instanceof IRestricted) {
				((IRestricted) subsystem).restrict();
			}
		});
	}

}