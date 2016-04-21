using UnityEngine;
using System.Collections;

/**
	\brief Class that controls the Player on level 2
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
	
*/

public class L2Player : MonoBehaviour 
{
	
	
	public float delayBetweenDeaths = 0.5f;
	/** partsLeft variable relates to the amount of engine part objects left in the level the player needs to collect*/
	private int partsLeft = 4;
	/** livesLeft variable relates to the amount of lives the player has left in the level*/
	private int livesLeft = 3;

	/** Reference to an audio source that will play when an engine part is collided with*/
	public AudioClip EnginePart;
	/** Reference to an audio source that will play when a Badguy is collided with*/
	public AudioClip Die;

	
	/** Creating a message prefab reference*/
	public GameObject fadingMessagePrefab;
	/** Reference to the message entered*/
	public string enginePart = "(message to appear)";
	/** Reference to the message entered*/
	public string died = "(message to appear)";
	
	/** \return The number of parts left to collect in the level*/
	public int GetPartsLeft()
	{
		return partsLeft;
	}
	
	/**\return The number of lives the player has left in the level*/
	public int GetLivesLeft()
	{
		return livesLeft;
	}
	
	/** 
	Method that controls the collisions between the player and the game objects EnginePart and Badguy
	<pre>
	IF
		player hits engine part
		{
			play engine noise and remove a part left
			show message
		}
	IF
		player hits Badguy
		{
			play die noise and remove life left
			show message
		}
	</pre>
	*/
	private void OnTriggerEnter(Collider c)
	{
		string tag = c.tag;
		
		if ("EnginePart" == tag) 
		{
			partsLeft--;
			audio.PlayOneShot(EnginePart);
			
			GameObject newGO = (GameObject)Instantiate(fadingMessagePrefab);
			newGO.guiText.text = enginePart;
			newGO.SetActive(true);
		}

		if ("Badguy" == tag)
		{
			loseLife();
			audio.PlayOneShot(Die);
			
			GameObject newGO = (GameObject)Instantiate(fadingMessagePrefab);
			newGO.guiText.text = died;
			newGO.SetActive(true);
		}
	}

	/** Method that manages the re spawning of the player after he dies*/
	private void MoveToStartPosition()
	{
		GameObject respawnGO = ChooseRandomObjectWithTag ("Respawn");
		Vector3 startPosition = respawnGO.transform.position;
		transform.position = startPosition;
	}
	
	/** 
		Method that finds the the game object with the string passed finds the 
		length of the array of objects with the same tag
		randomizes the selection and returns one of the game objects
	
	\param String with a tag word
	\return tagged object at a random index
	*/
	private GameObject ChooseRandomObjectWithTag (string tag)
	{
		GameObject [] taggedObjects = GameObject.FindGameObjectsWithTag (tag);
		int numTaggedObjects = taggedObjects.Length;
		int randomIndex = Random.Range (0, numTaggedObjects);
		return taggedObjects [randomIndex];
	}
	
	/** Method that manages the amount of lives a player has left in the level
	IF
		lives left = 0 
		{
			Game Over
		}
	*/
	private void loseLife()
	{
		MoveToStartPosition ();
		livesLeft--;	
		
		if (0 == livesLeft)
		{
			Application.LoadLevel("Scene4-GameOver");
		}
	}
	
}
