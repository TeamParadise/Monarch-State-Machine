package org.usfirst.frc.team1165.util;

import org.usfirst.frc.team1165.util.models.INavX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class NavX implements INavX {

	private static final NavX mInstance = new NavX();

	protected NavX() {
	}

	public static NavX getInstance() {
		return mInstance;
	}

	// ----- INavX ----- //

	public double getHeading() {
		return 0;
	}

	// ----- IReportable ----- //

	@Override
	public void report() {
		SmartDashboard.putNumber(getClass().getSimpleName() + " Heading", getHeading());
	}
}