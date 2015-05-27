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
public class Pixel
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private int r;
	
	private int g;
	
	private int b;
	
	private int a;

	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------
	
	public Pixel()
	{
		this(Color.BLACK);
	}
	
	public Pixel(Color color)
	{
		this(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
	}
	
	public Pixel(int rgb)
	{
		this((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF);
	}
	
	public Pixel(int r, int g, int b)
	{
		this(r, g, b, 0xFF);
	}
	
	public Pixel(int r, int g, int b, int a)
	{
		set(r, g, b, a);
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------
	
	public Pixel clear()
	{
		return set(0, 0, 0, 0xFF);
	}
	
	public Pixel set(Color color)
	{
		return set(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
	}
	
	public Pixel set(int r, int g, int b, int a)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		
		return this;
	}

	public Pixel mix(Color color, double brightness)
	{
		return mix(color.getRGB(), brightness);
	}
	
	public Pixel mix(int rgb, double brightness)
	{
		r += ((rgb >> 16) & 0xFF) * brightness;
		g += ((rgb >> 8) & 0xFF) * brightness;
		b += (rgb & 0xFF) * brightness;
		
		return this;
	}
	
	public Pixel scale(int rgb)
	{
		r *= (double) ((rgb >> 16) & 0xFF) / 0xFF;
		g *= (double) ((rgb >> 8) & 0xFF) / 0xFF;
		b *= (double) (rgb & 0xFF) / 0xFF;
		
		return this;
	}
	
	public int getRGB()
	{
		if (r > 0xFF)
		{
			r = 0xFF;
		}
		
		if (g > 0xFF)
		{
			g = 0xFF;
		}
		
		if (b > 0xFF)
		{
			b = 0xFF;
		}
		
		return (a << 24) | (r << 16) | (g << 8) | b;
	}
	
	public Color toColor()
	{
		return new Color(getRGB());
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Object methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public String toString()
	{
		return getClass().getName() + "[r=" + r + ",g=" + g + ",b=" + b + ",a=" + a + "]";
	}
}
