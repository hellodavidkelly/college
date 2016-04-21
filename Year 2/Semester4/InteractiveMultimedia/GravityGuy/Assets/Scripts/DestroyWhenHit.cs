using UnityEngine;
using System.Collections;

public class DestroyWhenHit : MonoBehaviour {

	private void OnTriggerEnter2D(){
		Destroy(this.gameObject);
	}
}
