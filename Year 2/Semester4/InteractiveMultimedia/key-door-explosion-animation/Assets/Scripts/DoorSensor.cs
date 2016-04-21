using UnityEngine;
using System.Collections;

public class DoorSensor : MonoBehaviour {
	public GameObject cubeGO;

	private bool doorIsAlreadyOpen = false;

	private void OnTriggerEnter(Collider playerGO)
	{
		Player player = playerGO.GetComponent<Player>();
		bool playerHasKey = player.IsCarryingKey();

		if(!doorIsAlreadyOpen)
		{
			TryToOpenDoor(playerHasKey, player);
		}

	}

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
			audio.Play ();
		}
	}

	private void OpenDoor()
	{
		Animation cubeAnimation = cubeGO.animation;
		cubeAnimation.Play();
	}
}
