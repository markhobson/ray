/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.awt.Color;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Pixel
{
	private int a;
	private int r;
	private int g;
	private int b;
	
	public Pixel()
	{
		this(Color.BLACK);
	}
	
	public Pixel(Color color)
	{
		this(color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue());
	}
	
	public Pixel(int a, int r, int g, int b)
	{
		set(a, r, g, b);
	}
	
	public void set(int a, int r, int g, int b)
	{
		this.a = a;
		this.r = r;
		this.g = g;
		this.b = b;		
	}

	public void mix(int rgb, double brightness)
	{
		r += ((rgb >> 16) & 0xFF) * brightness;
		g += ((rgb >> 8) & 0xFF) * brightness;
		b += (rgb & 0xFF) * brightness;
	}
	
	public int getRGB()
	{
		if (r > 0xFF)
			r = 0xFF;
		if (g > 0xFF)
			g = 0xFF;
		if (b > 0xFF)
			b = 0xFF;
		return (a << 24) | (r << 16) | (g << 8) | b;		
	}
}
