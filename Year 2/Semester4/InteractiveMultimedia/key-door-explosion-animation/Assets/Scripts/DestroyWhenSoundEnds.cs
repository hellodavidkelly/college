using UnityEngine;
using System.Collections;

public class DestroyWhenSoundEnds : MonoBehaviour {
	private void Update () {
		bool soundPlaying = audio.isPlaying;
		if(!soundPlaying)
		{
			Destroy(gameObject);
		}
	}
}
