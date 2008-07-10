/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray.object;

import name.hobson.mark.ray.Material;
import name.hobson.mark.ray.Vector;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Plane extends AbstractObject
{
	private Vector n;
	private Vector q;

	public Plane(Vector p0, Vector n, Material material)
	{
		super(p0, material);
		this.n = n;
		
		q = new Vector();
	}
	
	/*
	 * @see name.hobson.mark.ray.Traceable#getIntersection(name.hobson.mark.ray.Vector, name.hobson.mark.ray.Vector)
	 */
	public double getIntersection(Vector u, Vector v)
	{
		/*
		 * intersection of ray:
		 *    p = u + vt
		 * with plane:
		 *    (p0 - p).n = 0
		 * solution t:
		 *    t = (p0 - u).n / v.n
		 */

		// d = v.n = 0 => no intersection 
		double d = v.dot(n);
		if (d == 0)
			return Double.NaN;
		
		// t = (p0 - u).n / d
		double t = q.set(p0).subtract(u).dot(n) / d;
		
		// 0 <= t <= 1 => intersection
		if (t < 0)
			return Double.NaN;

		return t;
	}

	/*
	 * @see name.hobson.mark.ray.Traceable#getNormal(name.hobson.mark.ray.Vector, name.hobson.mark.ray.Vector)
	 */
	public Vector getNormal(Vector p, Vector n)
	{
		return n.set(this.n);
	}
}
