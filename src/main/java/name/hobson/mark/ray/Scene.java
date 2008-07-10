/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Scene
{
	private Color ambient;
	private List<Traceable> objects;
	private List<Light> lights;
	
	public Scene()
	{
		this(Color.BLACK);
	}
	
	public Scene(Color ambient)
	{
		this.ambient = ambient;
		objects = new ArrayList<Traceable>();
		lights = new ArrayList<Light>();
	}
	
	public Color getAmbient()
	{
		return ambient;
	}
	
	public void add(Traceable object)
	{
		objects.add(object);
	}
	
	public void remove(Traceable object)
	{
		objects.remove(object);
	}
	
	public void addLight(Light light)
	{
		lights.add(light);
	}
	
	public void removeLight(Light light)
	{
		lights.remove(light);
	}
	
	public Traceable getObject(int index)
	{
		return objects.get(index);
	}
	
	public int getObjectCount()
	{
		return objects.size();
	}
	
	public Traceable[] getObjects()
	{
		return objects.toArray(new Traceable[objects.size()]);
	}
	
	public Light getLight(int index)
	{
		return lights.get(index);
	}
	
	public int getLightCount()
	{
		return lights.size();
	}
	
	public Light[] getLights()
	{
		return lights.toArray(new Light[lights.size()]);
	}
}
