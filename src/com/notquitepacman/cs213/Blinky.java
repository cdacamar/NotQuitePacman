/**
 * 
 */
package com.notquitepacman.cs213;

/**
 * @author Cameron
 * 
 */
public class Blinky extends Entity
{
	private boolean isDead;
	public static final long speedNormal = 200, speedSlow = 500;

	public Blinky(int x, int y)
	{
		this.setCurrentX(x);
		this.setCurrentY(y);
		this.setDirection(Board.Move.RIGHT);
		this.isDead = false;
	}

	/**
	 * 
	 * @return if the ghost is dead
	 */
	public boolean isDead()
	{
		return this.isDead;
	}

	/**
	 * this will set the ghost's isDead value
	 * 
	 * @param isDead
	 */
	public void setDead(boolean isDead)
	{
		this.isDead = isDead;
	}

	/**
	 * @author Cameron
	 * This is a really dumb but efficient pathfinding algorithm, basically finds the list of moves that will put you closer
	 * to the player
	 * @param player
	 * @return A list of optimal moves
	 */
	public Board.Move[] blinkyMoves(Player player)
	{

		int compX = player.getCurrentX() - this.getCurrentX(), 
			compY = player.getCurrentY() - this.getCurrentY();

		if (compX == 0 && compY == 0) //pacman dies or ghost dies
		{
			this.collide(player);
		}

		if (Math.abs(compX) > Math.abs(compY)) // Closer in the X direction
		{
			if (compX > 0)
			{
				if (compY < 0) // Player is up and right, favor right
					return new Board.Move[] { Board.Move.RIGHT, Board.Move.UP, Board.Move.DOWN, Board.Move.LEFT };
				else
					// Player is down and right, favor right
					return new Board.Move[] { Board.Move.RIGHT, Board.Move.DOWN, Board.Move.UP, Board.Move.LEFT };
			} else
			{
				if (compY < 0) // Player is up and left, favor left
					return new Board.Move[] { Board.Move.LEFT, Board.Move.UP, Board.Move.DOWN, Board.Move.RIGHT };
				else
					// Player is down and left, favor left
					return new Board.Move[] { Board.Move.LEFT, Board.Move.DOWN, Board.Move.UP, Board.Move.RIGHT };
			}
		} else
		// Player is closer in the Y direction
		{
			if (compX > 0)
			{
				if (compY < 0) // Player is up and right, favor down
					return new Board.Move[] { Board.Move.UP, Board.Move.RIGHT, Board.Move.LEFT, Board.Move.DOWN };
				else
					// Player is down and right, favor up
					return new Board.Move[] { Board.Move.DOWN, Board.Move.RIGHT, Board.Move.LEFT, Board.Move.UP };
			} else
			{
				if (compY < 0) // Player is up and left, favor down
					return new Board.Move[] { Board.Move.UP, Board.Move.LEFT, Board.Move.RIGHT, Board.Move.DOWN };
				else
					// Player is down and left, favor up
					return new Board.Move[] { Board.Move.DOWN, Board.Move.LEFT, Board.Move.RIGHT, Board.Move.UP };
			}
		}
	}

	/**
	 * if the player and ghost collide this will determine who dies
	 * 
	 * @param player
	 */
	public void collide(Player player)
	{

		if (player.hasPowerball())
		{
			this.setDead(true); // enemy dies
		} else
		{
			player.setDead(true); // player dies
		}
	}

}
