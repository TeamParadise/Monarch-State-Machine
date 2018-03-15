
package org.usfirst.frc.team1165.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import org.usfirst.frc.team1165.util.Controller;
import org.usfirst.frc.team1165.util.models.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IClimber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber implements IClimber {
	private static final IClimber mInstance = new Climber();

	private IController ctrl = Controller.getInstance();

	private DoubleSolenoid mClimber;

	protected Climber() {
		mClimber = new DoubleSolenoid(2, 3);
	}

	public static IClimber getInstance() {
		return mInstance;
	}

	// ----- IClimber ----- //

	@Override
	public void stageClimb() {
		mClimber.set(kForward);
	}

	@Override
	public void climb() {
		mClimber.set(kReverse);
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getStageClimb())
			stageClimb();
		else if (ctrl.getClimb())
			climb();
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putString(getClass().getSimpleName() + " State", mClimber.get().toString());
	}

}
