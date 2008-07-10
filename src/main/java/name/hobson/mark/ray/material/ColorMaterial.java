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
public class ColorMaterial implements Material
{
	// fields -----------------------------------------------------------------
	
	private final Color color;
	
	private final double opacity;
	
	private final double shine;
	
	private final int phong;
	
	// constructors -----------------------------------------------------------
	
	public ColorMaterial(Color color)
	{
		this(color, 0, 0, 0);
	}
	
	public ColorMaterial(Color color, double opacity, double shine, int phong)
	{
		this.color = color;
		this.opacity = opacity;
		this.shine = shine;
		this.phong = phong;
	}
	
	// Material methods -------------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	public Color getColor(Vector p)
	{
		return color;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public double getOpacity(Vector p)
	{
		return opacity;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public double getShine(Vector p)
	{
		return shine;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int getPhong(Vector p)
	{
		return phong;
	}
}
