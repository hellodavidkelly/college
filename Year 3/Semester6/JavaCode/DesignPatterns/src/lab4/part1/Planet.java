package lab4.part1;

/**
 * 
 * @author luke raeside
 * @version 27-02-2013
 * 
 * This is a class to represent a Planet in Solar system which orbits a Sun
 */

public class Planet extends CelestialBody {

	String name;
	Sun sun;
	double distanceFromSun;
	
	/**
	 * Construtor to construct Planet with name and sun parameters
	 * 
	 * @param name String The name of the Planet
	 * @param sun Sun The Sun object associated with the Planet (the Sun it orbits)
	 */
	public Planet(String name, Sun sun) {
		this.sun = sun; //set Sun that this palanet belongs to
		sun.addOrbitingBody(this); //add Planet to Suns orbit
		this.name = name;
	}
	
	/**
	 * Construtor to construct Planet with name, sun and distance parameters
	 * 
	 * @param name String The name of the Planet
	 * @param sun Sun The Sun object associated with the Planet (the Sun it orbits)
	 * @param distanceFromSun double Specify distance from the Sun in Km
	 */
	public Planet(String name, Sun sun, double distanceFromSun) {
		this.sun = sun; //set Sun that this palanet belongs to
		sun.addOrbitingBody(this); //add Planet to Suns orbit
		this.distanceFromSun=distanceFromSun;
	}
	
	/**
	 * Override accessor from abstract base class
	 */
	public String getName() {
		return name;
	}
}
