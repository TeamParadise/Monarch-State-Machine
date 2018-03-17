
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.controller.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IWings;
import org.usfirst.frc.team1165.util.states.WingsState;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Wings extends Subsystem implements IWings {
	private static final Wings mInstance = new Wings();

	private IController ctrl = Controller.getInstance();

	private Solenoid mLeft;
	private Solenoid mRight;

	protected Wings() {
		mLeft = new Solenoid(0);
		mRight = new Solenoid(0);
	}

	public static Wings getInstance() {
		return mInstance;
	}

	// ----- IWings ----- //

	@Override
	public void set(WingsState state) {
		mLeft.set(state.getLeft());
		mRight.set(state.getRight());
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getDropLeft())
			set(WingsState.DROP_LEFT);
		if (ctrl.getDropRight())
			set(WingsState.DROP_RIGHT);

		if (!(ctrl.getDropLeft() || ctrl.getDropRight()))
			set(WingsState.IDLE);
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putBoolean(getName() + " Left State", mLeft.get());
		SmartDashboard.putBoolean(getName() + " Right State", mRight.get());
	}

	// ----- Subsystem ----- //

	@Override
	protected void initDefaultCommand() {
	}

}
