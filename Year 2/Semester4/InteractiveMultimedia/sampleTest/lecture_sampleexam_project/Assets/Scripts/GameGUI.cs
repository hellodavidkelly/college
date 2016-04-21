using UnityEngine;
using System.Collections;

public class GameGUI : MonoBehaviour {
	public Texture2D gold0Image;
	public Texture2D gold1Image;
	public Texture2D gold2Image;
	public Texture2D lives0Image;
	public Texture2D lives1Image;
	public Texture2D lives2Image;

	public Player player;

	private void OnGUI()
	{
		DisplayScore();
		DisplayLives();
	}

	private void DisplayScore()
	{
		int score = player.GetScore();
		/*
		string scoreMessage = "Score: " + score;
		GUILayout.Label(scoreMessage);
		*/
		if(0 == score){
			GUILayout.Label(gold0Image);
		}
		
		if(1 == score){
			GUILayout.Label(gold1Image);
		}
		
		if(2 == score){
			GUILayout.Label(gold2Image);
		}
		
	}


	private void DisplayLives()
	{
		int lives = player.GetLives();
		if(0 == lives){
			GUILayout.Label(lives0Image);
		}
		
		if(1 == lives){
			GUILayout.Label(lives1Image);
		}

		if(2 == lives){
			GUILayout.Label(lives2Image);
		}
		
	}

}
