/**
 * 
 */
package com.notquitepacman.cs213;

/**
 * @author Cameron
 * 
 */
public class Player extends Entity
{
	private boolean isDead, hasPowerball;
	private long powerBallAquired;

	public Player(int x, int y)
	{
		this.setCurrentX(x);
		this.setCurrentY(y);
		this.setDirection(Board.Move.UP);
		this.isDead       = false;
		this.hasPowerball = false;
	}

	/**
	 * @return the isDead
	 */
	public boolean isDead()
	{
		return isDead;
	}

	/**
	 * @param isDead
	 *            the isDead to set
	 */
	public void setDead(boolean isDead)
	{
		this.isDead = isDead;
	}

	/**
	 * @return the hasPowerball
	 */
	public boolean hasPowerball()
	{
		return hasPowerball;
	}

	/**
	 * @param hasPowerball
	 *            the hasPowerball to set
	 */
	public void setHasPowerball(boolean hasPowerball)
	{
		this.hasPowerball = hasPowerball;
	}

	/**
	 * Simply makes a move, doesn't have to check if the tile is open.
	 * sets the crump attribute and sets has powerball if there is a powerball
	 * in this tile
	 * @param move
	 * @param board
	 */
	@Override
	public void makeMove(Board.Move move, Board board)
	{
		super.makeMove(move, board);
		board.setHasCrump(this.getCurrentX(), this.getCurrentY(), false);
		if (board.hasPowerball(this.getCurrentX(), this.getCurrentY()))
		{
			board.setHasPowerball(this.getCurrentX(), this.getCurrentY(), false);
			this.hasPowerball = true;
			this.setPowerBallAquired(System.currentTimeMillis());
		}
	}

	/**
	 * @return the powerBallAquired
	 */
	public long getPowerBallAquired()
	{
		return powerBallAquired;
	}

	/**
	 * sets the time at which a powerball was aquired
	 * @param powerBallAquired the powerBallAquired to set
	 */
	public void setPowerBallAquired(long powerBallAquired)
	{
		this.powerBallAquired = powerBallAquired;
	}
}
