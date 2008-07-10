/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;


/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public interface Traceable
{
	double getIntersection(Vector u, Vector v);
	
	Vector getNormal(Vector p, Vector n);
	
	Material getMaterial();
}