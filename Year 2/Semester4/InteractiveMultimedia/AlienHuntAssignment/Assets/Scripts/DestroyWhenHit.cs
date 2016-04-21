using UnityEngine;
using System.Collections;

/**
	\brief Destroys the game object when the trigger is entered
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
*/

public class DestroyWhenHit : MonoBehaviour {

	private void OnTriggerEnter()
	{
		Destroy( gameObject );
	}
}
