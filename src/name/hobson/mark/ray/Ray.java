/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Ray extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private Sphere s1;
	private Sphere s2;
	private Sphere s3;
	private Light l1;
	private Light l2;
	
	private class AnimationTimerTask extends TimerTask
	{
		private double a = 0;
		
		@Override
		public void run()
		{
			l1.getOrigin().set(500*Math.cos(a), 500, 2000 + 500*Math.sin(a));
			l2.getOrigin().set(0, -500*Math.cos(a*2), 2000 + 500*Math.sin(a*2));
			s2.getOrigin().set(200 * Math.cos(-a*15/9), 100, 2000 + 200*Math.sin(-a*15/9));
			s3.getOrigin().set(400 * Math.cos(a*17/27), -150, 2000 + 400*Math.sin(a*17/27));
			a += 2 * Math.PI / 360; 
			
			getContentPane().invalidate();
			getContentPane().repaint(50);
		}	
	}
	
	public Ray()
	{
		super("Ray");
		
		setLocationByPlatform(true);
		setSize(320, 256);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		Scene scene = new Scene();
		s1 = new Sphere(0, -150, 2000, 200, Color.WHITE);
		scene.add(s1);
		s2 = new Sphere(200, 100, 2000, 100, Color.WHITE);
		scene.add(s2);
		s3 = new Sphere(400, -150, 2000, 50, Color.WHITE);
		scene.add(s3);
		l1 = new Light(500, 500, 2000, Color.YELLOW);
		scene.addLight(l1);
		l2 = new Light(0, -500, 2000, Color.BLUE);
		scene.addLight(l2);
		scene.addLight(new Light(-500, -100, 1600, Color.RED));
		
		setContentPane(new ScenePanel(scene));
		
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(new AnimationTimerTask(), 0, 50);
	}
	
	public static void main(String[] args)
	{
		new Ray().setVisible(true);
	}
}
