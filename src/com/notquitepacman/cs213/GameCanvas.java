/**
 * 
 */
package com.notquitepacman.cs213;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author Cameron
 * 
 */
public class GameCanvas extends View
{
	private Board board; //The board class to handle game board operations
	private float cellWidth, cellHeight; //discover how much we can draw in each tile
	private int width, height; //height and width of the screen
	private Activity context; //context of this activity
	private Paint plyr, ghost, closed, open, crump; //paints to draw different colors
	private Player player; //the player entity
	private Blinky blinky; //the blinky ghost entity
	private final long delay = 100, powerballDur = 3000; //delay between draw and how long the player can have a powerball (3 sec)
	private long lastGhostMove; //the last time a ghost made a move
	private RefreshHandler updateHandler = new RefreshHandler(); //the handler to handle updating and drawing the board

	/**
	 * this constructor will take care of setting all of the resources and creating a new player/ghost
	 * this will also call the first instance of update and endlessly loop from there
	 * @param context
	 * @param board
	 */
	public GameCanvas(Context context, Board board)
	{
		super(context);
		this.board   = board;
		this.context = (Activity) context;
		this.player  = new Player(1, 1);
		this.blinky  = new Blinky(1, 29);
		this.plyr    = new Paint();
		this.ghost   = new Paint();
		this.closed  = new Paint();
		this.open    = new Paint();
		this.crump   = new Paint();
		plyr.setColor(getResources().getColor(R.color.player));
		ghost.setColor(getResources().getColor(R.color.ghost));
		closed.setColor(getResources().getColor(R.color.closed));
		open.setColor(getResources().getColor(R.color.open));
		crump.setColor(getResources().getColor(R.color.crump));
		setFocusable(true);
		this.setFocusableInTouchMode(true);
		this.lastGhostMove = System.currentTimeMillis();
		update();
	}

	/**
	 * A simple update function to handle moving entities and determining if a game is over
	 */
	public void update()
	{
		if (!board.gameOver() && !player.isDead())
		{
			if (System.currentTimeMillis() - lastGhostMove > Blinky.speedNormal) //if its the ghosts turn to move, then move
			{
				MoveGhost();
				lastGhostMove = System.currentTimeMillis();
			}
			if (player.hasPowerball()
					&& System.currentTimeMillis()
							- player.getPowerBallAquired() > powerballDur) //player has a powerball
				player.setHasPowerball(false);
			MovePlayer(player.getDirection());
			updateHandler.sleep(delay);
		}
		else
			gameOver();
	}

	/**
	 * A simple refresh handler to redraw the board and wait for a predetermined amount of time before redraw
	 */
	class RefreshHandler extends Handler
	{

		@Override
		public void handleMessage(Message msg)
		{
			invalidate();
			update();
		}

		public void sleep(long delayMillis)
		{
			this.removeMessages(0);
			sendMessageDelayed(obtainMessage(0), delayMillis);
		}
	};

	/* (non-Javadoc)
	 * @see android.view.View#onSizeChanged(int, int, int, int)
	 */
	protected void onSizeChanged(int w, int h, int oldw, int oldh)
	{
		width = w;
		height = h;
		cellWidth = width / board.getSizeX();
		cellHeight = height / board.getSizeY();
		super.onSizeChanged(w, h, oldw, oldh);
		/* NOTE: Does not handle rotation */
	}

