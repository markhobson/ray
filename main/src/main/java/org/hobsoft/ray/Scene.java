/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hobsoft.ray;

import java.awt.Color;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class Scene
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private final Color ambient;
	
	private final Set<Traceable> objects;
	
	private final Set<Light> lights;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------
	
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
	
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------
	
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
