/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray.material;

import java.awt.Color;

import name.hobson.mark.ray.Material;
import name.hobson.mark.ray.Vector;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class DefaultMaterial implements Material
{
	private Color color;
	private double opacity;
	private double shine;
	private int phong;
	
	public DefaultMaterial(Color color)
	{
		this(color, 0, 0, 0);
	}
	
	public DefaultMaterial(Color color, double opacity, double shine, int phong)
	{
		this.color = color;
		this.opacity = opacity;
		this.shine = shine;
		this.phong = phong;
	}
	
	public Color getColor(Vector p)
	{
		return color;
	}
	
	public double getOpacity(Vector p)
	{
		return opacity;
	}
	
	public double getShine(Vector p)
	{
		return shine;
	}
	
	public int getPhong(Vector p)
	{
		return phong;
	}
}
