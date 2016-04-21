using UnityEngine;
using System.Collections;

/**
	\brief Controls the interaction of player and the door
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
	
	\warning player must have collected the items being returned from the player class
	
	\bug sound doesn't play completely when level is loaded
*/

public class DoorSensorScript : MonoBehaviour {
	/** Creating a game object to reference*/
	public GameObject cubeGO;
	/** Creating an audio file to reference*/
	public AudioClip Close;
	/** Creating an audio file to reference*/
	public AudioClip Open;
	/** Creating a message prefab reference*/
	public GameObject fadingMessagePrefab;
	public string messageText = "(message to appear)";
	/** boolean variable to control if the door is open or not*/
	private bool doorIsAlreadyOpen = false;

	/**<pre>
	IF
		Door is closed and has key
		{
			open door and drop key
		}
	ELSE
		{
			show message "need key"	
		}
	
	</pre>
	*/
	/** Method that controls is the players interaction with the door*/
	private void OnTriggerEnter(Collider playerGO)
	{
		/** Reference to the player game object*/
		Player player = playerGO.GetComponent<Player>();
		/** boolean variable that gets the return value if the player has the key or not*/
		bool playerHasKey = player.IsCarryingKey();
		
		if(!doorIsAlreadyOpen)
		{
			TryToOpenDoor(playerHasKey, player);
		}
		
	}
	
	/** Method that uses the player and the return variable to control the actions of the door*/
	
	/** \param hasKey a boolean and player is reference to the player game object*/
	private void TryToOpenDoor(bool hasKey, Player player)
	{
		if(hasKey)
		{
			OpenDoor();
			player.DropKey();
			doorIsAlreadyOpen = true;
		}
		else
		{
			audio.PlayOneShot(Close);
			GameObject newGO = (GameObject)Instantiate(fadingMessagePrefab);
			newGO.guiText.text = messageText;
			newGO.SetActive(true);
		}
	}
	
	/** Method that opens the door if the conditions are met in TryToOpenDoor method*/
	private void OpenDoor()
	{
		audio.PlayOneShot (Open);
		Animation cubeAnimation = cubeGO.animation;
		cubeAnimation.Play();
	}
}
