/**
 * 
 */
package com.notquitepacman.cs213;

import java.io.Serializable;

/**
 * @author Cameron
 * 
 */
public class Tile implements Serializable
{
	private static final long serialVersionUID = 9002L; /*
														 * ITS... also... OVER
														 * 9000!!!!
														 */

	public static enum Terrain //Types of terrain
	{
		Open, Closed, Special //Special is never used but could come in handy
	};

	private boolean hasCrump, hasPowerball;
	private Terrain type;

	/**
	 * Simple constructor
	 * @param hasCrump
	 * @param hasPowerball
	 * @param type
	 */
	public Tile(boolean hasCrump, boolean hasPowerball, Tile.Terrain type)
	{
		this.hasCrump = hasCrump;
		this.hasPowerball = hasPowerball;
		this.type = type;
	}

	/**
	 * @return the hasCrump
	 */
	public boolean hasCrump()
	{
		return hasCrump;
	}

	/**
	 * @param hasCrump
	 *            the hasCrump to set
	 */
	public void setHasCrump(boolean hasCrump)
	{
		this.hasCrump = hasCrump;
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
	 * @return the type
	 */
	public Terrain getType()
	{
		return type;
	}
}
