/*
 * $HeadURL$
 *
 * (c) 2008 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray.material;

import name.hobson.mark.ray.Material;
import name.hobson.mark.ray.Vector;

/**
 * 
 *
 * @author	Mark Hobson
 * @version	$Id$
 */
public abstract class AbstractMaterial implements Material
{
	// constants --------------------------------------------------------------

	private final double opacity;
	
	private final double shine;
	
	private final int phong;
	
	// constructors -----------------------------------------------------------
	
	public AbstractMaterial()
	{
		this(0, 0, 0);
	}
	
	public AbstractMaterial(double opacity, double shine, int phong)
	{
		this.opacity = opacity;
		this.shine = shine;
		this.phong = phong;
	}
	
	// Material methods -------------------------------------------------------
	
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
