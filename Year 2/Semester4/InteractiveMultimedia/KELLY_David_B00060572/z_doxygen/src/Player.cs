using UnityEngine;
using System.Collections;

/**
	\brief Class that controls the player for level 3
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
	
	\bug if player loses all his lives the audio is interrupted by the new level loaded
*/

public class Player : MonoBehaviour 
{

	public float delayBetweenDeaths = 0.5f;
	/** Reference to the amount of engine parts the player must collect on level 3*/
	private int partsLeft = 5;
	/** Reference to the amount of lives the player has on level 3*/
	private int livesLeft = 3;
	/** Variable to store the value when the key object is found*/
	private int keyCount = 0;

	/** Reference to the audio clip file*/
	public AudioClip EnginePart;
	/** Reference to the audio clip file*/
	public AudioClip Die;
	/** Reference to the audio clip file*/
	public AudioClip FoundKey;

	
	/** Creating a message prefab reference*/
	public GameObject fadingMessagePrefab;
	/** Reference to the message that will appear*/
	public string enginePart = "(message to appear)";
	/** Reference to the message that will appear*/
	public string died = "(message to appear)";
	
	/** \return Returns the int value of the remaining Engine Parts on level 3*/
	public int GetPartsLeft()
	{
		return partsLeft;
	}

	/** \return Returns the lives remaining for the player on level 3*/
	public int GetLivesLeft()
	{
		return livesLeft;
	}
	
	/** 
		Method that manages the items collided with by the referenced player
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

		if("Key" == tag)
		{
			keyCount++;
			audio.PlayOneShot(FoundKey);
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

	/** Method that returns the integer value of the key left in level 3*/
	/** \return integer value*/
	public int GetKeyCount()
	{	
		return keyCount;	
	}
	
	/**
		Method that returns the boolean value reference to if the player has the key
		\return boolean value
	*/
	public bool IsCarryingKey()
	{
		if(keyCount > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/** Method that removes the key item for the player after opening the door*/
	public void DropKey(){
		if(keyCount > 0)
		{
			keyCount--;
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

	/** 
		Method that manages the lives of the player
	<pre>
	IF
		livesLeft = 0
		{
			Game Over
		}
	</pre>
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
