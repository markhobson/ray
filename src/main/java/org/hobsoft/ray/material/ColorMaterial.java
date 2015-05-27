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

import java.awt.Color;

import org.hobsoft.ray.Vector;

/**
 * 
 */
public class ColorMaterial extends AbstractMaterial
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private final int rgb;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------
	
	public ColorMaterial(Color color)
	{
		this(color, 0, 0, 0);
	}
	
	public ColorMaterial(Color color, double opacity, double shine, int phong)
	{
		super(opacity, shine, phong);
		
		rgb = color.getRGB();
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Material methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public int getColor(Vector p)
	{
		return rgb;
	}
}
