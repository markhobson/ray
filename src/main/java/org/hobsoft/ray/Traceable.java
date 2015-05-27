/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray;

/**
 * 
 */
public interface Traceable
{
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------

	double getIntersection(Vector u, Vector v);
	
	Vector getNormal(Vector p, Vector n);
	
	Material getMaterial();
}
