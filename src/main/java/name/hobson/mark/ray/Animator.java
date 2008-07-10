/*
 * $HeadURL$
 *
 * (c) 2006 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Animator
{
	// classes ----------------------------------------------------------------
	
	private class CircleTask extends TimerTask
	{
		// fields -------------------------------------------------------------
		
		private final Positionable object;
		
		private final Vector p0;
		
		private final Vector r;
		
		private final Vector da;
		
		private final Vector o;
		
		private final Vector a;
		
		// constructors -------------------------------------------------------
		
		public CircleTask(Positionable object, Vector p0, Vector r, Vector da)
		{
			this.object = object;
			this.p0 = p0;
			this.r = r;
			this.da = da;
			
			o = this.object.getOrigin();
			a = new Vector();
		}
		
		// Runnable methods ---------------------------------------------------
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void run()
		{
			// o = p0 + r rot a
			o.set(r).rotate(a).add(p0);
			
			a.add(da);
			update();
		}
	}
	
	// fields -----------------------------------------------------------------

	private final ScenePanel panel;
	
	private final Timer timer;
	
	// constructors -----------------------------------------------------------

	public Animator(ScenePanel panel)
	{
		this.panel = panel;
		
		timer = new Timer(true);
	}
	
	// public methods ---------------------------------------------------------
	
	public void circleX(Positionable object, double r, double da, int period)
	{
		circle(object, new Vector(0, r, r), new Vector(da, 0, 0), period);
	}
	
	public void circleY(Positionable object, double r, double da, int period)
	{
		circle(object, new Vector(r, 0, r), new Vector(0, da, 0), period);
	}
	
	public void circleZ(Positionable object, double r, double da, int period)
	{
		circle(object, new Vector(r, r, 0), new Vector(0, 0, da), period);
	}
	
	public void circle(Positionable object, Vector r, Vector da, int period)
	{
		circle(object, new Vector(object.getOrigin()), r, da, period);
	}
	
	public void circle(Positionable object, Vector p0, Vector r, Vector da, int period)
	{
		timer.scheduleAtFixedRate(new CircleTask(object, p0, r, da), 0, period);
	}
	
	// private methods --------------------------------------------------------
	
	private void update()
	{
		panel.invalidate();
		panel.repaint(50);
	}
}
