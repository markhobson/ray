/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package name.hobson.mark.ray;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.MemoryImageSource;

import javax.swing.JComponent;

/**
 * 
 * 
 * @author	Mark Hobson
 * @version	$Id$
 */
public class ScenePanel extends JComponent
{
	private static final long serialVersionUID = 1L;
	
	private Scene scene;
	private Tracer tracer;
	private Dimension size;
	private int[] pixels;
	private MemoryImageSource imageSource;
	private Image image;
	private String text;
	
	public ScenePanel(Scene scene)
	{
		this.scene = scene;
		tracer = new Tracer(scene);		
	}
	
	public Scene getScene()
	{
		return scene;
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		if (image == null)
			createImage();

		graphics.drawImage(image, 0, 0, this);

		graphics.setColor(Color.WHITE);
		graphics.drawString(text, 0, 12);
	}
	
	@Override
	public void invalidate()
	{
		super.invalidate();
		image = null;
	}
	
	private void createImage()
	{
		if (size == null)
		{
			size = getSize();
			pixels = new int[size.width * size.height];
			imageSource = new MemoryImageSource(size.width, size.height, pixels, 0, size.width);
		}

		long time = System.nanoTime();
		tracer.trace(pixels, size.width, size.height);
		time = System.nanoTime() - time;
		text = (time == 0) ? "? fps" : (1000000000 / time) + " fps";

		image = createImage(imageSource);
	}
}
