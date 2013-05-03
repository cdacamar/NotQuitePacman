package com.notquitepacman.cs213;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author Cameron
 *
 */
public class NotQuitePacmanActivity extends Activity implements OnClickListener
{
	/** Called when the activity is first created. */
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		((Button) findViewById(R.id.btnNew)).setOnClickListener(this);
		((Button) findViewById(R.id.btnQuit)).setOnClickListener(this);
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View view)
	{
		switch (view.getId()) //Simply quit the game
		{
		case R.id.btnQuit:
			finish();
			break;
		case R.id.btnNew: //Hitting the new game button serves as the main entry point into the game
			Intent newGame = new Intent(NotQuitePacmanActivity.this,
					GameState.class);
			newGame.putExtra("board", new Board());
			startActivity(newGame); //push a new activity onto the stack
			break;
		}
	}
}