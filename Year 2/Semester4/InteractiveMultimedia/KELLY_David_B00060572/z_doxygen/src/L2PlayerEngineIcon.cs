using UnityEngine;
using System.Collections;

/**
	\brief Class that displays the engine icons on the screen
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
*/

public class L2PlayerEngineIcon : MonoBehaviour
{
	/** Reference to the player collecting the engine parts*/
	public L2Player player;
	/** Reference to the image displayed on the screen representing the engine parts*/
	public Texture engineOn;
	
	/** Method that manages where on the screen the engine icons are displayed and calls the display method*/
	private void OnGUI()
	{
		Rect r = new Rect(600,0,Screen.width, Screen.height);
		GUILayout.BeginArea(r);
		GUILayout.BeginHorizontal();
		DisplayPartsLeft();
		GUILayout.FlexibleSpace();
		GUILayout.EndHorizontal();
		GUILayout.EndArea();
	}
	
	/** Method that displays the amount of engine parts left in the level*/
	private void DisplayPartsLeft()
	{
		int parts = player.GetPartsLeft();
		
		if (1==parts) 
		{
			for(int i=0; i < 1; i++)
			{
				GUILayout.Label(engineOn);
			}		
		}
		if (2==parts) 
		{
			for(int i=0; i < 2; i++)
			{
				GUILayout.Label(engineOn);
			}		
		}
		if (3==parts) 
		{
			for(int i=0; i < 3; i++)
			{
				GUILayout.Label(engineOn);
			}		
		}
		if (4==parts) 
		{
			for(int i=0; i < 4; i++)
			{
				GUILayout.Label(engineOn);
			}		
		}
	}
}