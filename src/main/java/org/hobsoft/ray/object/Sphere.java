/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray.object;

import org.hobsoft.ray.Material;
import org.hobsoft.ray.Vector;

/**
 * 
 */
public class Sphere extends AbstractObject
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private final double r;
	
	private final double rsq;
	
	private final Vector q;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------

	public Sphere(Vector p0, double r, Material material)
	{
		super(p0, material);
		
		this.r = r;
		
		rsq = r * r;
		q = new Vector();
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Traceable methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public double getIntersection(Vector u, Vector v)
	{
		/*
		 * intersection of ray:
		 *    p = u + vt
		 * with sphere:
		 *    (p - p0)^2 = r^2
		 * solution t:
		 *    (v.v)t^2 + 2(q.v)t + (q.q - r^2) = 0, where q = u - p0
		 * quadratic with:
		 *    a = v.v
		 *    b = 2v.q
		 *    c = q.q - r^2
		 */

		// q = u - p0
		
		q.set(u).subtract(p0);

		// calculate quadratic coefficients
		
		double a = v.dot();
		double b = 2 * v.dot(q);
		double c = q.dot() - rsq;
		
		// complex solution => no intersection
		
		double d = b * b - 4 * a * c;
		
		if (d <= 0)
		{
			return Double.NaN;
		}
		
		// solve quadratic for t
		
		d = Math.sqrt(d);
		double t1 = (b > 0) ? (-b - d) / (2 * a) : (-b + d) / (2 * a);
		double t2 = c / (a * t1);
		
		if (t1 < 0 && t2 < 0)
		{
			return Double.NaN;
		}
		
		return (t1 < t2) ? t1 : t2;
	}
	
	@Override
	public Vector getNormal(Vector p, Vector n)
	{
		return n.set(p).subtract(p0);
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------
	
	public double getRadius()
	{
		return r;
	}

	// ----------------------------------------------------------------------------------------------------------------
	// Object methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public String toString()
	{
		return getClass().getName() + "[p0=" + p0 + ",r=" + r + "]";
	}
}
