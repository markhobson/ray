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
public class Light
{
	private Vector p0;
	private Color color;
	
	public Light(double x0, double y0, double z0, Color color)
	{
		this(new Vector(x0, y0, z0), color);
	}
	
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
