package org.usfirst.frc.team1165.util.models;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface IRestricted
{
	double getLowerBound();

	double getUpperBound();
	
	void restrict();
}
