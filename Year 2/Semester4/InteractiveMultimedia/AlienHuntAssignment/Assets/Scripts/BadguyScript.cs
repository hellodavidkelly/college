using UnityEngine;
using System.Collections;

/**
	\brief Class to control the movement of the Badguy prefab
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
	
*/

public class BadguyScript : MonoBehaviour {
	/** A public variable to control the speed the Badguy prefab moves*/
	public float xMovementPerSecond = 1f;
	/** A public variable to control the minimum value on the X axis the Badguy prefab can move between*/
	public float minX = 0f;
	/** A public variable to control the maximum value on the X axis the Badguy prefab can move between*/
	public float maxX = 10f;
	/** A boolean variable to control when the prefab has reached the boundaries*/
	private bool movingLeft = true;
	
	void Update(){
		CheckLimits();
		MovePlatform();
	}
	/** Move Platform method controls the movement of the Badguy prefab*/
	void MovePlatform(){
		// dy is small amount to change X position
		float dx = xMovementPerSecond;
		
		if(!movingLeft){
			dx = -xMovementPerSecond;
		}
		
		// reduce DY based on fraction of a second since last frame
		dx *= Time.deltaTime;
		
		// move platfor by DY
		transform.Translate(dx,0,0);
	}
	
	/**Check Limits method controls when the Badguy prefab has reached the boundary values*/
	void CheckLimits(){
		float x = transform.position.x;
		
		// toggle motion if past top / bottom limit
		if(movingLeft && (x > maxX)){
			movingLeft = false;
		} else if(x < minX){
			movingLeft = true;
		}
	}
	
}
