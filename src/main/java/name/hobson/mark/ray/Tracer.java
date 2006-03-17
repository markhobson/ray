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
public class Tracer
{
	private static final int EMPTY_PIXEL = Color.BLACK.getRGB();
	
	private Scene scene;
	private SceneObject[] objects;
	private Light[] lights;
	
	private Vector p;
	private Vector q;
	private Vector n;
	private Vector l;
	private Pixel pixel;
	
	public Tracer(Scene scene)
	{
		this.scene = scene;
		
		objects = this.scene.getObjects();
		lights = this.scene.getLights();
		
		p = new Vector();
		q = new Vector();
		n = new Vector();
		l = new Vector();
		pixel = new Pixel();
	}
	
	public void trace(int[] pixels, int width, int height)
	{
		Vector u = new Vector();
		Vector v = new Vector(0, 0, 500);
		
		int w = width / 2;
		int h = height / 2;
		int i = 0;
		for (double y = h; y > -h; y--)
		{
			v.y = y;

			for (double x = -w; x < w; x++)
			{
				v.x = x;
				pixels[i++] = getPixel(u, v);
			}
		}
	}

	private int getPixel(Vector u, Vector v)
	{
		SceneObject object = null;
		p.z = Double.MAX_VALUE;

		int count = objects.length;
		for (int i = 0; i < count; i++)
		{
			SceneObject thisObject = objects[i];
			// TODO: use proper nearest object to camera
			if (thisObject.intersects(u, v, q) && q.z < p.z)
			{
				object = thisObject;
				p.set(q);
			}
		}

		if (object == null)
			return EMPTY_PIXEL;

		object.getNormal(p, n);
		n.unit();

		pixel.set(0xFF, 0, 0, 0);
		count = lights.length;
		for (int i = 0; i < count; i++)
		{
			Light light = lights[i];
			l.set(light.getOrigin());
			l.subtract(p);

			if (!intersects(p, l, q, object))
			{
				l.unit();
				double d = n.dot(l);
				if (d > 0)
					pixel.mix(light.getColor().getRGB(), d);
			}
		}

		return pixel.getRGB();
	}

	private boolean intersects(Vector u, Vector v, Vector p, SceneObject o)
	{
		int count = objects.length;
		for (int i = 0; i < count; i++)
		{
			SceneObject thisObject = objects[i];
			if (o != thisObject && thisObject.intersects(u, v, p))
				return true;
		}
		return false;
	}
}
