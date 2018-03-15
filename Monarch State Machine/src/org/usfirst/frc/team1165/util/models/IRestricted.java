package org.usfirst.frc.team1165.util.models;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IRestricted {
	double getLowerBound();

	double getUpperBound();

	boolean allow(double speed);

	void restrict();
}
