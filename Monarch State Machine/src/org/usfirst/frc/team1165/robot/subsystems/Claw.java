
package org.usfirst.frc.team1165.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IClaw;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw implements IClaw {
	private static final IClaw mInstance = new Claw();

	private IController ctrl = Controller.getInstance();

	private DoubleSolenoid mClaw;

	protected Claw() {
		mClaw = new DoubleSolenoid(0, 1);
	}

	public static IClaw getInstance() {
		return mInstance;
	}

	// ----- IClaw ----- //

	@Override
	public void open() {
		mClaw.set(kForward);
	}

	@Override
	public void close() {
		mClaw.set(kReverse);
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getClawToggle()) {
			if (mClaw.get() == kForward)
				open();
			else if (mClaw.get() == kReverse)
				close();
		}
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putString(getClass().getSimpleName() + " State", mClaw.get().toString());
	}

}
