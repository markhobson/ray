/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

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
	private List<SceneObject> objects;
	private List<Light> lights;
	
	public Scene()
	{
		objects = new ArrayList<SceneObject>();
		lights = new ArrayList<Light>();
	}
	
	public void add(SceneObject object)
	{
		objects.add(object);
	}
	
	public void remove(SceneObject object)
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
	
	public SceneObject getObject(int index)
	{
		return objects.get(index);
	}
	
	public int getObjectCount()
	{
		return objects.size();
	}
	
	public SceneObject[] getObjects()
	{
		return objects.toArray(new SceneObject[objects.size()]);
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
