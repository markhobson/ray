/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.awt.Color;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Light implements Positionable
{
	private Vector p0;
	private Color color;
	
	public Light(Vector p0, Color color)
	{
		this.p0 = p0;
		this.color = color;
	}
	
	public Vector getOrigin()
	{
		return p0;
	}
	
	public Color getColor()
	{
		return color;
	}
}
