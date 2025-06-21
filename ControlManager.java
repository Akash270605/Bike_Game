import java.util.Vector;

/**
 * this class manages all controls in a vector
 
 */
public class ControlManager {

	static Vector<Control> allControls = getAllControls();
	static int numControls = numControls();
	
	/**
	 * this method populates the vector for all controls 
	
	 */
	public static Vector<Control> getAllControls(){
		Vector<Control> returnV = new Vector();
		//first the basic controls (keyboard and mouse)
		returnV.add(new KeyboardControl());
		
//		
		return returnV;
	}
	
	/**
	 * this method gets the total number of controls
	 * @return size of the vector containing all controls
	 */
	public static int numControls(){
		return allControls.size();
	}
	
	
}
