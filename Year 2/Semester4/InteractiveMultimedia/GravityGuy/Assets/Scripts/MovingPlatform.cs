using UnityEngine;
using System.Collections;

public class MovingPlatform : MonoBehaviour {
	public float yMovementPerSecond = 1f;

	public float minY = 0f;
	public float maxY = 10f;

	private bool movingUp = true;

	void Update(){
		CheckLimits();
		MovePlatform();
	}

	void MovePlatform(){
		// dy is small amount to change Y position
		float dy = yMovementPerSecond;

		if(!movingUp){
			dy = -yMovementPerSecond;
		}

		// reduce DY based on fraction of a second since last frame
		dy *= Time.deltaTime;

		// move platfor by DY
		transform.Translate(0,dy,0);
	}

	void CheckLimits(){
		float y = transform.position.y;

		// toggle motion if past top / bottom limit
		if(movingUp && (y > maxY)){
			movingUp = false;
		} else if(y < minY){
			movingUp = true;
		}
	}

}
