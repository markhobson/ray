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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class Animator
{
	// ----------------------------------------------------------------------------------------------------------------
	// types
	// ----------------------------------------------------------------------------------------------------------------
	
	private class CircleTask implements Runnable
	{
		// ------------------------------------------------------------------------------------------------------------
		// fields
		// ------------------------------------------------------------------------------------------------------------
		
		private final Locatable object;
		
		private final Vector p0;
		
		private final Vector r;
		
		private final Vector da;
		
		private final Vector o;
		
		private final Vector a;
		
		// ------------------------------------------------------------------------------------------------------------
		// constructors
		// ------------------------------------------------------------------------------------------------------------
		
		public CircleTask(Locatable object, Vector p0, Vector r, Vector da)
		{
			this.object = object;
			this.p0 = p0;
			this.r = r;
			this.da = da;
			
			o = this.object.getOrigin();
			a = new Vector();
		}
		
		// ------------------------------------------------------------------------------------------------------------
		// Runnable methods
		// ------------------------------------------------------------------------------------------------------------
		
		@Override
		public void run()
		{
			// o = p0 + r rot a
			o.set(r).rotate(a).add(p0);
			
			a.add(da);
			update();
		}
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------

	private final ScenePanel panel;
	
	private final ScheduledExecutorService executor;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------

	public Animator(ScenePanel panel)
	{
		this.panel = panel;
		
		executor = Executors.newSingleThreadScheduledExecutor();
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------
	
	public void circleX(Locatable object, double r, double da, int period)
	{
		circle(object, new Vector(0, r, r), new Vector(da, 0, 0), period);
	}
	
	public void circleY(Locatable object, double r, double da, int period)
	{
		circle(object, new Vector(r, 0, r), new Vector(0, da, 0), period);
	}
	
	public void circleZ(Locatable object, double r, double da, int period)
	{
		circle(object, new Vector(r, r, 0), new Vector(0, 0, da), period);
	}
	
	public void circle(Locatable object, Vector r, Vector da, int period)
	{
		circle(object, new Vector(object.getOrigin()), r, da, period);
	}
	
	public void circle(Locatable object, Vector p0, Vector r, Vector da, int period)
	{
		executor.scheduleAtFixedRate(new CircleTask(object, p0, r, da), 0, period, TimeUnit.MILLISECONDS);
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// private methods
	// ----------------------------------------------------------------------------------------------------------------
	
	private void update()
	{
		panel.invalidate();
		panel.repaint(50);
	}
}
