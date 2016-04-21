using UnityEngine;
using System.Collections;

/**
	\brief Interacts with the actions of the user when starting the game
	
	\author David Kelly
	\version 1.0
	\date 20/4/14
	
*/

public class PlayRolloverMenu: MonoBehaviour {
	/** Reference to image to be displayed*/
	public Texture2D normalImage;
	/** Reference to image to be displayed*/
	public Texture2D rolloverImage;

	/** Method that manages when the mouse is hovered over the image*/	
	private void OnMouseOver(){
		guiTexture.texture = rolloverImage;
	}
	/** Method that manages when the mouse leaves the image*/	
	private void OnMouseExit(){
		guiTexture.texture = normalImage;		
	}
	/** Method that manages when the mouse clicks on the image*/	
	private void OnMouseUp(){
		Application.LoadLevel( "Scene1-Level1" );
	}
}

