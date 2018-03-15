
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IWings;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Wings implements IWings {
	private static final IWings mInstance = new Wings();

	private IController ctrl = Controller.getInstance();

	private Solenoid mLeft;
	private Solenoid mRight;

	protected Wings() {
		mLeft = new Solenoid(0);
		mRight = new Solenoid(0);
	}

	public static IWings getInstance() {
		return mInstance;
	}

	// ----- IWings ----- //

	@Override
	public void dropLeft() {
		mLeft.set(true);
	}

	@Override
	public void dropRight() {
		mRight.set(true);
	}

	@Override
	public void reset() {
		mLeft.set(false);
		mRight.set(false);
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getDropLeft())
			dropLeft();
		if (ctrl.getDropRight())
			dropRight();

		if (!(ctrl.getDropLeft() || ctrl.getDropRight()))
			reset();
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putBoolean(getClass().getSimpleName() + " Left State", mLeft.get());
		SmartDashboard.putBoolean(getClass().getSimpleName() + " Right State", mRight.get());
	}

}
