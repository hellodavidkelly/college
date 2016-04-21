using UnityEngine;
using System.Collections;

public class Player : MonoBehaviour {

	public int score = 0;

	private void OnGUI()
	{
//		string keyMessage = "carrying key = " + carryingKey;
//		GUILayout.Label(keyMessage);

		GUILayout.Label(score);
	}

	private void OnTriggerEnter(Collider c)
	{
		string tag = c.tag;

		if("Food" == tag)
		{
			GUILayout.Label(score = score + 10);
		}
	}


}
