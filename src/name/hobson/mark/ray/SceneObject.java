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
public interface SceneObject
{
	boolean intersects(Vector u, Vector v, Vector p);
	
	void getNormal(Vector p, Vector n);
	
	Color getColor();
}
