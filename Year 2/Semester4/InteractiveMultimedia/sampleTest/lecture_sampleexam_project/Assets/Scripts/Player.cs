using UnityEngine;
using System.Collections;

public class Player : MonoBehaviour {
	public GameObject cameraGO;
	public AudioClip deathSound;
	public int GetScore(){	return score; }
	public int GetLives(){	return lives; }

	private int score = 0;
	private int lives = 2;
	private float deathY = 2f;

	private Vector3 startPosition;

	private void Start()
	{
		startPosition = transform.position;
	}

	private void Update()
	{
		CheckHeight();
	}

	private void CheckHeight()
	{
		float y = transform.position.y;
		if(y < deathY)
		{
			LoseLife();
		}
	}

	private void LoseLife()
	{
		lives--;
		transform.position = startPosition;
	}


	private void OnTriggerEnter(Collider c)
	{
		string tag = c.tag;
		
		if("Teleport" == tag)
		{
			if(cameraGO.audio.isPlaying)
			{
				print ("would Application.LoadLevel(wingame) now");
			}
			else 
			{
				print ("lose game becuase music has finished");
			}
		}
		
		if("Eyeball" == tag)
		{
			audio.PlayOneShot(deathSound);
			LoseLife();
		}

		if("Gold" == tag)
		{
			score++;
		}
	}

}
