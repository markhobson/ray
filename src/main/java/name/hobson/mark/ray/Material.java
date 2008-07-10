/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.awt.Color;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public interface Material
{
	Color getColor(Vector p);
	
	double getOpacity(Vector p);
	
	double getShine(Vector p);
	
	int getPhong(Vector p);
}
