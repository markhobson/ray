/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.awt.Color;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Sphere implements SceneObject
{
	private Vector p0;
	private double r;
	private Color color;
	
	private double rsq;
	private Vector q;

	public Sphere(double x0, double y0, double z0, double r, Color color)
	{
		this(new Vector(x0, y0, z0), r, color);
	}
	
	public Sphere(Vector p0, double r, Color color)
	{
		this.p0 = p0;
		this.r = r;
		this.color = color;
		
		rsq = r*r;
		q = new Vector();
	}
	
	public Vector getOrigin()
	{
		return p0;
	}
	
	public double getRadius()
	{
		return r;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public boolean intersects(Vector u, Vector v, Vector p)
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
		q.set(u);
		q.subtract(p0);

		// calculate quadratic coefficients
		double a = v.dot();
		double b = 2 * v.dot(q);
		double c = q.dot() - rsq;
		
		// complex solution => no intersection
		double d = b*b - 4*a*c;
		if (d <= 0)
			return false;
		
		// solve quadratic for t
		d = Math.sqrt(d);
		double t1 = (b > 0) ? (-b - d) / (2*a) : (-b + d) / (2*a);
		double t2 = c / (a*t1);
		
		if (t1 < 0 && t2 < 0)
			return false;
		
		// p1 = u + v*t1
		p.set(v);
		p.scale(t1);
		p.add(u);
		
		// p2 = u + v*t2
		q.set(v);
		q.scale(t2);
		q.add(u);
		
		// TODO: set p to proper closest to camera of p1 or p2
		if (q.z < p.z)
			p.set(q);
		
		return true;
	}
	
	public void getNormal(Vector p, Vector n)
	{
		n.set(p);
		n.subtract(p0);
	}
}
