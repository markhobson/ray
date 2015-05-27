/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray.material;

import java.awt.Color;

import org.hobsoft.ray.Vector;

/**
 * 
 */
public class ColorMaterial extends AbstractMaterial
{
	// fields -----------------------------------------------------------------
	
	private final int rgb;
	
	// constructors -----------------------------------------------------------
	
	public ColorMaterial(Color color)
	{
		this(color, 0, 0, 0);
	}
	
	public ColorMaterial(Color color, double opacity, double shine, int phong)
	{
		super(opacity, shine, phong);
		
		rgb = color.getRGB();
	}
	
	// Material methods -------------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getColor(Vector p)
	{
		return rgb;
	}
}
