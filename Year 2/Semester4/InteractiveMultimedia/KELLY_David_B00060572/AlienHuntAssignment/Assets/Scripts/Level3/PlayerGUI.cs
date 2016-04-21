using UnityEngine;
using System.Collections;

/**
	\brief Class that displays the players lives left on level 3
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
*/


public class PlayerGUI : MonoBehaviour
{

	/** Reference to the player object the lives are related to*/
	public Player player;
	/** Reference to the image used to represent the lives*/
	public Texture robotLife;

	/** 
		Method that gets the amount of lives left from the player then calls the method ImagesForInteger
		Displays the images in the format set
	*/
	private void OnGUI()
	{
		int livesLeft = player.GetLivesLeft();

		Rect r = new Rect(200,0,Screen.width, Screen.height);
		GUILayout.BeginArea(r);
		GUILayout.BeginHorizontal();
		ImagesForInteger(livesLeft, robotLife);
		GUILayout.FlexibleSpace();
		GUILayout.EndHorizontal();
		GUILayout.EndArea();
	}

	/** 
		Method that receives values to add to the GUILayout through a for loop
		\param total relates to the amount of lives left
		\param icon is the image reference to be displayed
	*/
	private void ImagesForInteger(int total, Texture icon) {
		for(int i=0; i < total; i++)
		{
			GUILayout.Label(icon);
		}
	} 
}