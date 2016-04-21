using UnityEngine;
using System.Collections;

public class GUITextHideAfterDelay : MonoBehaviour {
	public void Show(string newMessage, float seconds){
		delay = seconds;
		guiText.text = newMessage;
		guiText.enabled = true;
	}
	
	private void Start(){
		guiText.enabled = false;
	}
		
	private float delay = 0;
	
	private void Update(){
		if( delay > 0){
			delay -= Time.deltaTime;
		}
		
		if( delay < 0){
			guiText.enabled = false;
		}
	}
	
	

}
