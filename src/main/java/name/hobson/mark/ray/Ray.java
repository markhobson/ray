/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import name.hobson.mark.ray.material.ColorMaterial;
import name.hobson.mark.ray.object.Plane;
import name.hobson.mark.ray.object.Sphere;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class Ray extends JFrame
{
	// constants --------------------------------------------------------------
	
	private static final double DEGREE = 2 * Math.PI / 360;
	
	// constructors -----------------------------------------------------------
	
	public Ray()
	{
		super("Ray");
		
		setLocationByPlatform(true);
		setSize(320, 256);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Scene scene = new Scene(new Color(48, 48, 48));

		Plane ground = new Plane(new Vector(), new Vector(0, 1, 0), new ColorMaterial(Color.GREEN));
		scene.addObject(ground);
		
		Sphere s1 = new Sphere(new Vector(0, 300, 2000), 150, new ColorMaterial(Color.RED, 0, 0.5, 50));
		scene.addObject(s1);
		
		Sphere s2 = new Sphere(new Vector(0, 300, 2000), 100, new ColorMaterial(Color.YELLOW, 0, 0.5, 50));
		scene.addObject(s2);
		
		Sphere s3 = new Sphere(new Vector(0, 300, 2000), 50, new ColorMaterial(Color.BLUE, 0, 0.5, 50));
		scene.addObject(s3);
		
		Light l1 = new Light(new Vector(-500, 500, 1000), Color.DARK_GRAY);
		scene.addLight(l1);
		
		Light l2 = new Light(new Vector(0, 500, 2000), Color.GRAY);
		scene.addLight(l2);
		
		ScenePanel panel = new ScenePanel(scene);
		Animator animator = new Animator(panel);

		animator.circleY(s2, 200, DEGREE, 20);
		animator.circleY(s3, 300, -DEGREE, 20);
		animator.circleY(l2, 300, -DEGREE, 30);
		
		setContentPane(panel);
	}
	
	// main -------------------------------------------------------------------
	
	public static void main(String[] args)
	{
		new Ray().setVisible(true);
	}
}
