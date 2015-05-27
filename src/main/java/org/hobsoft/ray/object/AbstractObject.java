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
package org.hobsoft.ray.object;

import org.hobsoft.ray.Material;
import org.hobsoft.ray.Positionable;
import org.hobsoft.ray.Traceable;
import org.hobsoft.ray.Vector;

/**
 * 
 */
public abstract class AbstractObject implements Positionable, Traceable
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private final Vector p0;
	
	private final Material material;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------

	public AbstractObject(Vector p0, Material material)
	{
		this.p0 = p0;
		this.material = material;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Positionable methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public Vector getOrigin()
	{
		return p0;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Traceable methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public Material getMaterial()
	{
		return material;
	}
}
