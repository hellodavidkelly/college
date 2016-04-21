using UnityEngine;
using System.Collections;

public class DestroyWhenHit : MonoBehaviour {

	private void OnTriggerEnter(){
		Destroy ( gameObject );
	}
}
