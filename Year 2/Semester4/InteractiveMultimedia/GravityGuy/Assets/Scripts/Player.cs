using UnityEngine;
using System.Collections;

public class Player : MonoBehaviour 
{

	public AudioClip yumSound;
	public AudioClip dieSound;

	public float delayBetweenDeaths = 0.5f;
	public float nextTimeAllowedToDie = 0;

	private int score = 0;
	private int lives = 3;
	
	public int GetScore()
	{
		return score;
	}

	public int GetLives()
	{
		return lives;
	}
	

	private void Update()
	{
		if (lives <= 0) 
		{
			Application.LoadLevel ("GameOver");
		}

		CheckGameWon ();
	}

	private void OnTriggerEnter2D(Collider2D c)
	{
		string tag = c.tag;

		if ("Food" == tag) 
		{
			score++;
			audio.PlayOneShot(yumSound);
		}

		if ("Spikes" == tag) 
		{
			if(Time.time>nextTimeAllowedToDie)
			{
				loseLife();
			}
		}
	}

	private void MoveToStartPosition()
	{
		GameObject respawnGO = ChooseRandomObjectWithTag ("Respawn");
		Vector3 startPosition = respawnGO.transform.position;
		transform.position = startPosition;
	}

	private GameObject ChooseRandomObjectWithTag (string tag)
	{
		GameObject [] taggedObjects = GameObject.FindGameObjectsWithTag (tag);
		int numTaggedObjects = taggedObjects.Length;
		int randomIndex = Random.Range (0, numTaggedObjects);
		return taggedObjects [randomIndex];
	}

	private int CountObjectsWithTag (string tag)
	{
		GameObject[] foodObjects = GameObject.FindGameObjectsWithTag (tag);
		return foodObjects.Length;
	}

	private void loseLife()
	{
		audio.PlayOneShot (dieSound);
		MoveToStartPosition ();
		lives--;

		nextTimeAllowedToDie = Time.time + delayBetweenDeaths;
	}

	public void CheckGameWon()
	{
		int numFoodObjects = CountObjectsWithTag ("Food");
		print ("number of food objects left = " + numFoodObjects);

		if (numFoodObjects < 1) 
		{
			Application.LoadLevel("gameWon");
		}
	}

}
