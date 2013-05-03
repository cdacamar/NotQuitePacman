/**
 * 
 */
package com.notquitepacman.cs213;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author Cameron
 * 
 */
public class GameState extends Activity
{
	public void onCreate(Bundle bundle) //Create a new game in this activity
	{
		super.onCreate(bundle);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		Board board   = (Board) extras.get("board"); //Retrieve the board, the reason I do it this way 
												   //is that if we want different levels, this is the way to do it
		GameCanvas view = new GameCanvas(this, board);
		setContentView(view);
	}
}
