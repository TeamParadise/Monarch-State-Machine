package org.usfirst.frc.team1165.util.models.subsystems;

import org.usfirst.frc.team1165.util.models.ISubsystem;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IShooter extends ISubsystem
{
	void intake();
	
	void eject();
	
	void stop();
}
