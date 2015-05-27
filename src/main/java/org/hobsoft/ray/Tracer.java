/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray;

/**
 * 
 */
public class Tracer
{
	// ----------------------------------------------------------------------------------------------------------------
	// constants
	// ----------------------------------------------------------------------------------------------------------------
	
	private static final boolean SHADOWS = true;
	
	private static final Pixel EMPTY_PIXEL = new Pixel();
	
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private final Scene scene;
	
	private final Traceable[] objects;
	
	private final Light[] lights;
	
	private final Vector p;
	
	private final Vector u;
	
	private final Vector v;
	
	private final Vector n;
	
	private final Vector l;
	
	private final Pixel pixel;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------
	
	public Tracer(Scene scene)
	{
		this.scene = scene;
		
		objects = this.scene.getObjects().toArray(new Traceable[0]);
		lights = this.scene.getLights().toArray(new Light[0]);
		
		p = new Vector();
		u = new Vector();
		v = new Vector();
		n = new Vector();
		l = new Vector();
		pixel = new Pixel();
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------
	
	public void trace(int[] pixels, int width, int height)
	{
		int x0 = width / 2;
		int y0 = height / 2;
		int i = 0;
		
		for (double y = 0; y < height; y++)
		{
			for (double x = 0; x < width; x++)
			{
				u.set(0, 50, 0);
				v.set(x - x0, 50 + y0 - y, 500);
				
				pixels[i++] = getPixel(u, v, null).getRGB();
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// private methods
	// ----------------------------------------------------------------------------------------------------------------

	private Pixel getPixel(Vector u, Vector v, Traceable current)
	{
		Traceable closest = null;
		double minT = Double.MAX_VALUE;
		
		double t;
		
		for (Traceable object : objects)
		{
			if (object != current && !Double.isNaN((t = object.getIntersection(u, v))) && (t < minT))
			{
				minT = t;
				closest = object;
			}
		}

		if (closest == null)
		{
			return EMPTY_PIXEL;
		}

		// p = u + v t_min
		p.set(v).scale(minT).add(u);
		
		// n = unit normal at p
		closest.getNormal(p, n).unit();

		Material material = closest.getMaterial();

		// ambient light
		pixel.set(scene.getAmbient());
		
		// set u = unit(v) for phong
		int phong = material.getPhong(p);
		u.set(v).unit();
		
		for (Light light : lights)
		{
			// l = l0 - p;
			l.set(light.getOrigin()).subtract(p);

			if (!SHADOWS || !intersects(p, l, closest))
			{
				l.unit();
				
				// diffuse reflection
				
				double d = n.dot(l);
				
				if (d > 0)
				{
					pixel.mix(light.getColor(), d);
				}
				
				// phong illumination
				
				if (phong > 0)
				{
					d = l.subtract(2 * l.dot(n), n).dot(u);
					
					if (d > 0)
					{
						pixel.mix(light.getColor(), pow(d, phong));
					}
				}
			}
		}
		
		pixel.scale(material.getColor(p));
		
		double shine = material.getShine(p);
		
		if (shine == 0)
		{
			return pixel;
		}
		
		// u = p
		u.set(p);
		
		// v = v - (2*v.n)n
		v.subtract(2 * v.dot(n), n);

		Pixel newPixel = new Pixel(pixel.getRGB());
		newPixel.mix(getPixel(u, v, closest).getRGB(), shine);
		return newPixel;

//		getPixel(u, v, object);
//		return pixel;
	}

	private boolean intersects(Vector u, Vector v, Traceable current)
	{
		for (Traceable object : objects)
		{
			if (object != current && !Double.isNaN(object.getIntersection(u, v)))
			{
				return true;
			}
		}
		
		return false;
	}
	
	private static double pow(double a, int b)
	{
		double c = 1;
		
		while (b-- > 0)
		{
			c *= a;
		}
		
		return c;
	}
}
