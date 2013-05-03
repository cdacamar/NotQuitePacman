/**
 * 
 */
package com.notquitepacman.cs213;

import java.io.Serializable;

/**
 * @author Cameron
 * 
 */
public class Board implements Serializable
{
	private static final long serialVersionUID = 9001L; /* ITS OVER 9000!!!! */
	private static final short m_board[][] = new short[][] {
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
		{ 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
		{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
		{ 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
		{ 0, 2, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2, 0 },
		{ 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
		{ 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
		{ 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0 },
		{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
		{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
		{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	private Tile[][] board;
	private int sizeX, sizeY, numCrumps;

	public static enum Move //Possible moves
	{
		UP, DOWN, LEFT, RIGHT
	};

	/**
	 * @return a static board to construct
	 */
	public static short[][] getBoard()
	{
		return m_board;
	}

	/**
	 * constructor builds a tile board based on the static board
	 */
	public Board()
	{
		numCrumps = 0;
		sizeX = 28;
		sizeY = 31;
		board = new Tile[sizeY][sizeX];
		for (int i = 0; i < sizeY; i++)
		{
			for (int j = 0; j < sizeX; j++)
			{
				switch (Board.getBoard()[i][j])
				{
				case 0:
					board[i][j] = new Tile(false, false, Tile.Terrain.Closed);
					break;
				case 1:
					board[i][j] = new Tile(true, false, Tile.Terrain.Open);
					numCrumps++;
					break;
				case 2:
					board[i][j] = new Tile(false, true, Tile.Terrain.Open);
					break;
				}
			}
		}
	}

	/**
	 * @return gets the entire board
	 */
	public Tile[][] getTileBoard()
	{
		return board;
	}

	/**
	 * @param x
	 * @param y
	 * @return returns a specific tile
	 */
	public Tile getTile(int x, int y)
	{
		return board[y][x];
	}

	/**
	 * @param x
	 * @param y
	 * @return tells if the tile is walkable or not
	 */
	public boolean isOpen(int x, int y)
	{
		return board[y][x].getType() == Tile.Terrain.Open ? true : false;
	}

	/**
	 * @param x
	 * @param y
	 * @return tells if the board at x, y has a crump
	 */
	public boolean hasCrump(int x, int y)
	{
		return board[y][x].hasCrump();
	}

	/**
	 * @param x
	 * @param y
	 * @return tells if the board at x, y has a powerball
	 */
	public boolean hasPowerball(int x, int y)
	{
		return board[y][x].hasPowerball();
	}

	/**
	 * sets the status of a crump at tile x, y
	 * @param x
	 * @param y
	 * @param status
	 */
	public void setHasCrump(int x, int y, boolean status)
	{
		if (!status && hasCrump(x, y))
			numCrumps--;
		board[y][x].setHasCrump(status);
	}

	/**
	 * sets the status of a powerball at tile x, y
	 * @param x
	 * @param y
	 * @param status
	 */
	public void setHasPowerball(int x, int y, boolean status)
	{
		board[y][x].setHasPowerball(status);
	}

	/**
	 * @return the size of the board in the x direction
	 */
	public int getSizeX()
	{
		return sizeX;
	}

	/**
	 * @return the size of the board in the y direction
	 */
	public int getSizeY()
	{
		return sizeY;
	}

	/**
	 * @return the status of the number of crumps on the board
	 */
	public boolean gameOver()
	{
		return numCrumps <= 0 ? true : false;
	}

	/**
	 * @return returns the number of crumps remaining on the board
	 */
	public int getNumCrumps()
	{
		return numCrumps;
	}
	
	/**
	 * @param move
	 * @return the opposite direction of a move
	 */
	public static Move oppositeDir(Move move)
	{
		switch (move)
		{
			case RIGHT: return Move.LEFT;
			case LEFT: return Move.RIGHT;
			case UP: return Move.DOWN;
			case DOWN: return Move.UP;
		}
		return null;
	}

	/**
	 * @param entity
	 * @param direction
	 * @return an indicator as to wither a move is possible or not
	 */
	public boolean hasMove(Entity entity, Move direction)
	{
		boolean moved = false;
		switch (direction)
		{
		case UP:
			if (entity.getCurrentY() != 0
					&& this.isOpen(entity.getCurrentX(),
							entity.getCurrentY() - 1))
				moved = true;
			break;
		case DOWN:
			if (entity.getCurrentX() < this.getSizeY() - 1
					&& this.isOpen(entity.getCurrentX(),
							entity.getCurrentY() + 1))
				moved = true;
			break;
		case LEFT:
			if (entity.getCurrentX() != 0
					&& this.isOpen(entity.getCurrentX() - 1,
							entity.getCurrentY()) || entity.getCurrentY() == 14 && entity.getCurrentX() == 0) //special tunnel case
				moved = true;
			break;
		case RIGHT:
			if (entity.getCurrentX() < this.getSizeX() - 1
					&& this.isOpen(entity.getCurrentX() + 1,
							entity.getCurrentY()) || entity.getCurrentY() == 14 && entity.getCurrentX() == sizeX - 1) //special tunnel case
				moved = true;
			break;
		}
		return moved;
	}
}