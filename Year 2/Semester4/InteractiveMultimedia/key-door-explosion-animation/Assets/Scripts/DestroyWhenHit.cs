using UnityEngine;
using System.Collections;

public class DestroyWhenHit : MonoBehaviour 
{

	public GameObject exlosionPrefab;

	private void OnTriggerEnter()
	{
		GameObject newExplosionGO = (GameObject)Instantiate(exlosionPrefab, transform.position, Quaternion.identity);
		//Destroy( newExplosionGO, 1);
		Destroy( gameObject );
	}
}
