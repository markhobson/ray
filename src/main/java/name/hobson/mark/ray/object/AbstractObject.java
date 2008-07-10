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
	protected Vector p0;
	protected Material material;

	public AbstractObject(Vector p0, Material material)
	{
		this.p0 = p0;
		this.material = material;
	}
	
	/*
	 * @see name.hobson.mark.ray.Positionable#getOrigin()
	 */
	public Vector getOrigin()
	{
		return p0;
	}
	
	/*
	 * @see name.hobson.mark.ray.Traceable#getMaterial()
	 */
	public Material getMaterial()
	{
		return material;
	}
}
