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
			if (object != current)
			{
				t = object.getIntersection(u, v);
				
				if (!Double.isNaN(t) && (t < minT))
				{
					minT = t;
					closest = object;
				}
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

		applyLight(u, v, closest);
		
		Material material = closest.getMaterial();

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
	}

	private void applyLight(Vector u, Vector v, Traceable closest)
	{
		// ambient light
		pixel.set(scene.getAmbient());
		
		// set u = unit(v) for phong
		Material material = closest.getMaterial();
		int phong = material.getPhong(p);
		u.set(v).unit();
		
		for (Light light : lights)
		{
			// l = l0 - p;
			l.set(light.getOrigin()).subtract(p);

			if (!SHADOWS || !intersects(p, l, closest))
			{
				l.unit();
				
				applyDiffuse(light);
				applyPhong(light, phong, u);
			}
		}
	}

	private void applyDiffuse(Light light)
	{
		// diffuse reflection
		
		double d = n.dot(l);
		
		if (d > 0)
		{
			pixel.mix(light.getColor(), d);
		}
	}

	private void applyPhong(Light light, int phong, Vector u)
	{
		// phong illumination
		
		if (phong > 0)
		{
			double d = l.subtract(2 * l.dot(n), n).dot(u);
			
			if (d > 0)
			{
				pixel.mix(light.getColor(), pow(d, phong));
			}
		}
	}

	/**
	 * Returns whether the specified ray intersects any scene object, optionally ignoring a specified one.
	 * <p>
	 * The ray is specified by the line <b>p</b> = <b>u</b> + <b>v</b><i>t</i>.
	 * 
	 * @param u
	 *            the vector <b>u</b> of the ray
	 * @param v
	 *            the vector <b>v</b> of the ray
	 * @param ignore
	 *            the scene object to ignore, or {@code null} to consider all scene objects
	 * @return {@code true} if the specified ray intersects a scene object, {@code false} otherwise
	 */
	private boolean intersects(Vector u, Vector v, Traceable ignore)
	{
		for (Traceable object : objects)
		{
			if (object != ignore && !Double.isNaN(object.getIntersection(u, v)))
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
