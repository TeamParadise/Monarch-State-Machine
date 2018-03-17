
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.Controller;
import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.util.models.controller.IController;
import org.usfirst.frc.team1165.util.models.subsystems.IClimber;
import org.usfirst.frc.team1165.util.states.ClimberState;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem implements IClimber {
	private static final Climber mInstance = new Climber();

	private IController ctrl = Controller.getInstance();

	private DoubleSolenoid mClimber = RobotMap.mClimberSolenoid;

	protected Climber() {
	}

	public static Climber getInstance() {
		return mInstance;
	}

	// ----- IClimber ----- //

	@Override
	public void set(ClimberState state) {
		mClimber.set(state.get());
	}

	// ----- IControllable ----- //

	@Override
	public void control() {
		if (ctrl.getStageClimb()) {
			set(ClimberState.STAGE_CLIMB);
		} else if (ctrl.getClimb()) {
			set(ClimberState.CLIMB);
		}
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putString(getName() + " State", mClimber.get().toString());
	}

	// ----- Subsystem ----- //

	@Override
	protected void initDefaultCommand() {
	}

}
