/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import name.hobson.mark.ray.material.DefaultMaterial;
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
	private static final double DEGREE = 2 * Math.PI / 360;
	private static final long serialVersionUID = 1L;
	
	public Ray()
	{
		super("Ray");
		
		setLocationByPlatform(true);
		setSize(320, 256);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		Scene scene = new Scene(new Color(48, 48, 48));

		Plane ground = new Plane(new Vector(), new Vector(0, 1, 0), new DefaultMaterial(Color.GREEN));
		scene.add(ground);
		
		Sphere s1 = new Sphere(new Vector(0, 300, 2000), 150, new DefaultMaterial(Color.RED, 0, 0.5, 50));
		scene.add(s1);
		
		Sphere s2 = new Sphere(new Vector(0, 300, 2000), 100, new DefaultMaterial(Color.YELLOW, 0, 0.5, 50));
		scene.add(s2);
		
		Sphere s3 = new Sphere(new Vector(0, 300, 2000), 50, new DefaultMaterial(Color.BLUE, 0, 0.5, 50));
		scene.add(s3);
		
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
	
	public static void main(String[] args)
	{
		new Ray().setVisible(true);
	}
}
