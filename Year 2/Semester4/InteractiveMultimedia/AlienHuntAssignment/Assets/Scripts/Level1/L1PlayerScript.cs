using UnityEngine;
using System.Collections;

/**
	\brief Class that controls the Player on level 1
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
	
	\bug audio is cut off when level 2 is loaded
*/

public class L1PlayerScript : MonoBehaviour 
{
	/** partsLeft variable relates to the amount of engine part objects left in the level the player needs to collect*/
	private int partsLeft = 4;
	/** keyCount variable relates to the amount key objects left in the level the player needs to collect*/
	private int keyCount = 2;
	
	/** Reference to an audio source that will play when an engine part is collided with*/
	public AudioClip EnginePart;
	/** Reference to an audio source that will play when an engine part is collided with*/
	public AudioClip FoundKey;
	
	
	/** Creating a message prefab reference*/
	public GameObject fadingMessagePrefab;
	/** Reference to the message entered*/
	public string enginePart = "(message to appear)";
	/** Reference to the message entered*/
	public string keyFound = "(message to appear)";
	

	/** OnTriggerEnter method controls the interaction between the player and the game objects 
	<pre>
	IF 
		player hits engine part
		{
			play engine noise and remove a part left
			show message
		}
	IF
		player hits key
		{
			play key noise and remove key left
			show message
		}
	</pre>
	*/
	private void OnTriggerEnter(Collider c)
	{
		string tag = c.tag;
		
		if ("EnginePart" == tag) 
		{
			audio.PlayOneShot(EnginePart);
			partsLeft--;

			GameObject newGO = (GameObject)Instantiate(fadingMessagePrefab);
			newGO.guiText.text = enginePart;
			newGO.SetActive(true);
			soundStarted = true;
		}
		
		if("Key" == tag)
		{
			audio.PlayOneShot(FoundKey);
			keyCount--;

			GameObject newGO = (GameObject)Instantiate(fadingMessagePrefab);
			newGO.guiText.text = keyFound;
			newGO.SetActive(true);
			soundStarted = true;
		}
	}

	/** Boolean variable to manage the playing of the audio source*/
	private bool soundStarted = false;

	/** Method that delays the loading of the level until after the audio has played*/
	private void OnGUI()
	{
		if (0 == keyCount && 0 == partsLeft) 
		{
			if(soundStarted && !audio.isPlaying)
			{
				Application.LoadLevel("Scene2-Level2");
			}
		}
	}
	
}
