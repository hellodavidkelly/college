using UnityEngine;
using System.Collections;

/**
	\brief Controls whether the player collected all the parts needed to fix the ship when trigger is entered
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
	
	\warning return values for engine parts needed from the player game object
	
	\bug audio is skipped when game level is loaded
*/


public class L2ShipSensor : MonoBehaviour 
{
	
	/** Reference to the ship game object*/
	public GameObject shipGO;
	/** Reference to the audio file*/
	public AudioClip shipStart;
	/** Reference to the fading message game object*/
	public GameObject fadingMessagePrefab;
	/** Reference to the message entered*/
	public string getParts = "(message to appear)";
	/** Reference to the message entered*/
	public string complete = "(message to appear)";
	
	/** Boolean variable to control when the sound plays*/
	private bool soundStarted = false;
	
	/** Method that manages when the player has collected all the parts needed to fix the ship*/
	
	/**
	 * <pre>
	IF
		has parts
		{
			play sound and load level
		}
	ELSE
		{
			message " Need parts to fix ship"
		}
	</pre>
	*/
	private void OnTriggerEnter(Collider playerGO)
	{
		L2Player player = playerGO.GetComponent<L2Player>();
		
		if (0 == player.GetPartsLeft()) 
		{
			audio.PlayOneShot(shipStart);
			GameObject newGO = (GameObject)Instantiate(fadingMessagePrefab);
			newGO.guiText.text = complete;
			newGO.SetActive(true);
			soundStarted = true;

			if(soundStarted && !audio.isPlaying)
			{
				Application.LoadLevel("Scene3-Level3");
			}
		}
		
		else
		{
			GameObject newGO = (GameObject)Instantiate(fadingMessagePrefab);
			newGO.guiText.text = getParts;
			newGO.SetActive(true);
		}
		
	}
}