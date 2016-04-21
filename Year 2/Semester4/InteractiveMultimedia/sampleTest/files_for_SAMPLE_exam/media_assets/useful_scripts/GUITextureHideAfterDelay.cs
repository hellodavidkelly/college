using UnityEngine;
using System.Collections;

public class GUITextureHideAfterDelay : MonoBehaviour {
	public void Show(float seconds){
		delay = seconds;
		guiTexture.enabled = true;
	}
	
	private void Start(){
		guiTexture.enabled = false;
	}
		
	private float delay = 0;
	
	private void Update(){
		if( delay > 0){
			delay -= Time.deltaTime;
		}
		
		if( delay < 0){
			guiTexture.enabled = false;
		}
	}
	
	

}