	/* (non-Javadoc)
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	protected void onDraw(Canvas canvas)
	{
		canvas.drawRect(0, 0, width, height, open);
		//This is the main loop for drawing each tile of the board
		for (int i = 0; i < board.getSizeX(); i++)
		{
			for (int j = 0; j < board.getSizeY(); j++)
			{
				float x = i * cellWidth;
				float y = j * cellHeight;
				canvas.drawRect(x, y, x + cellWidth, y + cellHeight,
						board.isOpen(i, j) ? open : closed);
				if (board.hasCrump(i, j))
					canvas.drawCircle(x + cellWidth / 2, y + cellHeight / 2,
							cellWidth * 0.1f, crump);
				if (board.hasPowerball(i, j))
					canvas.drawCircle(x + cellWidth / 2, y + cellHeight / 2,
							cellWidth * 0.2f, crump);
			}
		}
		/* draw Pacman */
		canvas.drawCircle((player.getCurrentX() * cellWidth) + (cellWidth / 2), // x
																				// of
																				// center
				(player.getCurrentY() * cellHeight) + (cellWidth / 2), // y of
																		// center
				(cellWidth * 0.45f), // radius
				plyr);
		/* draw Blinky */
		canvas.drawCircle((blinky.getCurrentX() * cellWidth) + (cellWidth / 2), // x
				// of
				// center
				(blinky.getCurrentY() * cellHeight) + (cellWidth / 2), // y of
				// center
				(cellWidth * 0.45f), // radius
				player.hasPowerball() ? closed : ghost);
	}

	/* (non-Javadoc)
	 * @see android.view.View#onKeyDown(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent evt)
	{
		//Simple 4-directional based movement
		switch (keyCode)
		{
		case KeyEvent.KEYCODE_DPAD_UP:
			if (board.hasMove(player, Board.Move.UP))
				player.setDirection(Board.Move.UP);
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			if (board.hasMove(player, Board.Move.DOWN))
				player.setDirection(Board.Move.DOWN);
			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			if (board.hasMove(player, Board.Move.RIGHT))
			player.setDirection(Board.Move.RIGHT);
			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			if (board.hasMove(player, Board.Move.LEFT))
				player.setDirection(Board.Move.LEFT);
			break;
		default:
			return super.onKeyDown(keyCode, evt);
		}
		return true;
	}

	/**
	 * Game over will create an dialog window to inform the player the game is over
	 */
	void gameOver()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(context.getText(R.string.gameOverTitle));
		LayoutInflater inflater = context.getLayoutInflater();
		View view = inflater.inflate(R.layout.gameover, null);
		builder.setView(view);
		view.findViewById(R.id.closeGame).setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View clicked)
					{
						if (clicked.getId() == R.id.closeGame)
						{
							context.finish();
						}
					}
				});
		AlertDialog finishDialog = builder.create();
		finishDialog.show();
	}

	/**
	 * A simple function to move the player to a new tile based onthe direction he is moving now
	 * @param move
	 * @return moves the player in a specified direction if the direction is valid
	 */
	private void MovePlayer(Board.Move move)
	{
		if (board.hasMove(player, move))
		{
			player.makeMove(move, board);
		}
	}

	/**
	 * A simple function to move the ghost, basically move the ghost to the next tile that satisfies
	 * two major conditions, the path ahead is open, and it is not in the opposite direction that its
	 * currently moving (to prevent infinite loops of left, right or up, down)
	 * Also if the player has a powerball, simply pick the least optimal move that is possible
	 * Because of how I implemented the movement, the ghost can never make a 180 degree turn...
	 */
	private void MoveGhost()
	{
		int mv;
		Board.Move moves[] = blinky.blinkyMoves(player);
		if (moves == null)
			return;
		if (blinky.isDead()) //Blinky died, reset
		{
			blinky.setCurrentX(1);
			blinky.setCurrentY(29);
			blinky.setDead(false);
		}
		for (int i = 0; i < 4; i++) //Determine the best move from the list
		{
			mv = player.hasPowerball() ? 3 - i : i; //player has a powerball, pick from end of list
			if (player.hasPowerball() && board.hasMove(blinky, moves[mv]))
			{
				blinky.makeMove(moves[mv], board);
				break;
			}
			else if (board.hasMove(blinky, moves[mv]) && moves[mv] != Board.oppositeDir(blinky.getDirection()))
			{
				blinky.makeMove(moves[mv], board);
				break;
			}
		}
	}
}
