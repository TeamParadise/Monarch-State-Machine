package org.usfirst.frc.team1165.util.models.controller;

/**
 * An interface allowing human control of the robot during teleop mode.
 * 
 * @author Kesav Kadalazhi
 * 
 * @see IDriverController
 * @see ICoDriverController
 *
 */
public interface IController extends IDriverController, ICoDriverController {

	/**
	 * Dampens an input along an axis [-1.0..1.0]. Default damp is cubed.
	 * 
	 * @param input
	 *            the value to be dampened
	 * 
	 * @return the dampened value
	 */
	double dampen(double input);

	/**
	 * Dampens an input along an axis [-1.0..1.0] by a specified amount. Preserves
	 * sign.
	 * 
	 * @param input
	 *            the value to be dampened
	 * @param damp
	 *            how much to dampen the input
	 * 
	 * @return the dampened value
	 */
	double dampen(double input, double damp);

	/**
	 * Restricts an input along an axis [-1.0..1.0] between two numbers.
	 * 
	 * @param input
	 *            the value to be restricted
	 * @param low
	 *            the lower bound of the restriction
	 * @param high
	 *            the upper bound of the restriction
	 * 
	 * @return the restricted value
	 */
	double restrict(double input, double low, double high);
}
