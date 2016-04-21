// file: FadingMessage
using UnityEngine;
using System.Collections;

/**
	\brief Prefab object that displays a message that fades on screen
	
	\author David Kelly
	\version 1.0
	\date 20/4/14

*/

public class FadingMessage : MonoBehaviour 
{
	const int TOTAL_FRAMES = 100;	
	
	private float alpha = 1.0f;
	private float alphaStep = 1.0f / TOTAL_FRAMES;
	private float deathAlpha;
	private float r;
	private float g;
	private float b;
	
	private void Awake() 
	{
		deathAlpha = 2 * alphaStep;;
		Color startColor = guiText.material.color;
		alpha = startColor.a;
		
		r = startColor.r;
		g = startColor.g;
		b = startColor.b;
	}
	
	private void Update() 
	{
		alpha -= alphaStep;
		
		if( alpha < deathAlpha)
			Destroy(gameObject);
		
		Color newColor = new Color(r, g, b, alpha); 
		guiText.material.color = newColor;
	}
}