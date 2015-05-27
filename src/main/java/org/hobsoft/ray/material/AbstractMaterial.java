/*
 * $HeadURL$
 *
 * (c) 2008 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray.material;

import org.hobsoft.ray.Material;
import org.hobsoft.ray.Vector;

/**
 * 
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
	@Override
	public double getOpacity(Vector p)
	{
		return opacity;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getShine(Vector p)
	{
		return shine;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPhong(Vector p)
	{
		return phong;
	}
}
