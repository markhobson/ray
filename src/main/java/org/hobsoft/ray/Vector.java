/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray;

/**
 * 
 */
public class Vector
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	public double x;
	
	public double y;
	
	public double z;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------
	
	public Vector()
	{
		this(0, 0, 0);
	}
	
	public Vector(Vector v)
	{
		this(v.x, v.y, v.z);
	}
	
	public Vector(double n)
	{
		this(n, n, n);
	}
	
	public Vector(double x, double y, double z)
	{
		set(x, y, z);
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------
	
	public Vector set(Vector v)
	{
		x = v.x;
		y = v.y;
		z = v.z;
		
		return this;
	}
	
	public Vector set(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		
		return this;
	}
	
	public Vector add(Vector v)
	{
		x += v.x;
		y += v.y;
		z += v.z;
		
		return this;
	}
	
	public Vector subtract(Vector v)
	{
		x -= v.x;
		y -= v.y;
		z -= v.z;
		
		return this;
	}
	
	public Vector subtract(double s, Vector v)
	{
		x -= s * v.x;
		y -= s * v.y;
		z -= s * v.z;
		
		return this;
	}
	
	public Vector scale(double s)
	{
		x *= s;
		y *= s;
		z *= s;
		
		return this;
	}
	
	public Vector divide(double s)
	{
		x /= s;
		y /= s;
		z /= s;
		
		return this;
	}
	
	public Vector rotate(Vector a)
	{
		return rotateX(a.x).rotateY(a.y).rotateZ(a.z);
	}
	
	public Vector rotateX(double a)
	{
		double sin = Math.sin(a);
		double cos = Math.cos(a);
		
		double oy = y;
		y = oy * cos - z * sin;
		z = oy * sin + z * cos;
		
		return this;
	}
	
	public Vector rotateY(double a)
	{
		double sin = Math.sin(a);
		double cos = Math.cos(a);
		
		double ox = x;
		x = ox * cos - z * sin;
		z = ox * sin + z * cos;
		
		return this;
	}
	
	public Vector rotateZ(double a)
	{
		double sin = Math.sin(a);
		double cos = Math.cos(a);
		
		double ox = x;
		x = ox * cos - y * sin;
		y = ox * sin + y * cos;
		
		return this;
	}
	
	public Vector unit()
	{
		double mod = Math.sqrt(x * x + y * y + z * z);
		
		x /= mod;
		y /= mod;
		z /= mod;
		
		return this;
	}
	
	public double mod()
	{
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	public double dot()
	{
		return x * x + y * y + z * z;
	}
	
	public double dot(Vector v)
	{
		return x * v.x + y * v.y + z * v.z;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Object methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public String toString()
	{
		return "(" + x + "," + y + "," + z + ")";
	}
}
