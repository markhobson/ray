/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray;

import java.awt.Color;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Light implements Positionable
{
	// fields -----------------------------------------------------------------
	
	private final Vector p0;
	
	private final Color color;
	
	// constructors -----------------------------------------------------------
	
	public Light(Vector p0, Color color)
	{
		this.p0 = p0;
		this.color = color;
	}
	
	// Positionable methods ---------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	public Vector getOrigin()
	{
		return p0;
	}
	
	// public methods ---------------------------------------------------------
	
	public Color getColor()
	{
		return color;
	}
}
