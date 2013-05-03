/**
 * 
 */
package com.notquitepacman.cs213;

/**
 * @author Cameron
 * Basic entity class to keep track of attributes common to entities
 */
public abstract class Entity
{
	private int currentX, currentY;
	private Board.Move direction;

	/**
	 * @return the currentX
	 */
	public int getCurrentX()
	{
		return currentX;
	}

	/**
	 * @param currentX the currentX to set
	 */
	public void setCurrentX(int currentX)
	{
		this.currentX = currentX;
	}

	/**
	 * @return the currentY
	 */
	public int getCurrentY()
	{
		return currentY;
	}

	/**
	 * @param currentY the currentY to set
	 */
	public void setCurrentY(int currentY)
	{
		this.currentY = currentY;
	}

	/**
	 * @return the direction currently moving
	 */
	public Board.Move getDirection()
	{
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Board.Move direction)
	{
		this.direction = direction;
	}
	
	/**
	 * Moves an entity
	 * @param move
	 * @param board
	 */
	public void makeMove(Board.Move move, Board board)
	{
		switch (move)
		{
		case UP:
			this.setCurrentY(this.getCurrentY() - 1);
			setDirection(Board.Move.UP);
			break;
		case DOWN:
			this.setCurrentY(this.getCurrentY() + 1);
			setDirection(Board.Move.DOWN);
			break;
		case LEFT:
			if (this.getCurrentX() == 0 && this.getCurrentY() == 14) //special tunnel case
				this.setCurrentX(board.getSizeX() - 1);
			else
				this.setCurrentX(this.getCurrentX() - 1);
			setDirection(Board.Move.LEFT);
			break;
		case RIGHT:
			if (this.getCurrentX() == board.getSizeX() - 1
					&& this.getCurrentY() == 14) //special tunnel case
				this.setCurrentX(0);
			else
				this.setCurrentX(this.getCurrentX() + 1);
			setDirection(Board.Move.RIGHT);
			break;
		}
	}
}
