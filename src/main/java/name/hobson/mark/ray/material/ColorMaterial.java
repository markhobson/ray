/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray.material;

import java.awt.Color;

import name.hobson.mark.ray.Vector;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
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
	public int getColor(Vector p)
	{
		return rgb;
	}
}
