/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray;

/**
 * 
 */
public interface Material
{
	int getColor(Vector p);
	
	double getOpacity(Vector p);
	
	double getShine(Vector p);
	
	int getPhong(Vector p);
}
