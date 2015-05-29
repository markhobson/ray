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

/**
 * 
 */
public class Light implements Locatable
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private final Vector p0;
	
	private final Color color;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------
	
	public Light(Vector p0, Color color)
	{
		this.p0 = p0;
		this.color = color;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Locatable methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public Vector getOrigin()
	{
		return p0;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------
	
	public Color getColor()
	{
		return color;
	}
}
