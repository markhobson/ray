/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Vector
{
	public double x;
	public double y;
	public double z;
	
	public Vector()
	{
		this(0, 0, 0);
	}
	
	public Vector(double x, double y, double z)
	{
		set(x, y, z);
	}
	
	public void set(Vector v)
	{
		set(v.x, v.y, v.z);
	}
	
	public void set(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;		
	}
	
	public void add(Vector v)
	{
		x += v.x;
		y += v.y;
		z += v.z;
	}
	
	public void subtract(Vector v)
	{
		x -= v.x;
		y -= v.y;
		z -= v.z;
	}
	
	public void scale(double s)
	{
		x *= s;
		y *= s;
		z *= s;
	}
	
	public void unit()
	{
		double mod = Math.sqrt(x*x + y*y + z*z);
		x /= mod;
		y /= mod;
		z /= mod;
	}
	
	public double mod()
	{
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	public double dot()
	{
		return x*x + y*y + z*z;
	}
	
	public double dot(Vector v)
	{
		return x*v.x + y*v.y + z*v.z;
	}
	
	@Override
	public String toString()
	{
		return "(" + x + "," + y + "," + z + ")";
	}
}
