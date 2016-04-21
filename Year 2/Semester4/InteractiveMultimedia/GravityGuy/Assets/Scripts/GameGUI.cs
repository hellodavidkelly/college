using UnityEngine;
using System.Collections;

public class GameGUI : MonoBehaviour 
{
	public Player player;
	public Texture2D lives0Image;
	public Texture2D lives1Image;
	public Texture2D lives2Image;

	private void OnGUI()
	{
		DisplayLives ();
		DisplayScore ();
	}

	private void DisplayLives()
	{
		int playerLives = player.GetLives();

		if (1==playerLives) 
		{
			GUILayout.Label (lives0Image);
		}
		if (2==playerLives) 
		{
			GUILayout.Label (lives1Image);
		}
		if (3==playerLives) 
		{
			GUILayout.Label (lives2Image);
		}
	}

	private void DisplayScore()
	{
		int playerScore = player.GetScore();
		string scoreMessage = "Score = " + playerScore;
		GUILayout.Label (scoreMessage);
	}
}
