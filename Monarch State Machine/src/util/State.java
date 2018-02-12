package util;

/**
 * 
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface State
{

	/**
	 * 
	 */
	public void execute();

	/**
	 * Method for reporting what state a particular subsystem was set to.
	 * 
	 * @param state
	 */
	public default void reportState(String subsystem, State state)
	{
		System.out.println("Setting " + subsystem + " State: " + state);
	}
}
