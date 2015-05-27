/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray;

import java.awt.Color;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Scene
{
	// fields -----------------------------------------------------------------
	
	private final Color ambient;
	
	private final Set<Traceable> objects;
	
	private final Set<Light> lights;
	
	// constructors -----------------------------------------------------------
	
	public Scene()
	{
		this(Color.BLACK);
	}
	
	public Scene(Color ambient)
	{
		this.ambient = ambient;
		
		objects = new HashSet<>();
		lights = new HashSet<>();
	}
	
	// public methods ---------------------------------------------------------
	
	public Color getAmbient()
	{
		return ambient;
	}
	
	public void addObject(Traceable object)
	{
		objects.add(object);
	}
	
	public void removeObject(Traceable object)
	{
		objects.remove(object);
	}
	
	public Set<Traceable> getObjects()
	{
		return Collections.unmodifiableSet(objects);
	}
	
	public void addLight(Light light)
	{
		lights.add(light);
	}
	
	public void removeLight(Light light)
	{
		lights.remove(light);
	}
	
	public Set<Light> getLights()
	{
		return Collections.unmodifiableSet(lights);
	}
}
