
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.Controller;
import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.util.models.controller.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IClaw;
import org.usfirst.frc.team1165.util.states.ClawState;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw extends Subsystem implements IClaw {
	private static final Claw mInstance = new Claw();

	private IController ctrl = Controller.getInstance();

	private DoubleSolenoid mClaw = RobotMap.mClawSolenoid;

	protected Claw() {
	}

	public static Claw getInstance() {
		return mInstance;
	}

	// ----- IClaw ----- //

	@Override
	public void set(ClawState state) {
		mClaw.set(state.get());
	}

	@Override
	public void toggle() {
		if (mClaw.get() == ClawState.CLOSE.get()) {
			set(ClawState.OPEN);
		} else if (mClaw.get() == ClawState.OPEN.get()) {
			set(ClawState.CLOSE);
		}
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getClawToggle()) {
			toggle();
		}
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putString(getName() + " State", mClaw.get().toString());
	}

	// ----- Subsystem ----- //

	@Override
	protected void initDefaultCommand() {
	}

}
