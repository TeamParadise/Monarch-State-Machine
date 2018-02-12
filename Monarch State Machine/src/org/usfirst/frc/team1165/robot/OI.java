package org.usfirst.frc.team1165.robot;

import org.usfirst.frc.team1165.robot.commands.ExecuteState;
import org.usfirst.frc.team1165.robot.subsystems.superstructures.Intake.IntakeState;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	private XboxController mController = new XboxController(1);
	
	private JoystickButton mButtonA  = new JoystickButton(mController, 1);
	private JoystickButton mButtonB  = new JoystickButton(mController, 2);
	private JoystickButton mButtonX  = new JoystickButton(mController, 3);
	private JoystickButton mButtonY  = new JoystickButton(mController, 4);
	private JoystickButton mButtonLB  = new JoystickButton(mController, 5);
	private JoystickButton mButtonRB  = new JoystickButton(mController, 6);
	private JoystickButton mButtonLeftStick  = new JoystickButton(mController, 9);
	private JoystickButton mButtonRightStick = new JoystickButton(mController, 10);
	
	public OI()
	{
		mButtonA.whenPressed(new ExecuteState(IntakeState.IDLE));
		mButtonB.whenPressed(new ExecuteState(IntakeState.OPEN));
		mButtonX.whenPressed(new ExecuteState(IntakeState.STAGE_INTAKE));
		mButtonY.whenPressed(new ExecuteState(IntakeState.TWIST_RIGHT));
		mButtonLB.whenPressed(new ExecuteState(IntakeState.TWIST_LEFT));
		mButtonRB.whenPressed(new ExecuteState(IntakeState.INTAKE));
		mButtonLeftStick.whenPressed(new ExecuteState(IntakeState.STORE));
		mButtonRightStick.whenPressed(new ExecuteState(IntakeState.SPIT));
		
	}

	public void report()
	{
		SmartDashboard.putNumber("Controller Left X", mController.getX(Hand.kLeft));
		SmartDashboard.putNumber("Controller Right X", mController.getX(Hand.kRight));
	}
}
