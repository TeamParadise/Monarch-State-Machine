package org.usfirst.frc.team1165.util.models;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IController extends IReportable {
	public boolean getClawToggle();

	public boolean getStageClimb();

	public boolean getClimb();

	public boolean getLinearUp();

	public boolean getLinearDown();

	public boolean getRotaryUp();

	public boolean getRotaryDown();

	public boolean getIntake();

	public boolean getEject();

	public boolean getDropLeft();

	public boolean getDropRight();
}
