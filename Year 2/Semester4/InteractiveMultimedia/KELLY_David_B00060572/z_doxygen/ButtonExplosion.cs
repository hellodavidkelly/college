using UnityEngine;
using System.Collections;

/** 
	\brief Class to demonstrate Doxygen, GUI example code ...
	
	\author Matt Smith
	\version 1.0
	\date    2012
	
	\warning not sure about min/max speeds - needs player testing !
	
	\bug I don't think this works for iPhone applications ...


	This class defines a player object that will move left and right with arrow keys
	<br/>
	use breaks and list items for better layout if you want...
	<pre>
IF
	you want to include PSEUDOCODE
THEN 
	pre-elements are a good way to do this
	since lines and tabs will be preserved in the HTML page
END IF
	</pre>
 */
 
public class ButtonExplosion : MonoBehavissour 
{
	/** referece to the EXPLOSION prefab project file */
	public GameObject explosionPrefab;

	//---------------------------------------------
	/**
	 GUI method - display button to create explosion 
	 */
	void OnGUI()
	{
		if( GUILayout.Button("Create explosion") )
		{
			Instantiate( explosionPrefab );
		}

	}
	
	//---------------------------------------------
	/**
		 calculate 3 times the value given

		 \param n an integer argument - the number to treble
		 \return 3 times the value given
	 */
	 private int TrebleMe(int n)
	 {
	 	return 3 * n;
	 }
	
} // class

