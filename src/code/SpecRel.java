package code;

import java.lang.Math;

public class SpecRel {
	
	public static double alphaDeg; //alpha, in degrees, used for eventual display
	public static double velocity = 0.5; //fraction of the speed of light
	public static final double c = 299800000.0; //speed of light in m/s
	
	public void alphaDegCalc(){
		double alphaRad = Math.atan(velocity);
		alphaDeg = (Math.PI / 180) * alphaRad;
	}
	
}
