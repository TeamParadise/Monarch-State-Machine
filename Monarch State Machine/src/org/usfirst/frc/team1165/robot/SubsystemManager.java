package org.usfirst.frc.team1165.robot;

import java.util.ArrayList;

import org.usfirst.frc.team1165.robot.commands.ExecuteState;
import org.usfirst.frc.team1165.robot.subsystems.AirCompressor;
import org.usfirst.frc.team1165.robot.subsystems.Claw;
import org.usfirst.frc.team1165.robot.subsystems.ClimberIsolate;
import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston;
import org.usfirst.frc.team1165.robot.subsystems.FrontShooter;
import org.usfirst.frc.team1165.robot.subsystems.PneumaticsTest;
import org.usfirst.frc.team1165.robot.subsystems.RearShooter;
import org.usfirst.frc.team1165.robot.subsystems.StateMachine;

import org.usfirst.frc.team1165.robot.subsystems.superstructures.Climber;
import org.usfirst.frc.team1165.robot.subsystems.superstructures.Intake;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import util.State;

public class SubsystemManager
{
	private ArrayList<StateMachine> mSubsystems = new ArrayList<StateMachine>();

	private ArrayList<SendableChooser<State>> mChoosers = new ArrayList<SendableChooser<State>>();
	
	public SubsystemManager()
	{
//		add(FrontShooter.getInstance());
//		add(RearShooter.getInstance());
//		add(Claw.getInstance());
		add(Intake.getInstance());

//		add(ClimberPiston.getInstance());
//		add(ClimberIsolate.getInstance());
//		add(Climber.getInstance());
//
//		add(AirCompressor.getInstance());
		
		add(PneumaticsTest.getInstance());
	}

	public void add(StateMachine subsystem)
	{
		mSubsystems.add(subsystem);
		mChoosers.add(subsystem.getStateChooser());
	}

	public void report()
	{
		mSubsystems.forEach((s) -> s.report());
	}

	public void putStateChooser()
	{
		mChoosers.forEach((chooser) -> SmartDashboard.putData(chooser));
	}

	public void putSelectedState()
	{
		for(int i=0;i<mChoosers.size();i++)
		{
			String subsystemName = mSubsystems.get(i).getClass().getSimpleName();
			ExecuteState command = new ExecuteState(mChoosers.get(i).getSelected());
			
			SmartDashboard.putData("Set " + subsystemName + " State", command);
		}
	}

}

