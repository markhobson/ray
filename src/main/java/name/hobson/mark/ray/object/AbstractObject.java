/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray.object;

import name.hobson.mark.ray.Material;
import name.hobson.mark.ray.Positionable;
import name.hobson.mark.ray.Traceable;
import name.hobson.mark.ray.Vector;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public abstract class AbstractObject implements Positionable, Traceable
{
	// fields -----------------------------------------------------------------
	
	protected final Vector p0;
	
	protected final Material material;
	
	// constructors -----------------------------------------------------------

	public AbstractObject(Vector p0, Material material)
	{
		this.p0 = p0;
		this.material = material;
	}
	
	// Positionable methods ---------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	public Vector getOrigin()
	{
		return p0;
	}
	
	// Traceable methods ------------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	public Material getMaterial()
	{
		return material;
	}
}
