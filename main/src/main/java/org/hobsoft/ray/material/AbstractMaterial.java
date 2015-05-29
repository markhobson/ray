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
package org.hobsoft.ray.material;

import org.hobsoft.ray.Material;
import org.hobsoft.ray.Vector;

/**
 * 
 */
public abstract class AbstractMaterial implements Material
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------

	private final double opacity;
	
	private final double shine;
	
	private final int phong;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------
	
	public AbstractMaterial()
	{
		this(0, 0, 0);
	}
	
	public AbstractMaterial(double opacity, double shine, int phong)
	{
		this.opacity = opacity;
		this.shine = shine;
		this.phong = phong;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Material methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public double getOpacity(Vector p)
	{
		return opacity;
	}
	
	@Override
	public double getShine(Vector p)
	{
		return shine;
	}
	
	@Override
	public int getPhong(Vector p)
	{
		return phong;
	}
}
