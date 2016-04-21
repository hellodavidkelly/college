using UnityEngine;
using System.Collections;

public class GameWonBehaviour : MonoBehaviour 
{

	public void PlaySound()
	{
		audio.Play();
		soundStarted = true;
	}
	
	private bool soundStarted = false;
	
	private void Update()
	{
		if(soundStarted && !audio.isPlaying)
		{
			// put in here whatever action you want to do when the sound finishes playing
			// e.g.
			Application.LoadLevel( 0 );
		}
	}
}
