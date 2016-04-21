using UnityEngine;
using System.Collections;

public class GameManager : MonoBehaviour {
	public GameObject bridgePrefab;
	public Player player;
	public GameObject arrowGO;


	private bool bridgeCreated = false;
	
	private void Update()
	{
		CheckScore();
	}
	
	private void CheckScore()
	{
		int score = player.GetScore();
		if(score > 0 && !bridgeCreated)
		{
			bridgeCreated = true;
			GameObject.Instantiate(bridgePrefab);
			arrowGO.animation.Play ();
			audio.Play ();
		}
	}
}
