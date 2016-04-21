package lab4.part1;

import java.util.Vector;

/**
 * 
 * @author luke raeside
 * @version 27-02-2013
 * 
 * This is a class to represent the Solar System
 */

public class SolarSystem {
	
	private long numCelestialBodies; //Number of bodies in the solar system
	private long numSun; //The number of allowable Suns, e.g., Earth's solar system has only one
	private Vector<CelestialBody> solarSystem= new Vector<CelestialBody>();

	/**
	 * Create a Solar System
	 * 
	 * @param numCelestialBodies Total number of bodies in the system
	 * @param numSun The number of suns (stars) in solar system
	 */
	public SolarSystem(int numSun) {
		this.numSun=numSun;
	}
	
	/**
	 * Create a Solar System with default constructor
	 */
	public SolarSystem() {
		this.numCelestialBodies=0;
		this.numSun=1; //default to one Sun
	}

	/**
	 * Method to return the number of Suns in solar system
	 * 
	 * @return long Number of Suns in the Solar system
	 */
	public long getNumSuns() {
		// TODO Auto-generated method stub
		return numSun;
	}
	
	/**
	 * Method to add a Sun to the solar system
	 * 
	 * @param sun A Sun to add to the solar system
	 */
	public void addSun(Sun sun) {
		solarSystem.add(sun);
	}
	
	/**
	 * Method to override java.lang.Object toString() method to output all details of Solar System
	 */
	public String toString() {
		
		String systemDetails="Solar System Details:\n";
		String sun="";
		
		for(int i=0;i<solarSystem.size();i++) {
			if(solarSystem.elementAt(i) instanceof Sun) { //Print Sun information to output String
				sun=((Sun)solarSystem.elementAt(i)).getName();
				systemDetails=systemDetails + "\nSun " + (i+1) + " name \"" + sun + "\" Sun orbited by: ";
				Vector<CelestialBody> orbitObj = ((Sun)solarSystem.elementAt(i)).getOrbitingBodies();
				for(int j=0;j<orbitObj.size();j++) { //Print orbiting objects to output String
					if(orbitObj.elementAt(j) instanceof Planet) {
						systemDetails = systemDetails + (" \"" + ((Planet)orbitObj.elementAt(j)).getName() + "\"");
					}
				}
			}
		}	
		
		return systemDetails;
	}
	
}
