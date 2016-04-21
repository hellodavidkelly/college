using UnityEngine;
using System.Collections;

/**
	\brief Class that manages the display of the key icon if the player has the key or not
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
*/

public class PlayerInventoryIcon : MonoBehaviour
{
	/** Reference to the player*/
	public Player player;
	/** Reference to the image file*/
	public Texture keyIcon;
	/** Reference to the image file*/
	public Texture emptyIcon;

	/** Reference to the fading message prefab*/
	public GameObject fadingMessagePrefab;
	/** Reference to the message that will appear*/
	public string messageText = "(message to appear)";


	/** 
		Method that displays the icons depending on whether or not the player has collected the key object
	<pre>
	IF
		player has key
		{
			display key icon
		}
	ELSE
		{
			display empty key icon
		}
	</pre>	
	*/
	private void OnGUI()
	{
		bool isCarryingKey = player.IsCarryingKey();

		if (isCarryingKey) 
		{
			GUILayout.Label (keyIcon);
		} 
		else 
		{
			GUILayout.Label (emptyIcon);
		}
	}

	/** Method that manages if the player has collided with the key object*/
	private void OnTriggerEnter(Collider hitCollider)
	{
		bool isCarryingKey = player.IsCarryingKey();

		if( "Key" == hitCollider.tag )
		{
			isCarryingKey = true;
			Destroy ( hitCollider.gameObject );

			GameObject newGO = (GameObject)Instantiate(fadingMessagePrefab);
			newGO.guiText.text = messageText;
			newGO.SetActive(true);
		}
	} 

}